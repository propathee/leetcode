package com.leetcode.leetcode_961_N_Repeated_Element_in_Size_2N_Array_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution961Tests {
    private Solution961 solution = Solution961.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = {1,2,3,3};
        assertEquals(3, solution.repeatedNTimes(input));
    }

    @Test
    public void should_pass_2() {
        int[] input = {2,1,2,5,3,2};
        assertEquals(2, solution.repeatedNTimes(input));
    }

    @Test
    public void should_pass_3() {
        int[] input = {5,1,5,2,5,3,5,4};
        assertEquals(5, solution.repeatedNTimes(input));
    }

    @Test
    public void should_pass_4() {
        int[] input = {9,5,6,9};
        assertEquals(9, solution.repeatedNTimes(input));
    }
}