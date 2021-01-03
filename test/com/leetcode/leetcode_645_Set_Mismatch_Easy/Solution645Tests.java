package com.leetcode.leetcode_645_Set_Mismatch_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution645Tests {
    private Solution645 solution = Solution645.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = new int[] {1,2,2,4};
        int[] expect = new int[] {2,3};
        assertArrayEquals(expect, solution.findErrorNums(input));
    }
}