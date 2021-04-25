package com.leetcode.leetcode_137_Single_Number_II_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution137Tests {
    private Solution137 solution = Solution137.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = {2,2,3,2};
        assertEquals(3, solution.singleNumber(nums));
    }

    @Test
    public void should_pass_2() {
        int[] nums = {0,1,0,1,0,1,99};
        assertEquals(99, solution.singleNumber(nums));
    }
}