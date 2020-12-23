package com.leetcode.leetcode_520_Detect_Capital_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution520Tests {
    private Solution520 solution = Solution520.newSolution();

    @Test
    public void should_pass_1() {
        assertTrue(solution.detectCapitalUse("USA"));
    }

    @Test
    public void should_pass_2() {
        assertTrue(solution.detectCapitalUse("Big"));
    }

    @Test
    public void should_pass_3() {
        assertTrue(solution.detectCapitalUse("small"));
    }

    @Test
    public void should_pass_4() {
        assertTrue(solution.detectCapitalUse("A"));
    }

    @Test
    public void should_pass_5() {
        assertTrue(solution.detectCapitalUse("b"));
    }

    @Test
    public void should_pass_6() {
        assertFalse(solution.detectCapitalUse("FlaG"));
    }
}