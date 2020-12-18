package com.leetcode.leetcode_453_Minimum_Moves_to_Equal_Array_Elements_Easy;

import java.util.Arrays;

public abstract class Solution453 {
    /**
     * Given a non-empty integer array of size n,
     * find the minimum number of moves required to make all array elements equal,
     * where a move is incrementing n - 1 elements by 1.
     */
    public abstract int minMoves(int[] nums);

    static Solution453 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution453 {
        @Override
        public int minMoves(int[] nums) {
            Arrays.sort(nums);
            int cnt = 0;
            for (int n : nums) {
                cnt += n;
            }
            return cnt - nums[0] * nums.length;
        }
    }

    /**
     * suppose x is minMoves, y is the final number after x moves, n is array's length, we have:
     * sum + (n-1) * x = n * y;
     * and y = min + x;
     * finally we have x = sum - min * n;
     */
    private static class S2 extends Solution453 {
        @Override
        public int minMoves(int[] nums) {
            int min = nums[0];
            int sum = 0;
            for (int n : nums) {
                sum += n;
                if (n < min) {
                    min = n;
                }
            }
            return sum - min * nums.length;
        }
    }
}
