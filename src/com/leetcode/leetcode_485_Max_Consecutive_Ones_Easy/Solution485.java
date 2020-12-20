package com.leetcode.leetcode_485_Max_Consecutive_Ones_Easy;

abstract class Solution485 {
    /**
     * Given a binary array, find the maximum number of consecutive 1s in this array.
     * The input array will only contain 0 and 1.
     * The length of input array is a positive integer and will not exceed 10,000
     */
    public abstract int findMaxConsecutiveOnes(int[] nums);

    static Solution485 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution485 {
        @Override
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            int tmp = 0;
            for (int n : nums) {
                if (n == 1) {
                    tmp++;
                } else {
                    max = Math.max(tmp, max);
                    tmp = 0;
                }
            }
            return Math.max(max, tmp);
        }
    }

    private static class S2 extends Solution485 {
        @Override
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            int tmp = 0;
            for (int n : nums) {
                if (n == 1) {
                    tmp++;
                    max = Math.max(max, tmp);
                } else {
                    tmp = 0;
                }
            }
            return max;
        }
    }

    private static class S3 extends Solution485 {
        @Override
        public int findMaxConsecutiveOnes(int[] nums) {
            int max = 0;
            int cnt = 0;
            for (int n : nums) {
                cnt = cnt * n + n;
                max = Math.max(max, cnt);
            }
            return max;
        }
    }
}
