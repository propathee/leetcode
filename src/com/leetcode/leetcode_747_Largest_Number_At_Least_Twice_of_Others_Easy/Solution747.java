package com.leetcode.leetcode_747_Largest_Number_At_Least_Twice_of_Others_Easy;

abstract class Solution747 {
    public abstract int dominateIndex(int[] nums);

    static Solution747 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution747 {
        @Override
        public int dominateIndex(int[] nums) {
            if (nums.length == 1) {
                return 0;
            }
            int top1 = 0, top2 = -1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > nums[top1]) {
                    top2 = top1;
                    top1 = i;
                } else if (top2 < 0 || nums[i] > nums[top2]) {
                    top2 = i;
                }
            }
            return nums[top1] >= nums[top2] * 2 ? top1 : -1;
        }
    }

    private static class S2 extends Solution747 {
        @Override
        public int dominateIndex(int[] nums) {
            int max = -1, index = -1, second = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > max) {
                    second = max;
                    max = nums[i];
                    index = i;
                } else if (nums[i] > second) {
                    second = nums[i];
                }
            }
            return max >= 2 * second ? index : -1;
        }
    }
}
