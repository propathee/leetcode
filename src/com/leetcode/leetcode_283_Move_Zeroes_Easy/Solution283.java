package com.leetcode.leetcode_283_Move_Zeroes_Easy;

public class Solution283 {
    public void moveZeroes_1(int[] nums) {
        int zeroCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCnt++;
            } else {
                nums[i - zeroCnt] = nums[i];
            }
        }
        for (int i = 1; i <= zeroCnt; i++) {
            nums[nums.length - i] = 0;
        }
    }

    public void moveZeroes_2(int[] nums) {
        int insertIdx = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[insertIdx++] = n;
            }
        }
        while (insertIdx < nums.length) {
            nums[insertIdx++] = 0;
        }
    }

    public void moveZeroes(int[] nums) {
        int curIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[curIdx];
                nums[curIdx] = nums[i];
                nums[i] = tmp;
                curIdx++;
            }
        }
    }
}
