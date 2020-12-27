package com.leetcode.leetcode_561_Array_Partition_I_Easy;

import java.util.Arrays;

abstract class Solution561 {
    public abstract int arrayPairSum(int[] nums);

    static Solution561 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution561 {
        @Override
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i += 2) {
                sum += nums[i];
            }
            return sum;
        }
    }

    private static class S2 extends Solution561 {
        @Override
        public int arrayPairSum(int[] nums) {
            int[] dict = new int[20001];
            for (int n : nums) {
                dict[n + 10000]++;
            }
            int sum = 0;
            boolean isOdd = true;
            for (int i = 0; i < dict.length; i++) {
                while (dict[i] != 0) {
                    if (isOdd) {
                        sum = sum + i - 10000;
                        isOdd = false;
                    } else {
                        isOdd = true;
                    }
                    dict[i]--;
                }
            }
            return sum;
        }
    }
}
