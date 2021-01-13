package com.leetcode.leetcode_746_min_cost_climbing_stairs_Easy;

abstract class Solution746 {
    /**
     * {@code cost} will have a length in the range [2, 1000].
     * every {@code cost[i]} will be an integer in the range [0, 999].
     */
    public abstract int minCostClimbingStairs(int[] cost);

    static Solution746 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution746 {
        @Override
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            for (int i = 2; i < n; i++) {
                cost[i] += Math.min(cost[i - 1], cost[i - 2]);
            }
            return Math.min(cost[n - 1], cost[n - 2]);
        }
    }
}
