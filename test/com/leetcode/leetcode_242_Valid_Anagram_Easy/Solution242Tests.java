package com.leetcode.leetcode_242_Valid_Anagram_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution242Tests {
    private Solution242 solution = new Solution242();

    @Test
    public void should_pass_1() {
        assertTrue(solution.isAnagram("anagram", "nagaram"));
    }

    @Test
    public void should_pass_2() {
        assertFalse(solution.isAnagram("cat", "fat"));
    }

    @Test
    public void should_pass_3() {
        assertTrue(solution.isAnagram("", ""));
    }

    @Test
    public void should_pass_4() {
        assertFalse(solution.isAnagram("a", "b"));
    }

    @Test
    public void should_pass_5() {
        assertTrue(solution.isAnagram("a", "a"));
    }
}