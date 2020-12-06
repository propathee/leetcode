package com.leetcode.leetcode_322_coin_change_Med;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = -1;
            for (int c : coins) {
                if (i - c >= 0 && dp[i - c] > -1) {
                    dp[i] = Math.min(dp[i - c] + 1, dp[i] != -1 ? dp[i] : Integer.MAX_VALUE);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}