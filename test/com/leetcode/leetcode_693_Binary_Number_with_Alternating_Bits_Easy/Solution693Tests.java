package com.leetcode.leetcode_693_Binary_Number_with_Alternating_Bits_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution693Tests {
    private Solution693 solution = Solution693.newSolution();

    @Test
    public void should_pass_1() {
        assertTrue(solution.hasAlternatingBits(5));
    }

    @Test
    public void should_pass_2() {
        assertFalse(solution.hasAlternatingBits(7));
    }

    @Test
    public void should_pass_3() {
        assertFalse(solution.hasAlternatingBits(11));
    }

    @Test
    public void should_pass_4() {
        assertTrue(solution.hasAlternatingBits(10));
    }

    @Test
    public void should_pass_5() {
        assertFalse(solution.hasAlternatingBits(3));
    }
}