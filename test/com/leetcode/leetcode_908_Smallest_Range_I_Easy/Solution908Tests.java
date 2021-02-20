package com.leetcode.leetcode_908_Smallest_Range_I_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution908Tests {
    private Solution908 solution = Solution908.newSolution();

    @Test
    public void should_pass_1() {
        int[] array = {1};
        assertEquals(0, solution.smallestRangeI(array, 0));
    }

    @Test
    public void should_pass_2() {
        int[] array = {0, 10};
        assertEquals(6, solution.smallestRangeI(array, 2));
    }

    @Test
    public void should_pass_3() {
        int[] array = {1, 3, 6};
        assertEquals(0, solution.smallestRangeI(array, 3));
    }
}