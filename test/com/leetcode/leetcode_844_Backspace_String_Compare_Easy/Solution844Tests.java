package com.leetcode.leetcode_844_Backspace_String_Compare_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution844Tests {
    private Solution844 solution = Solution844.newSolution();

    @Test
    public void should_pass_1() {
        assertTrue(solution.backspaceCompare("ab#c", "ad#c"));
    }

    @Test
    public void should_pass_2() {
        assertTrue(solution.backspaceCompare("ab##", "c#d#"));
    }

    @Test
    public void should_pass_3() {
        assertTrue(solution.backspaceCompare("a##c", "#a#c"));
    }

    @Test
    public void should_pass_4() {
        assertFalse(solution.backspaceCompare("a#c", "b"));
    }
}