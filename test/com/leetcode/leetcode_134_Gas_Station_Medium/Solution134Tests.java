package com.leetcode.leetcode_134_Gas_Station_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution134Tests {
    private Solution134 solution = Solution134.newSolution();

    @Test
    public void should_pass_1() {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        assertEquals(3, solution.canCompleteCircuit(gas, cost));
    }

    @Test
    public void should_pass_2() {
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        assertEquals(-1, solution.canCompleteCircuit(gas, cost));
    }
}