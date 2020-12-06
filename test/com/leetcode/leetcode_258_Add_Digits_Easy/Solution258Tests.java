package com.leetcode.leetcode_258_Add_Digits_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution258Tests {
    private Solution258 solution = new Solution258();

    @Test
    public void should_pass_1() {
        assertEquals(2, solution.addDigits(38));
    }

    @Test
    public void should_pass_2() {
        assertEquals(1, solution.addDigits(1));
    }

    @Test
    public void should_pass_3() {
        assertEquals(0, solution.addDigits(0));
    }
}