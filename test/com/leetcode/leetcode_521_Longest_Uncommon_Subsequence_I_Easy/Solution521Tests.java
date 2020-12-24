package com.leetcode.leetcode_521_Longest_Uncommon_Subsequence_I_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution521Tests {
    private Solution521 solution = Solution521.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals(3, solution.findLUSlength("aba", "cdc"));
    }

    @Test
    public void should_pass_2() {
        assertEquals(3, solution.findLUSlength("aaa", "bbb"));
    }

    @Test
    public void should_pass_3() {
        assertEquals(-1, solution.findLUSlength("aaa", "aaa"));
    }
}