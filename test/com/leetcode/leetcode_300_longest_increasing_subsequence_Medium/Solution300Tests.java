package com.leetcode.leetcode_300_longest_increasing_subsequence_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution300Tests {
    private Solution300 solution = Solution300.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = {10,9,2,5,3,7,101,18};
        assertEquals(4, solution.lengthOfLIS(nums));
    }

    @Test
    public void should_pass_2() {
        int[] nums = {0,1,0,3,2,3};
        assertEquals(4, solution.lengthOfLIS(nums));
    }

    @Test
    public void should_pass_3() {
        int[] nums = {7,7,7,7,7,7,7};
        assertEquals(1, solution.lengthOfLIS(nums));
    }

    @Test
    public void should_pass_4() {
        int[] nums = {1,3,6,7,9,4,10,5,6};
        assertEquals(6, solution.lengthOfLIS(nums));
    }

    @Test
    public void should_pass_5() {
        int[] nums = {4,10,4,3,8,9};
        assertEquals(3, solution.lengthOfLIS(nums));
    }
}