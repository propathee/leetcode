package com.leetcode.leetcode_263_Ugly_Number_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution263Tests {
    private Solution263 solution = new Solution263();

    @Test
    public void should_pass_1() {
        assertTrue(solution.isUgly(6));
    }

    @Test
    public void should_pass_2() {
        assertTrue(solution.isUgly(8));
    }

    @Test
    public void should_pass_3() {
        assertFalse(solution.isUgly(14));
    }

    @Test
    public void should_pass_4() {
        assertTrue(solution.isUgly(2));
    }

    @Test
    public void should_pass_5() {
        assertTrue(solution.isUgly(3));
    }

    @Test
    public void should_pass_6() {
        assertTrue(solution.isUgly(5));
    }

    @Test
    public void should_pass_7() {
        assertTrue(solution.isUgly(10));
    }

    @Test
    public void should_pass_8() {
        assertTrue(solution.isUgly(1));
    }

    @Test
    public void should_pass_9() {
        assertFalse(solution.isUgly(0));
    }

    @Test
    public void should_pass_10() {
        assertFalse(solution.isUgly(-2));
    }
}