package com.leetcode.leetcode_209_Minimum_Size_Subarray_Sum_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution209Tests {
    private Solution209 solution = Solution209.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = {2,3,1,2,4,3};
        assertEquals(2, solution.minSubArrayLen(7, nums));
    }

    @Test
    public void should_pass_2() {
        int[] nums = {1,4,4};
        assertEquals(1, solution.minSubArrayLen(4, nums));
    }

    @Test
    public void should_pass_3() {
        int[] nums = {1,1,1,1,1,1,1,1};
        assertEquals(0, solution.minSubArrayLen(11, nums));
    }
}