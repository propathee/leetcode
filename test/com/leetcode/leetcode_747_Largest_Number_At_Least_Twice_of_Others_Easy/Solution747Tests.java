package com.leetcode.leetcode_747_Largest_Number_At_Least_Twice_of_Others_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution747Tests {
    private Solution747 solution = Solution747.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = {3,6,1,0};
        assertEquals(1, solution.dominateIndex(nums));
    }

    @Test
    public void should_pass_2() {
        int[] nums = {1,2,3,4};
        assertEquals(-1, solution.dominateIndex(nums));
    }

    @Test
    public void should_pass_3() {
        int[] nums = {1};
        assertEquals(0, solution.dominateIndex(nums));
    }

    @Test
    public void should_pass_4() {
        int[] nums = {0,0,2,3};
        assertEquals(-1, solution.dominateIndex(nums));
    }
}