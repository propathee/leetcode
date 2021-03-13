package com.leetcode.leetcode_942_DI_String_Match_Easy;

abstract class Solution942 {
    public abstract int[] diStringMatch(String S);

    static Solution942 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution942 {
        @Override
        public int[] diStringMatch(String S) {
            int[] res = new int[S.length() + 1];
            int min = 0, max = S.length();
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == 'I') {
                    res[i] = min++;
                } else {
                    res[i] = max--;
                }
            }
            res[S.length()] = max;
            return res;
        }
    }

    private static class S2 extends Solution942 {
        @Override
        public int[] diStringMatch(String S) {
            int n = S.length(), left = 0, right = n;
            int[] res = new int[n + 1];
            for (int i = 0; i < n; i++) {
                res[i] = S.charAt(i) == 'I' ? left++ : right--;
            }
            res[S.length()] = right;
            return res;
        }
    }
}
