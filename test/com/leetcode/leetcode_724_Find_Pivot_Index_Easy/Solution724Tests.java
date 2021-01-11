package com.leetcode.leetcode_724_Find_Pivot_Index_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution724Tests {
    private Solution724 solution = Solution724.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = {1,7,3,6,5,6};
        assertEquals(3, solution.pivotIndex(nums));
    }

    @Test
    public void should_pass_2() {
        int[] nums = {1,2,3};
        assertEquals(-1, solution.pivotIndex(nums));
    }
}