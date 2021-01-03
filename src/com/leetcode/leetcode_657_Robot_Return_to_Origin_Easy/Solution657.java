package com.leetcode.leetcode_657_Robot_Return_to_Origin_Easy;

abstract class Solution657 {
    public abstract boolean judgeCircle(String moves);

    static Solution657 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution657 {
        @Override
        public boolean judgeCircle(String moves) {
            int[] count = new int[4];
            for (char c : moves.toCharArray()) {
                if (c == 'U') {
                    count[0]++;
                } else if (c == 'D') {
                    count[1]++;
                } else if (c == 'L') {
                    count[2]++;
                } else {
                    count[3]++;
                }
            }
            return count[0] == count[1] && count[2] == count[3];
        }
    }

    private static class S2 extends Solution657 {
        @Override
        public boolean judgeCircle(String moves) {
            int x = 0, y = 0;
            for (char c : moves.toCharArray()) {
                if (c == 'U') {
                    y++;
                } else if (c == 'D') {
                    y--;
                } else if (c == 'R') {
                    x++;
                } else {
                    x--;
                }
            }
            return x == 0 && y == 0;
        }
    }

    private static class S3 extends Solution657 {
        @Override
        public boolean judgeCircle(String moves) {
            int[] count = new int[26];
            for (char c : moves.toCharArray()) {
                count[c - 'A']++;
            }
            return count['U' - 'A'] == count['D' - 'A']
                && count['L' - 'A'] == count['R' - 'A'];
        }
    }
}
