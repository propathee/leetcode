package com.leetcode.leetcode_287_Find_the_Duplicate_Number_Medium;

abstract class Solution287 {
    public abstract int findDuplicate(int[] nums);

    static Solution287 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution287 {
        @Override
        public int findDuplicate(int[] nums) {
            int low = 1, high = nums.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                int cnt = 0;
                for (int n : nums) {
                    if (n <= mid) {
                        cnt++;
                    }
                }
                if (cnt <= mid) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }

    private static class S2 extends Solution287 {
        @Override
        public int findDuplicate(int[] nums) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (fast != slow) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = slow;
            slow = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
    }
}
