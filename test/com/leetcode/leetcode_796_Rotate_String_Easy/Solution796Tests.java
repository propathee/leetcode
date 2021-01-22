package com.leetcode.leetcode_796_Rotate_String_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution796Tests {
    private Solution796 solution = Solution796.newSolution();

    @Test
    public void should_pass_1() {
        assertTrue(solution.rotateString("abcde", "cdeab"));
    }

    @Test
    public void should_pass_2() {
        assertFalse(solution.rotateString("abcde", "abced"));
    }

    @Test
    public void should_pass_3() {
        assertTrue(solution.rotateString("", ""));
    }
}