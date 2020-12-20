package com.leetcode.leetcode_485_Max_Consecutive_Ones_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution485Tests {
    private Solution485 solution = Solution485.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = new int[] {1,1,0,1,1,1};
        assertEquals(3, solution.findMaxConsecutiveOnes(input));
    }

    @Test
    public void should_pass_2() {
        int[] input = new int[] {1};
        assertEquals(1, solution.findMaxConsecutiveOnes(input));
    }

    @Test
    public void should_pass_3() {
        int[] input = new int[] {0};
        assertEquals(0, solution.findMaxConsecutiveOnes(input));
    }
}