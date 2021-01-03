package com.leetcode.leetcode_665_Non_decreasing_Array_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution665Tests {
    private Solution665 solution = Solution665.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = new int[] {4,2,3};
        assertTrue(solution.checkPossibility(input));
    }

    @Test
    public void should_pass_2() {
        int[] input = new int[] {4,2,1};
        assertFalse(solution.checkPossibility(input));
    }

    @Test
    public void should_pass_3() {
        int[] input = new int[] {3,4,2,3};
        assertFalse(solution.checkPossibility(input));
    }

    @Test
    public void should_pass_4() {
        int[] input = new int[] {2,1};
        assertTrue(solution.checkPossibility(input));
    }

    @Test
    public void should_pass_5() {
        int[] input = new int[] {1};
        assertTrue(solution.checkPossibility(input));
    }

    @Test
    public void should_pass_6() {
        int[] input = new int[] {2,3,-1,5};
        assertTrue(solution.checkPossibility(input));
    }

    @Test
    public void should_pass_7() {
        int[] input = new int[] {2,3,9,5};
        assertTrue(solution.checkPossibility(input));
    }
}