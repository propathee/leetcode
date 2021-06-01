package com.leetcode.leetcode_154_Find_Minimum_in_Rotated_Sorted_Array_II_Hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution154Tests {
    private Solution154 solution = Solution154.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = {4,5,6,7,0,1,2};
        assertEquals(0, solution.findMin(nums));
    }

    @Test
    public void should_pass_2() {
        int[] nums = {11,13,15,17};
        assertEquals(11, solution.findMin(nums));
    }

    @Test
    public void should_pass_3() {
        int[] nums = {1,3,4};
        assertEquals(1, solution.findMin(nums));
    }

    @Test
    public void should_pass_4() {
        int[] nums = {2,2,2,0,1};
        assertEquals(0, solution.findMin(nums));
    }

    @Test
    public void should_pass_5() {
        int[] nums = {1,1,1,1,1};
        assertEquals(1, solution.findMin(nums));
    }

    @Test
    public void should_pass_6() {
        int[] nums = {10,1,10,10,10};
        assertEquals(1, solution.findMin(nums));
    }
}