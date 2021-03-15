package com.leetcode.leetcode_953_Verifying_an_Alien_Dictionary_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution953Tests {
    private Solution953 solution = Solution953.newSolution();

    @Test
    public void should_pass_1() {
        String[] input = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        assertTrue(solution.isAlienSorted(input, order));
    }

    @Test
    public void should_pass_2() {
        String[] input = {"word","world","row"};
        String order = "worldabcefghijkmnpqstuvxyz";
        assertFalse(solution.isAlienSorted(input, order));
    }

    @Test
    public void should_pass_3() {
        String[] input = {"apple", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        assertFalse(solution.isAlienSorted(input, order));
    }
}