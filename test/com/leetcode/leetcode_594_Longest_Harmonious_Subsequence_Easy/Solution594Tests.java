package com.leetcode.leetcode_594_Longest_Harmonious_Subsequence_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution594Tests {
    private Solution594 solution = Solution594.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = new int[] {1,3,2,2,5,2,3,7};
        assertEquals(5, solution.findLHS(input));
    }

    @Test
    public void should_pass_2() {
        int[] input = new int[] {1,2,3,4};
        assertEquals(2, solution.findLHS(input));
    }

    @Test
    public void should_pass_3() {
        int[] input = new int[] {1,1,1,1};
        assertEquals(0, solution.findLHS(input));
    }
}