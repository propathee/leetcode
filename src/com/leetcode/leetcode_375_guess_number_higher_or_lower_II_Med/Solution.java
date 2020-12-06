package com.leetcode.leetcode_375_guess_number_higher_or_lower_II_Med;

class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return DP(dp, 1, n);
    }

    public int DP(int[][] t, int s, int e) {
        if (s >= e)
            return 0;
        if (t[s][e] > 0)
            return t[s][e];
        int res = Integer.MAX_VALUE;
        for (int x = s; x < e; x++) {
            int tmp = x + Math.max(DP(t, s, x - 1), DP(t, x + 1, e));
            res = Math.min(tmp, res);
        }
        t[s][e] = res;
        return res;
    }

    public int getMoneyAmount_1(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 2; j <= n; j++) {
            for (int i = j - 1; i > 0; i--) {
                int res = Integer.MAX_VALUE;
                for (int x = i; x < j; x++) {
                    int tmp = x + Math.max(dp[i][x - 1], dp[x + 1][j]);
                    res = Math.min(tmp, res);
                }
                dp[i][j] = res;
            }
        }
        return dp[1][n];
    }
}