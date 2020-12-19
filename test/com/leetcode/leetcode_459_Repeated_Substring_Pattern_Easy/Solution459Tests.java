package com.leetcode.leetcode_459_Repeated_Substring_Pattern_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution459Tests {
    private Solution459 solution = Solution459.newSolution();

    @Test
    public void should_pass_1() {
        assertTrue(solution.repeatedSubstringPattern("abab"));
    }

    @Test
    public void should_pass_2() {
        assertFalse(solution.repeatedSubstringPattern("aba"));
    }

    @Test
    public void should_pass_3() {
        assertTrue(solution.repeatedSubstringPattern("abcabcabcabc"));
    }

    @Test
    public void should_pass_4() {
        assertFalse(solution.repeatedSubstringPattern("a"));
    }

    @Test
    public void should_pass_5() {
        assertTrue(solution.repeatedSubstringPattern("aa"));
    }

    @Test
    public void should_pass_6() {
        assertTrue(solution.repeatedSubstringPattern("abcdeabcdefabcdeabcdef"));
    }

    @Test
    public void should_pass_7() {
        assertFalse(solution.repeatedSubstringPattern("abcdeabcdefabcdeabcde"));
    }

    @Test
    public void should_pass_8() {
        assertTrue(solution.repeatedSubstringPattern("abacababacab"));
    }

    @Test
    public void should_pass_9() {
        assertTrue(solution.repeatedSubstringPattern("babbabbabbabbab"));
    }
}