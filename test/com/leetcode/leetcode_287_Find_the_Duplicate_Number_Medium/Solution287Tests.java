package com.leetcode.leetcode_287_Find_the_Duplicate_Number_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution287Tests {
    private Solution287 solution = Solution287.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = {1,3,4,2,2};
        assertEquals(2, solution.findDuplicate(nums));
    }

    @Test
    public void should_pass_2() {
        int[] nums = {3,1,3,4,2};
        assertEquals(3, solution.findDuplicate(nums));
    }

    @Test
    public void should_pass_3() {
        int[] nums = {1,1};
        assertEquals(1, solution.findDuplicate(nums));
    }

    @Test
    public void should_pass_4() {
        int[] nums = {1,1,2};
        assertEquals(1, solution.findDuplicate(nums));
    }

    @Test
    public void should_pass_5() {
        int[] nums = {2,2,2,2,2};
        assertEquals(2, solution.findDuplicate(nums));
    }

    @Test
    public void should_pass_6() {
        int[] nums = {1,4,4,2,4};
        assertEquals(4, solution.findDuplicate(nums));
    }
}