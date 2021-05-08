package com.leetcode.leetcode_153_Find_Minimum_in_Rotated_Sorted_Array_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution153Tests {
    private Solution153 solution = Solution153.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = {3,4,5,1,2};
        assertEquals(1, solution.findMin(nums));
    }

    @Test
    public void should_pass_2() {
        int[] nums = {4,5,6,7,0,1,2};
        assertEquals(0, solution.findMin(nums));
    }

    @Test
    public void should_pass_3() {
        int[] nums = {11,13,15,17};
        assertEquals(11, solution.findMin(nums));
    }

    @Test
    public void should_pass_4() {
        int[] nums = {2,1};
        assertEquals(1, solution.findMin(nums));
    }
}