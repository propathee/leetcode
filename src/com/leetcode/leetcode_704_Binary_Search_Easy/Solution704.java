package com.leetcode.leetcode_704_Binary_Search_Easy;

abstract class Solution704 {
    /**
     * You may assume that all elements in nums are unique.
     * The value of each element in nums will be in the range [-9999, 9999].
     */
    public abstract int search(int[] nums, int target);

    static Solution704 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution704 {
        @Override
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int m = (l + r) / 2;
                if (nums[m] == target) {
                    return m;
                } else if (nums[m] > target) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return nums[l] == target ? l : -1;
        }
    }

    private static class S2 extends Solution704 {
        @Override
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (nums[m] == target) {
                    return m;
                } else if (nums[m] > target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            return -1;
        }
    }

    private static class S3 extends Solution704 {
        @Override
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l + 1 < r) {
                int m = (l + r) / 2;
                if (nums[m] == target) {
                    return m;
                } else if (nums[m] > target) {
                    r = m;
                } else {
                    l = m;
                }
            }
            return nums[l] == target ? l : nums[r] == target ? r : -1;
        }
    }
}
