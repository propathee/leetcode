package com.leetcode.leetcode_367_Valid_Perfect_Square_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution367Tests {
    private Solution367 solution = Solution367.newSolution();

    @Test
    public void should_return_true() {
        assertTrue(solution.isPerfectSquare(1));
        assertTrue(solution.isPerfectSquare(4));
        assertTrue(solution.isPerfectSquare(9));
        assertTrue(solution.isPerfectSquare(16));
        assertTrue(solution.isPerfectSquare(25));
        assertTrue(solution.isPerfectSquare(36));
        assertTrue(solution.isPerfectSquare(49));
        assertTrue(solution.isPerfectSquare(100));
        assertTrue(solution.isPerfectSquare(10000));
        assertTrue(solution.isPerfectSquare(256));
    }

    @Test
    public void should_return_false() {
        assertFalse(solution.isPerfectSquare(2));
        assertFalse(solution.isPerfectSquare(3));
        assertFalse(solution.isPerfectSquare(8));
        assertFalse(solution.isPerfectSquare(10));
        assertFalse(solution.isPerfectSquare(12));
        assertFalse(solution.isPerfectSquare(15));
        assertFalse(solution.isPerfectSquare(17));
        assertFalse(solution.isPerfectSquare(24));
        assertFalse(solution.isPerfectSquare(26));
        assertFalse(solution.isPerfectSquare(99));
        assertFalse(solution.isPerfectSquare(Integer.MAX_VALUE));
    }
}