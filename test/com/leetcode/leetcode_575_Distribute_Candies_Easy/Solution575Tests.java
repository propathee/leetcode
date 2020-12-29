package com.leetcode.leetcode_575_Distribute_Candies_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution575Tests {
    private Solution575 solution = Solution575.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = new int[] {1,1,2,2,3,3};
        assertEquals(3, solution.distributeCandies(input));
    }

    @Test
    public void should_pass_2() {
        int[] input = new int[] {1,1,2,3};
        assertEquals(2, solution.distributeCandies(input));
    }

    @Test
    public void should_pass_3() {
        int[] input = new int[] {6,6,6,6};
        assertEquals(1, solution.distributeCandies(input));
    }
}