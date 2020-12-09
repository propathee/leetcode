package com.leetcode.leetcode_290_Word_Pattern_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution290Tests {
    private Solution290 solution = new Solution290();

    @Test
    public void should_pass_1() {
        assertTrue(solution.wordPattern("abba", "dog cat cat dog"));
    }

    @Test
    public void should_pass_2() {
        assertFalse(solution.wordPattern("abba", "dog cat cat fish"));
    }

    @Test
    public void should_pass_3() {
        assertFalse(solution.wordPattern("abba", "dog dog dog dog"));
    }

    @Test
    public void should_pass_4() {
        assertTrue(solution.wordPattern("a", "dog"));
    }

    @Test
    public void should_pass_5() {
        assertFalse(solution.wordPattern("", ""));
    }

    @Test
    public void should_pass_6() {
        assertFalse(solution.wordPattern("a", "dog fish"));
    }

    @Test
    public void should_pass_7() {
        assertTrue(solution.wordPattern("deadbeef", "d e a d b e e f"));
    }
}