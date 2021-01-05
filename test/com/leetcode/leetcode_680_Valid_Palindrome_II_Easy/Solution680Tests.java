package com.leetcode.leetcode_680_Valid_Palindrome_II_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution680Tests {
    private Solution680 solution = Solution680.newSolution();

    @Test
    public void should_pass_1() {
        assertTrue(solution.validPalindrome("aba"));
    }

    @Test
    public void should_pass_2() {
        assertTrue(solution.validPalindrome("abca"));
    }

    @Test
    public void should_pass_3() {
        assertTrue(solution.validPalindrome("a"));
    }

    @Test
    public void should_pass_4() {
        assertTrue(solution.validPalindrome("ab"));
    }

    @Test
    public void should_pass_5() {
        assertFalse(solution.validPalindrome("abcda"));
    }

    @Test
    public void should_pass_6() {
        assertTrue(solution.validPalindrome("abbb"));
    }

    @Test
    public void should_pass_7() {
        assertTrue(solution.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}