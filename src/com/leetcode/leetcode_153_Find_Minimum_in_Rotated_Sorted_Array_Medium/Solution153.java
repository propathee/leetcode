package com.leetcode.leetcode_153_Find_Minimum_in_Rotated_Sorted_Array_Medium;

abstract class Solution153 {
    public abstract int findMin(int[] nums);

    static Solution153 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution153 {
        @Override
        public int findMin(int[] nums) {
            if (nums[0] <= nums[nums.length - 1]) {
                return nums[0];
            }
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    return nums[i];
                }
            }
            return 0;
        }
    }

    private static class S2 extends Solution153 {
        @Override
        public int findMin(int[] nums) {
            return findMin(nums, 0, nums.length - 1);
        }

        public int findMin(int[] nums, int l, int r) {
            if (r - l == 0 || nums[l] < nums[r])  {
                return nums[l];
            }
            int mid = (l + r) / 2;
            if (nums[mid] >= nums[l]) {
                l = mid + 1;
            } else {
                r = mid;
            }
            return findMin(nums, l, r);
        }
    }

    private static class S3 extends Solution153 {
        @Override
        public int findMin(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r && nums[r] < nums[l]) {
                int mid = (l + r) / 2;
                if (nums[mid] >= nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return nums[l];
        }
    }
}
