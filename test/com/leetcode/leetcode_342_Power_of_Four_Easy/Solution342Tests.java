package com.leetcode.leetcode_342_Power_of_Four_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution342Tests {
    private Solution342 solution = new Solution342();

    @Test
    public void should_pass_0() {
        assertFalse(solution.isPowerOfFour(0));
    }

    @Test
    public void should_pass_1() {
        assertTrue(solution.isPowerOfFour(1));
    }

    @Test
    public void should_pass_2() {
        assertFalse(solution.isPowerOfFour(2));
    }

    @Test
    public void should_pass_3() {
        assertFalse(solution.isPowerOfFour(3));
    }

    @Test
    public void should_pass_4() {
        assertTrue(solution.isPowerOfFour(4));
    }

    @Test
    public void should_pass_5() {
        assertTrue(solution.isPowerOfFour(16));
    }

    @Test
    public void should_pass_6() {
        assertFalse(solution.isPowerOfFour(8));
    }

    @Test
    public void should_pass_7() {
        assertFalse(solution.isPowerOfFour(-4));
    }
}