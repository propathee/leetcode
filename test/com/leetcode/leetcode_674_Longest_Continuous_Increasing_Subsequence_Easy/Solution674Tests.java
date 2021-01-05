package com.leetcode.leetcode_674_Longest_Continuous_Increasing_Subsequence_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution674Tests {
    private Solution674 solution = Solution674.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = new int[] {1,3,5,4,7};
        assertEquals(3, solution.findLengthOfLCIS(input));
    }

    @Test
    public void should_pass_2() {
        int[] input = new int[] {2,2,2,2,2};
        assertEquals(1, solution.findLengthOfLCIS(input));
    }

    @Test
    public void should_pass_3() {
        int[] input = new int[] {1,3,5,4,7,8,9};
        assertEquals(4, solution.findLengthOfLCIS(input));
    }

    @Test
    public void should_pass_4() {
        int[] input = new int[0];
        assertEquals(0, solution.findLengthOfLCIS(input));
    }

    @Test
    public void should_pass_5() {
        int[] input = new int[] {1};
        assertEquals(1, solution.findLengthOfLCIS(input));
    }
}