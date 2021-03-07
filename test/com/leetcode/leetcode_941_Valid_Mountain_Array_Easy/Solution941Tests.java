package com.leetcode.leetcode_941_Valid_Mountain_Array_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution941Tests {
    private Solution941 solution = Solution941.newSolution();

    @Test
    public void should_pass_1() {
        int[] arr = {2,1};
        assertFalse(solution.validMountainArray(arr));
    }

    @Test
    public void should_pass_2() {
        int[] arr = {3,5,5};
        assertFalse(solution.validMountainArray(arr));
    }

    @Test
    public void should_pass_3() {
        int[] arr = {0,3,2,1};
        assertTrue(solution.validMountainArray(arr));
    }

    @Test
    public void should_pass_4() {
        int[] arr = {1,2};
        assertFalse(solution.validMountainArray(arr));
    }

    @Test
    public void should_pass_5() {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        assertFalse(solution.validMountainArray(arr));
    }
}