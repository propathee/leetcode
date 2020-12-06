package com.leetcode.leetcode_268_Missing_Number_Easy;

public class Solution268 {
    public int missingNumber_1(int[] nums) {
        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum += i;
        }
        for (int n : nums) {
            sum -= n;
        }
        return sum;
    }

    public int missingNumber_2(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2;
        for (int n : nums) {
            sum -= n;
        }
        return sum;
    }

    public int missingNumber_3(int[] nums) {
        int sum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            sum += (i - nums[i]);
        }
        return sum;
    }

    public int missingNumber_4(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ (i + 1) ^ nums[i];
        }
        return xor;
    }

    public int missingNumber(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor;
    }
}
