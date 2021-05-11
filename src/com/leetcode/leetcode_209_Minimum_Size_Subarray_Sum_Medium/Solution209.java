package com.leetcode.leetcode_209_Minimum_Size_Subarray_Sum_Medium;

abstract class Solution209 {
    public abstract int minSubArrayLen(int target, int[] nums);

    static Solution209 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution209 {
        @Override
        public int minSubArrayLen(int target, int[] nums) {
            int min = 0;
            for (int i = 0; i < nums.length; i++) {
                int len = helper(target, nums, i);
                if (len > 0 && (len < min || min == 0)) {
                    min = len;
                }
            }
            return min;
        }

        private int helper(int target, int[] nums, int l) {
            if (l == nums.length) {
                return 0;
            } else if (nums[l] >= target) {
                return 1;
            }
            int len = helper(target - nums[l], nums, l + 1);
            return len > 0 ? len + 1 : 0;
        }
    }

    private static class S2 extends Solution209 {
        @Override
        public int minSubArrayLen(int target, int[] nums) {
            int min = nums.length + 1;
            int sum = 0;
            for (int l = 0, r = 0; r < nums.length;) {
                if (sum + nums[r] >= target) {
                    min = Math.min(min, r - l + 1);
                    sum -= nums[l];
                    l++;
                    if (r < l) {
                        r = l;
                    }
                } else {
                    sum += nums[r];
                    r++;
                }
            }
            return min > nums.length ? 0 : min;
        }
    }

    private static class S3 extends Solution209 {
        @Override
        public int minSubArrayLen(int target, int[] nums) {
            int min = nums.length + 1;
            for (int l = 0, r = 0; r < nums.length; r++) {
                target -= nums[r];
                while (target <= 0) {
                    min = Math.min(min, r - l + 1);
                    target += nums[l++];
                }
            }
            return min > nums.length ? 0 : min;
        }
    }
}
