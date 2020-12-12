package com.leetcode.leetcode_383_Ransom_Note_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution383Tests {
    private Solution383 solution = Solution383.newSolution();

    @Test
    public void should_pass_1() {
        assertFalse(solution.canConstruct("a", "b"));
    }

    @Test
    public void should_pass_2() {
        assertFalse(solution.canConstruct("aa", "ab"));
    }

    @Test
    public void should_pass_3() {
        assertTrue(solution.canConstruct("aa", "aab"));
    }

    @Test
    public void should_pass_4() {
        assertTrue(solution.canConstruct("", "b"));
    }

    @Test
    public void should_pass_5() {
        assertTrue(solution.canConstruct("", ""));
    }

    @Test
    public void should_pass_6() {
        assertFalse(solution.canConstruct("b", "a"));
    }

    @Test
    public void should_pass_7() {
        assertFalse(solution.canConstruct("a", ""));
    }

    @Test
    public void should_pass_8() {
        assertFalse(solution.canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi"));
    }
}