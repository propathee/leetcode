package com.leetcode.leetcode_697_Degree_of_an_Array_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution697Tests {
    private Solution697 solution = Solution697.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = new int[] {1,2,2,3,1};
        assertEquals(2, solution.findShortestSubArray(nums));
    }

    @Test
    public void should_pass_2() {
        int[] nums = new int[] {1,2,2,3,1,4,2};
        assertEquals(6, solution.findShortestSubArray(nums));
    }
}