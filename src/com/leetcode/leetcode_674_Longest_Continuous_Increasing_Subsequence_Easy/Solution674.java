package com.leetcode.leetcode_674_Longest_Continuous_Increasing_Subsequence_Easy;

abstract class Solution674 {
    public abstract int findLengthOfLCIS(int[] nums);

    static Solution674 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution674 {
        @Override
        public int findLengthOfLCIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int res = 1;
            int len = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    len++;
                } else {
                    res = Math.max(res, len);
                    len = 1;
                }
            }
            return Math.max(res, len);
        }
    }

    private static class S2 extends Solution674 {
        @Override
        public int findLengthOfLCIS(int[] nums) {
            int res = 0, len = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] > nums[i - 1]) {
                    res = Math.max(res, ++len);
                } else {
                    len = 1;
                }
            }
            return res;
        }
    }

    private static class S3 extends Solution674 {
        @Override
        public int findLengthOfLCIS(int[] nums) {
            int res = 0;
            for (int p = 0, q = 0; q < nums.length; q++) {
                if (p == q || nums[q] > nums[q - 1]) {
                    res = Math.max(res, q - p + 1);
                } else {
                    p = q;
                }
            }
            return res;
        }
    }

    private static class S4 extends Solution674 {
        @Override
        public int findLengthOfLCIS(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 1;
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

    private static class S5 extends Solution674 {
        @Override
        public int findLengthOfLCIS(int[] nums) {
            int[] dp = new int[nums.length];
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] <= nums[i - 1]) {
                    dp[i] = 1;
                } else {
                    dp[i] = dp[i - 1] + 1;
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
