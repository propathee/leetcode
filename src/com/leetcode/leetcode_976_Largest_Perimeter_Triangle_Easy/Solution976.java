package com.leetcode.leetcode_976_Largest_Perimeter_Triangle_Easy;

import java.util.Arrays;

abstract class Solution976 {
    public abstract int largestPerimeter(int[] nums);

    static Solution976 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution976 {
        @Override
        public int largestPerimeter(int[] nums) {
            Arrays.sort(nums);
            for (int i = nums.length - 1; i >= 2; i--) {
                if (nums[i - 2] + nums[i - 1] > nums[i]) {
                    return nums[i - 2] + nums[i - 1] + nums[i];
                }
            }
            return 0;
        }
    }
}
