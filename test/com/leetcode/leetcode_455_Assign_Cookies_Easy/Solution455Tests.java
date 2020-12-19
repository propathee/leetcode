package com.leetcode.leetcode_455_Assign_Cookies_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution455Tests {
    private Solution455 solution = Solution455.newSolution();

    @Test
    public void should_pass_1() {
        int[] g = new int[] {1, 2, 3};
        int[] s = new int[] {1, 1};
        assertEquals(1, solution.findContentChildren(g, s));
    }

    @Test
    public void should_pass_2() {
        int[] g = new int[] {1, 2};
        int[] s = new int[] {1, 2, 3};
        assertEquals(2, solution.findContentChildren(g, s));
    }
}