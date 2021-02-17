package com.leetcode.leetcode_896_Monotonic_Array_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution896Tests {
    private Solution896 solution = Solution896.newSolution();

    @Test
    public void should_pass_1() {
        int[] array = {1,2,3,4};
        assertTrue(solution.isMonotonic(array));
    }

    @Test
    public void should_pass_2() {
        int[] array = {6,5,4,4};
        assertTrue(solution.isMonotonic(array));
    }

    @Test
    public void should_pass_3() {
        int[] array = {1,3,2};
        assertFalse(solution.isMonotonic(array));
    }

    @Test
    public void should_pass_4() {
        int[] array = {1,2,4,5};
        assertTrue(solution.isMonotonic(array));
    }

    @Test
    public void should_pass_5() {
        int[] array = {1,1,1};
        assertTrue(solution.isMonotonic(array));
    }

    @Test
    public void should_pass_6() {
        int[] array = {11,11,9,4,3,3,3,1,-1,-1,3,3,3,5,5,5};
        assertFalse(solution.isMonotonic(array));
    }

    @Test
    public void should_pass_7() {
        int[] array = {1,2,2,3};
        assertTrue(solution.isMonotonic(array));
    }
}