package com.leetcode.leetcode_746_min_cost_climbing_stairs_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution746Tests {
    private Solution746 solution = Solution746.newSolution();

    @Test
    public void should_pass_1() {
        int[] cost = {10,15,20};
        assertEquals(15, solution.minCostClimbingStairs(cost));
    }

    @Test
    public void should_pass_2() {
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        assertEquals(6, solution.minCostClimbingStairs(cost));
    }
}