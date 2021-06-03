package com.leetcode.leetcode_179_Largest_Number_Medium;

import java.util.Arrays;

abstract class Solution179 {
    public abstract String largestNumber(int[] nums);

    static Solution179 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution179 {
        @Override
        public String largestNumber(int[] nums) {
            String[] strings = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strings[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(strings, (x, y) -> (y + x).compareTo(x + y));
            if ("0".equals(strings[0])) {
                return "0";
            } else {
                StringBuilder sb = new StringBuilder();
                for (String str : strings) {
                    sb.append(str);
                }
                return sb.toString();
            }
        }
    }

    // bubble sort
    private static class S2 extends Solution179 {
        @Override
        public String largestNumber(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (isLeftGreaterThanRight(nums[j], nums[j - 1])) {
                        swap(nums, j, j - 1);
                    }
                }
            }
            if (nums[0] == 0) {
                return "0";
            } else {
                StringBuilder sb = new StringBuilder();
                for (int num : nums) {
                    sb.append(num);
                }
                return sb.toString();
            }
        }

        private boolean isLeftGreaterThanRight(int l, int r) {
            return ("" + l + r).compareTo("" + r + l) > 0;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
