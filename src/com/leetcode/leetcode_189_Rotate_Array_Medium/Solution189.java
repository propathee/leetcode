package com.leetcode.leetcode_189_Rotate_Array_Medium;

abstract class Solution189 {
    public abstract void rotate(int[] nums, int k);

    static Solution189 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution189 {
        @Override
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            int[] tmp = new int[k];
            for (int i = 0; i < k; i++) {
                tmp[i] = nums[nums.length - k + i];
            }
            for (int i = nums.length - 1; i >= k; i--) {
                nums[i] = nums[i - k];
            }
            for (int i = 0; i < k; i++) {
                nums[i] = tmp[i];
            }
        }
    }

    private static class S2 extends Solution189 {
        @Override
        public void rotate(int[] nums, int k) {
            int[] numsCopy = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                numsCopy[i] = nums[i];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[(i + k) % nums.length] = numsCopy[i];
            }
        }
    }

    private static class S3 extends Solution189 {
        @Override
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }

        private void reverse(int[] nums, int from, int to) {
            for (; from < to; from++, to--) {
                int tmp = nums[from];
                nums[from] = nums[to];
                nums[to] = tmp;
            }
        }
    }
}
