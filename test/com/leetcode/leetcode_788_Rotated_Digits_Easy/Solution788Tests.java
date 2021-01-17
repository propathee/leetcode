package com.leetcode.leetcode_788_Rotated_Digits_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution788Tests {
    private Solution788 solution = Solution788.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals(4, solution.rotatedDigits(10));
    }

    @Test
    public void should_pass_2() {
        assertEquals(247, solution.rotatedDigits(857));
    }

    @Test
    public void should_pass_3() {
        assertEquals(1, solution.rotatedDigits(2));
    }

    @Test
    public void should_pass_4() {
        assertEquals(2, solution.rotatedDigits(5));
    }

    @Test
    public void should_pass_5() {
        assertEquals(3, solution.rotatedDigits(6));
    }

    @Test
    public void should_pass_6() {
        assertEquals(4, solution.rotatedDigits(9));
    }

    @Test
    public void should_pass_7() {
        assertEquals(9, solution.rotatedDigits(20));
    }
}