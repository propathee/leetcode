package com.leetcode.leetcode_179_Largest_Number_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution179Tests {
    private Solution179 solution = Solution179.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = {10, 2};
        assertEquals("210", solution.largestNumber(nums));
    }

    @Test
    public void should_pass_2() {
        int[] nums = {3,30,34,5,9};
        assertEquals("9534330", solution.largestNumber(nums));
    }

    @Test
    public void should_pass_3() {
        int[] nums = {1};
        assertEquals("1", solution.largestNumber(nums));
    }

    @Test
    public void should_pass_4() {
        int[] nums = {10};
        assertEquals("10", solution.largestNumber(nums));
    }

    @Test
    public void should_pass_5() {
        int[] nums = {0, 0};
        assertEquals("0", solution.largestNumber(nums));
    }
}