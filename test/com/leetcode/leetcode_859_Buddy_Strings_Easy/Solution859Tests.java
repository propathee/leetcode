package com.leetcode.leetcode_859_Buddy_Strings_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution859Tests {
    private Solution859 solution = Solution859.newSolution();

    @Test
    public void should_pass_1() {
        assertTrue(solution.buddyStrings("ab", "ba"));
    }

    @Test
    public void should_pass_2() {
        assertFalse(solution.buddyStrings("ab", "ab"));
    }

    @Test
    public void should_pass_3() {
        assertTrue(solution.buddyStrings("ab", "ba"));
    }

    @Test
    public void should_pass_4() {
        assertTrue(solution.buddyStrings("aa", "aa"));
    }

    @Test
    public void should_pass_5() {
        assertTrue(solution.buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }

    @Test
    public void should_pass_6() {
        assertFalse(solution.buddyStrings("", "aa"));
    }
}