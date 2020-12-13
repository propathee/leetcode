package com.leetcode.leetcode_392_Is_Subsequence_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution392Tests {
    private Solution392 solution = Solution392.newSolution();

    @Test
    public void should_pass_1() {
        assertTrue(solution.isSubsequence("ace", "abcde"));
    }

    @Test
    public void should_pass_2() {
        assertFalse(solution.isSubsequence("aec", "abcde"));
    }

    @Test
    public void should_pass_3() {
        assertTrue(solution.isSubsequence("abc", "ahbgdc"));
    }

    @Test
    public void should_pass_4() {
        assertFalse(solution.isSubsequence("axc", "ahbgdc"));
    }

    @Test
    public void should_pass_5() {
        assertTrue(solution.isSubsequence("abc", "abc"));
    }

    @Test
    public void should_pass_6() {
        assertTrue(solution.isSubsequence("", "a"));
    }

    @Test
    public void should_pass_7() {
        assertTrue(solution.isSubsequence("", ""));
    }

    @Test
    public void should_pass_8() {
        assertFalse(solution.isSubsequence("aaaaaa", "bbaaaa"));
    }
}