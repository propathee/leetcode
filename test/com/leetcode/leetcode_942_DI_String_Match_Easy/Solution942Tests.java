package com.leetcode.leetcode_942_DI_String_Match_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution942Tests {
    private Solution942 solution = Solution942.newSolution();

    @Test
    public void should_pass_1() {
        String input = "IDID";
        int[] output = {0,4,1,3,2};
        assertArrayEquals(output, solution.diStringMatch(input));
    }

    @Test
    public void should_pass_2() {
        String input = "III";
        int[] output = {0,1,2,3};
        assertArrayEquals(output, solution.diStringMatch(input));
    }

    @Test
    public void should_pass_3() {
        String input = "DDI";
        int[] output = {3,2,0,1};
        assertArrayEquals(output, solution.diStringMatch(input));
    }
}