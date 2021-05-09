package com.leetcode.leetcode_162_Find_Peak_Element_Medium;

abstract class Solution162 {
    public abstract int findPeakElement(int[] nums);

    static Solution162 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution162 {
        @Override
        public int findPeakElement(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if ((i == 0 || nums[i] > nums[i - 1]) && (i == nums.length - 1 || nums[i] > nums[i + 1])) {
                    return i;
                }
            }
            return 0;
        }
    }

    private static class S2 extends Solution162 {
        @Override
        public int findPeakElement(int[] nums) {
            if (nums.length == 1 || nums[0] > nums[1]) {
                return 0;
            } else if (nums[nums.length - 1] > nums[nums.length - 2]) {
                return nums.length - 1;
            }
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
            }
            return 0;
        }
    }

    private static class S3 extends Solution162 {
        @Override
        public int findPeakElement(int[] nums) {
            int l = 0, r = nums.length - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] < nums[mid + 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }

    private static class S4 extends Solution162 {
        @Override
        public int findPeakElement(int[] nums) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    return i - 1;
                }
            }
            return nums.length - 1;
        }
    }
}
