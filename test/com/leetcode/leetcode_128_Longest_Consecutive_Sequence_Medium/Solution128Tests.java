package com.leetcode.leetcode_128_Longest_Consecutive_Sequence_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution128Tests {
    private Solution128 solution = Solution128.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = {100,4,200,1,3,2};
        assertEquals(4, solution.longestConsecutive(nums));
    }

    @Test
    public void should_pass_2() {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        assertEquals(9, solution.longestConsecutive(nums));
    }

    @Test
    public void should_pass_3() {
        int[] nums = {1,2,0,1};
        assertEquals(3, solution.longestConsecutive(nums));
    }
}