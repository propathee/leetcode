package com.leetcode.leetcode_680_Valid_Palindrome_II_Easy;

abstract class Solution680 {
    public abstract boolean validPalindrome(String s);

    static Solution680 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution680 {
        @Override
        public boolean validPalindrome(String s) {
            for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return isPalindrome(s.substring(i, j)) || isPalindrome(s.substring(i + 1, j + 1));
                }
            }
            return true;
        }

        private boolean isPalindrome(String s) {
            for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class S2 extends Solution680 {
        @Override
        public boolean validPalindrome(String s) {
            return helper(s.toCharArray(), 0, s.length() - 1, 1);
        }

        private boolean helper(char[] chars, int i, int j, int countdown) {
            if (i >= j) {
                return true;
            }
            if (chars[i] == chars[j]) {
                return helper(chars, i + 1, j - 1, countdown);
            } else {
                return countdown > 0 && (helper(chars, i + 1, j, countdown - 1) || helper(chars, i, j - 1, countdown - 1));
            }
        }
    }
}