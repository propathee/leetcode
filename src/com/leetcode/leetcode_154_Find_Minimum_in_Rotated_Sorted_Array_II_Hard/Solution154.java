package com.leetcode.leetcode_154_Find_Minimum_in_Rotated_Sorted_Array_II_Hard;

abstract class Solution154 {
    public abstract int findMin(int[] nums);

    static Solution154 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution154 {
        @Override
        public int findMin(int[] nums) {
            return findMin(nums, 0, nums.length - 1);
        }

        private int findMin(int[] nums, int l, int r) {
            while (l < r && nums[l] >= nums[r]) {
                int mid = l + (r - l) / 2;
                if (nums[mid] > nums[l]) {
                    l = mid + 1;
                } else if (nums[mid] < nums[l]){
                    r = mid;
                } else {
                    return Math.min(findMin(nums, l, mid), findMin(nums, mid + 1, r));
                }
            }
            return nums[l];
        }
    }

    private static class S2 extends Solution154 {
        @Override
        public int findMin(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r && nums[l] >= nums[r]) {
                int mid = l + (r - l) / 2;
                if (nums[mid] > nums[l]) {
                    l = mid + 1;
                } else if (nums[mid] < nums[l]){
                    r = mid;
                } else {
                    l++;
                }
            }
            return nums[l];
        }
    }

    private static class S3 extends Solution154 {
        @Override
        public int findMin(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r && nums[l] >= nums[r]) {
                int mid = l + (r - l) / 2;
                if (nums[mid] > nums[r]) {
                    l = mid + 1;
                } else if (nums[mid] < nums[r]) {
                    r = mid;
                } else {
                    r--;
                }
            }
            return nums[l];
        }
    }

    private static class S4 extends Solution154 {
        @Override
        public int findMin(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] > nums[r]) {
                    l = mid + 1;
                } else if (nums[mid] < nums[r]) {
                    r = mid;
                } else {
                    r--;
                }
            }
            return nums[l];
        }
    }

    private static class S5 extends Solution154 {
        @Override
        public int findMin(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] > nums[r]) {
                    l = mid + 1;
                } else if (nums[mid] < nums[l]) {
                    r = mid;
                } else {
                    r--;
                }
            }
            return nums[l];
        }
    }
}
