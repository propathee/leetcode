package com.leetcode.leetcode_744_Find_Smallest_Letter_Greater_Than_Target_Easy;

abstract class Solution744 {
    public abstract char nextGreatestLetter(char[] letters, char target);

    static Solution744 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution744 {
        @Override
        public char nextGreatestLetter(char[] letters, char target) {
            for (char c : letters) {
                if (c > target) {
                    return c;
                }
            }
            return letters[0];
        }
    }

    private static class S2 extends Solution744 {
        @Override
        public char nextGreatestLetter(char[] letters, char target) {
            if (target >= letters[letters.length - 1]) {
                return letters[0];
            }
            int l = 0, r = letters.length - 1;
            while (l < r) {
                int m = (l + r) / 2;
                if (letters[m] > target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            return letters[l] > target ? letters[l] : letters[l + 1];
        }
    }

    private static class S3 extends Solution744 {
        @Override
        public char nextGreatestLetter(char[] letters, char target) {
            int l = 0, r = letters.length;
            while (l < r) {
                int m = (l + r) / 2;
                if (letters[m] > target) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return letters[r % letters.length];
        }
    }
}
