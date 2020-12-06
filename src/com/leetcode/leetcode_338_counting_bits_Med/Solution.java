package com.leetcode.leetcode_338_counting_bits_Med;

class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        int base = 1;
        for (int i = 1; i <= num; i++) {
            if (i >= base * 2) {
                base *= 2;
            }
            dp[i] = dp[i - base] + 1;
        }
        return dp;
    }

    public int[] countBits_1(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++)
            dp[i] = dp[i >> 1] + (i & 1);
        return dp;
    }
}