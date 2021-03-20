package com.leetcode.leetcode_977_Squares_of_a_Sorted_Array_Easy;

import java.util.Arrays;

abstract class Solution977 {
    public abstract int[] sortedSquares(int[] nums);

    static Solution977 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution977 {
        @Override
        public int[] sortedSquares(int[] nums) {
            int [] res = new int[nums.length];
            int idx = findFirstIndexOfPositiveNum(nums);
            for (int i = 0, p = idx - 1, q = idx; i < nums.length; i++) {
                if (p < 0) {
                    res[i] = nums[q] * nums[q];
                    q++;
                } else if (q >= nums.length) {
                    res[i] = nums[p] * nums[p];
                    p--;
                } else {
                    if (nums[p] + nums[q] < 0) {
                        res[i] = nums[q] * nums[q];
                        q++;
                    } else {
                        res[i] = nums[p] * nums[p];
                        p--;
                    }
                }
            }
            return res;
        }

        private int findFirstIndexOfPositiveNum(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return i;
                }
            }
            return nums.length;
        }
    }

    private static class S2 extends Solution977 {
        @Override
        public int[] sortedSquares(int[] nums) {
            int [] res = new int[nums.length];
            int idx = findFirstIndexOfPositiveNum(nums);
            for (int i = 0, p = idx - 1, q = idx; i < nums.length; i++) {
                if (p < 0 || (q < nums.length && nums[p] + nums[q] < 0)) {
                    res[i] = nums[q] * nums[q];
                    q++;
                } else {
                    res[i] = nums[p] * nums[p];
                    p--;
                }
            }
            return res;
        }

        private int findFirstIndexOfPositiveNum(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return i;
                }
            }
            return nums.length;
        }
    }

    private static class S3 extends Solution977 {
        @Override
        public int[] sortedSquares(int[] nums) {
            int[] res = new int[nums.length];
            for (int left = 0, right = nums.length - 1, i = nums.length - 1; i >= 0; i--) {
                if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                    res[i] = nums[left] * nums[left];
                    left++;
                } else {
                    res[i] = nums[right] * nums[right];
                    right--;
                }
            }
            return res;
        }
    }

    private static class S4 extends Solution977 {
        @Override
        public int[] sortedSquares(int[] nums) {
            return Arrays.stream(nums).map(n -> n * n).sorted().toArray();
        }
    }
}
