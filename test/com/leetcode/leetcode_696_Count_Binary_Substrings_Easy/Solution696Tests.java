package com.leetcode.leetcode_696_Count_Binary_Substrings_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution696Tests {
    private Solution696 solution = Solution696.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals(6, solution.countBinarySubstrings("00110011"));
    }

    @Test
    public void should_pass_2() {
        assertEquals(4, solution.countBinarySubstrings("10101"));
    }
}