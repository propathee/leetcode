package com.leetcode.leetcode_724_Find_Pivot_Index_Easy;

abstract class Solution724 {
    public abstract int pivotIndex(int[] nums);

    static Solution724 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution724 {
        @Override
        public int pivotIndex(int[] nums) {
            int sumL = 0, sumR = 0;
            for (int n : nums) {
                sumR += n;
            }
            for (int i = 0; i < nums.length; i++) {
                sumR -= nums[i];
                if (sumL == sumR) {
                    return i;
                }
                sumL += nums[i];
            }
            return -1;
        }
    }

    private static class S2 extends Solution724 {
        @Override
        public int pivotIndex(int[] nums) {
            int sum = 0, left = 0;
            for (int n : nums) {
                sum += n;
            }
            for (int i = 0; i < nums.length; i++) {
                if (sum - left - nums[i] == left) {
                    return i;
                }
                left += nums[i];
            }
            return -1;
        }
    }
}
