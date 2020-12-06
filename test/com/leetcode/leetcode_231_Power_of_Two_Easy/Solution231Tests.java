package com.leetcode.leetcode_231_Power_of_Two_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution231Tests {
    private Solution231 solution = new Solution231();

    @Test
    public void should_pass_0() {
        assertFalse(solution.isPowerOfTwo(0));
    }

    @Test
    public void should_pass_1() {
        assertTrue(solution.isPowerOfTwo(1));
    }

    @Test
    public void should_pass_2() {
        assertTrue(solution.isPowerOfTwo(2));
    }

    @Test
    public void should_pass_3() {
        assertFalse(solution.isPowerOfTwo(3));
    }

    @Test
    public void should_pass_4() {
        assertTrue(solution.isPowerOfTwo(4));
    }

    @Test
    public void should_pass_5() {
        assertTrue(solution.isPowerOfTwo(256));
    }

    @Test
    public void should_pass_6() {
        assertFalse(solution.isPowerOfTwo(1000));
    }

    @Test
    public void should_pass_7() {
        assertFalse(solution.isPowerOfTwo(-1));
    }
}