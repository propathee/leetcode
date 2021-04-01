package com.leetcode.leetcode_96_unique_binary_search_trees_Medium;

abstract class Solution96 {
    public abstract int numTrees(int n);

    static Solution96 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution96 {
        @Override
        public int numTrees(int n) {
            if (n <= 1) {
                return 1;
            }
            int num = 0;
            for (int i = 1; i <= n; i++) {
                int leftNum = numTrees(i - 1);
                int rightNum = numTrees(n - i);
                num += leftNum * rightNum;
            }
            return num;
        }
    }

    private static class S2 extends Solution96 {
        @Override
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }
}
