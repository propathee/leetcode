package com.leetcode.leetcode_561_Array_Partition_I_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution561Tests {
    private Solution561 solution = Solution561.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = new int[] {1,4,3,2};
        assertEquals(4, solution.arrayPairSum(input));
    }

    @Test
    public void should_pass_2() {
        int[] input = new int[] {6,2,6,5,1,2};
        assertEquals(9, solution.arrayPairSum(input));
    }
}