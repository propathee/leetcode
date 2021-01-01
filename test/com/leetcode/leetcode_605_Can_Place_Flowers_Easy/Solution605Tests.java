package com.leetcode.leetcode_605_Can_Place_Flowers_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution605Tests {
    private Solution605 solution = Solution605.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = new int[] {1,0,0,0,1};
        assertTrue(solution.canPlaceFlowers(input, 1));
    }

    @Test
    public void should_pass_2() {
        int[] input = new int[] {1,0,0,0,1};
        assertFalse(solution.canPlaceFlowers(input, 2));
    }

    @Test
    public void should_pass_3() {
        int[] input = new int[] {1,0,1,0,1,0,1};
        assertTrue(solution.canPlaceFlowers(input, 0));
    }

    @Test
    public void should_pass_4() {
        int[] input = new int[] {0,0,1,0,1};
        assertTrue(solution.canPlaceFlowers(input, 1));
    }
}