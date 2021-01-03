package com.leetcode.leetcode_665_Non_decreasing_Array_Easy;

abstract class Solution665 {
    public abstract boolean checkPossibility(int[] nums);

    static Solution665 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution665 {
        @Override
        public boolean checkPossibility(int[] nums) {
            int cnt = 0;
            for (int i = 1; i < nums.length && cnt <= 1; i++) {
                if (nums[i] < nums[i - 1]) {
                    cnt++;
                    if (i == 1 || nums[i] >= nums[i - 2]) {
                        nums[i - 1] = nums[i]; // this step can be omitted
                    } else {
                        nums[i] = nums[i - 1];
                    }
                }
            }
            return cnt <= 1;
        }
    }

    private static class S2 extends Solution665 {
        @Override
        public boolean checkPossibility(int[] nums) {
            int cnt = 0, pre = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < pre) {
                    if (++cnt > 1) {
                        return false;
                    }
                    if (i >= 2 && nums[i] < nums[i - 2]) {
                        continue;
                    }
                }
                pre = nums[i];
            }
            return true;
        }
    }

    private static class S3 extends Solution665 {
        @Override
        public boolean checkPossibility(int[] nums) {
            int cnt = 0;
            for (int i = 0; i < nums.length - 1 && cnt <= 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    cnt++;
                    if (i > 0 && nums[i + 1] < nums[i - 1]) {
                        nums[i + 1] = nums[i];
                    } else {
                        nums[i] = nums[i + 1];
                    }
                }
            }
            return cnt <= 1;
        }
    }

    private static class S4 extends Solution665 {
        @Override
        public boolean checkPossibility(int[] nums) {
            int cnt = 0;
            for (int i = 1; i < nums.length && cnt <= 1; i++) {
                if (nums[i] < nums[i - 1]) {
                    cnt++;
                    if (i >= 2 && nums[i] < nums[i - 2]) {
                        nums[i] = nums[i - 1];
                    }
                }
            }
            return cnt <= 1;
        }
    }
}
