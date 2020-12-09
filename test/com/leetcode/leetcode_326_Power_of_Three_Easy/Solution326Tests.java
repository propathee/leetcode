package com.leetcode.leetcode_326_Power_of_Three_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution326Tests {
    private Solution326 solution = new Solution326();

    @Test
    public void should_pass_0() {
        assertFalse(solution.isPowerOfThree(0));
    }

    @Test
    public void should_pass_1() {
        assertTrue(solution.isPowerOfThree(1));
    }

    @Test
    public void should_pass_2() {
        assertFalse(solution.isPowerOfThree(2));
    }

    @Test
    public void should_pass_3() {
        assertTrue(solution.isPowerOfThree(3));
    }

    @Test
    public void should_pass_4() {
        assertTrue(solution.isPowerOfThree(9));
    }

    @Test
    public void should_pass_5() {
        assertTrue(solution.isPowerOfThree(27));
    }

    @Test
    public void should_pass_6() {
        assertFalse(solution.isPowerOfThree(45));
    }

    @Test
    public void should_pass_7() {
        assertFalse(solution.isPowerOfThree(-3));
    }
}