package com.leetcode.leetcode_696_Count_Binary_Substrings_Easy;

abstract class Solution696 {
    public abstract int countBinarySubstrings(String s);

    static Solution696 newSolution() {
        return new S6();
    }

    private static class S1 extends Solution696 {
        private int res = 0;

        @Override
        public int countBinarySubstrings(String s) {
            helper(s.toCharArray(), 0, 0);
            return res;
        }

        private void helper(char[] chars, int start, int prev) {
            if (start >= chars.length) {
                return;
            }
            int nextStart = start;
            while (nextStart < chars.length && chars[nextStart] == chars[start]) {
                nextStart++;
            }
            res += Math.min(prev, nextStart - start);
            helper(chars, nextStart, nextStart - start);
        }
    }

    private static class S2 extends Solution696 {
        @Override
        public int countBinarySubstrings(String s) {
            return helper(s.toCharArray(), 0, 0);
        }

        private int helper(char[] chars, int start, int prev) {
            if (start >= chars.length) {
                return 0;
            }
            int nextStart = start;
            char c = chars[start];
            while (nextStart < chars.length && chars[nextStart] == c) {
                nextStart++;
            }
            return Math.min(prev, nextStart - start)
                + helper(chars, nextStart, nextStart - start);
        }
    }

    private static class S3 extends Solution696 {
        @Override
        public int countBinarySubstrings(String s) {
            int res = 0, preLen = 0, p = 0, q = 0;
            char[] chars = s.toCharArray();
            while (q < chars.length) {
                while (q < chars.length && chars[p] == chars[q]) {
                    q++;
                }
                int curLen = q - p;
                res += Math.min(curLen, preLen);
                preLen = curLen;
                p = q;
            }
            return res;
        }
    }

    private static class S4 extends Solution696 {
        @Override
        public int countBinarySubstrings(String s) {
            int res = 0, preLen = 0;
            char[] chars = s.toCharArray();
            for (int p = 0, q = 0; q <= chars.length; q++) {
                if (q == chars.length || chars[q] != chars[p]) {
                    res += Math.min(preLen, q - p);
                    preLen = q - p;
                    p = q;
                }
            }
            return res;
        }
    }

    private static class S5 extends Solution696 {
        @Override
        public int countBinarySubstrings(String s) {
            int res = 0, pre = 0, cur = 1;
            char[] chars = s.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == chars[i - 1]) {
                    cur++;
                } else {
                    res += Math.min(cur, pre);
                    pre = cur;
                    cur = 1;
                }
            }
            return res + Math.min(cur, pre);
        }
    }

    private static class S6 extends Solution696 {
        @Override
        public int countBinarySubstrings(String s) {
            int res = 0, pre = 0, cur = 1;
            char[] chars = s.toCharArray();
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == chars[i - 1]) {
                    cur++;
                } else {
                    pre = cur;
                    cur = 1;
                }
                if (pre >= cur) {
                    res++;
                }
            }
            return res;
        }
    }
}
