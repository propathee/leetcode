package com.leetcode.leetcode_645_Set_Mismatch_Easy;

import java.util.HashSet;
import java.util.Set;

abstract class Solution645 {
    public abstract int[] findErrorNums(int[] nums);

    static Solution645 newSolution() {
        return new S7();
    }

    private static class S1 extends Solution645 {
        @Override
        public int[] findErrorNums(int[] nums) {
            Set<Integer> set = new HashSet<>();
            int duplicate = 0;
            long sum = 0;
            for (int n : nums) {
                if (!set.add(n)) {
                    duplicate = n;
                }
                sum += n;
            }
            int missing = (int) ((1 + nums.length) * nums.length / 2 - sum + duplicate);
            return new int[] {duplicate, missing};
        }
    }

    private static class S2 extends Solution645 {
        @Override
        public int[] findErrorNums(int[] nums) {
            int[] dict = new int[nums.length + 1];
            for (int n : nums) {
                dict[n]++;
            }
            int[] res = new int[2];
            for (int i = 1; i < dict.length; i++) {
                if (dict[i] == 2) {
                    res[0] = i;
                } else if (dict[i] == 0) {
                    res[1] = i;
                }
            }
            return res;
        }
    }

    private static class S3 extends Solution645 {
        @Override
        public int[] findErrorNums(int[] nums) {
            int duplicate = 0;
            for (int i = 0; i < nums.length;) {
                if (nums[i] - 1 != i) {
                    if (nums[i] == nums[nums[i] - 1]) {
                        duplicate = nums[i];
                        i++;
                    } else {
                        swap(nums, i, nums[i] - 1);
                    }
                } else {
                    i++;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] - 1 != i) {
                    return new int[] {duplicate, i + 1};
                }
            }
            return new int[] {0, 0};
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    private static class S4 extends Solution645 {
        @Override
        public int[] findErrorNums(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] - 1 != i && nums[i] != nums[nums[i] - 1]) {
                    swap(nums, nums[i] - 1, i);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] - 1 != i) {
                    return new int[] {nums[i], i + 1};
                }
            }
            return new int[] {0, 0};
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    private static class S5 extends Solution645 {
        @Override
        public int[] findErrorNums(int[] nums) {
            int[] res = new int[2];
            for (int n : nums) {
                int i = Math.abs(n);
                if (nums[i - 1] < 0) {
                    res[0] = i;
                } else {
                    nums[i - 1] *= -1;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    res[1] = i + 1;
                    break;
                }
            }
            return res;
        }
    }

    private static class S6 extends Solution645 {
        @Override
        public int[] findErrorNums(int[] nums) {
            int diff1 = 0;
            int diff2 = 0;
            for (int i = 0; i < nums.length; i++) {
                diff1 += nums[i] - (i + 1);
                diff2 += nums[i] * nums[i] - (i + 1) * (i + 1);
            }
            int duplicate = (diff1 + diff2 / diff1) / 2;
            int missing = -diff1 + duplicate;
            return new int[] {duplicate, missing};
        }
    }

    private static class S7 extends Solution645 {
        @Override
        public int[] findErrorNums(int[] nums) {
            int[] res = new int[2];
            int[] count = new int[nums.length + 1];
            int xor = 0;
            for (int i = 0; i < nums.length; i++) {
                xor ^= (i + 1) ^ nums[i];
                if (++count[nums[i]] == 2) {
                    res[0] = nums[i];
                }
            }
            res[1] = xor ^ res[0];
            return res;
        }
    }
}
