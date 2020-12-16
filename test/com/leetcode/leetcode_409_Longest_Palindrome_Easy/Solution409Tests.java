package com.leetcode.leetcode_409_Longest_Palindrome_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution409Tests {
    private Solution409 solution = Solution409.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals(7, solution.longestPalindrome("abccccdd"));
    }

    @Test
    public void should_pass_2() {
        assertEquals(1, solution.longestPalindrome("a"));
    }

    @Test
    public void should_pass_3() {
        assertEquals(2, solution.longestPalindrome("bb"));
    }

    @Test
    public void should_pass_4() {
        assertEquals(1, solution.longestPalindrome("aA"));
    }

    @Test
    public void should_pass_5() {
        assertEquals(0, solution.longestPalindrome(""));
    }
}