package com.leetcode.leetcode_405_Convert_a_Number_to_Hexadecimal_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution405Tests {
    private Solution405 solution = Solution405.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals("0", solution.toHex(0));
    }

    @Test
    public void should_pass_2() {
        assertEquals("1a", solution.toHex(26));
    }

    @Test
    public void should_pass_3() {
        assertEquals("ffffffff", solution.toHex(-1));
    }

    @Test
    public void should_pass_4() {
        assertEquals("0", solution.toHex(0));
    }

    @Test
    public void should_pass_5() {
        for (int i = -100000; i < 0; i++) {
            assertEquals(Integer.toHexString(i), solution.toHex(i));
        }
    }

    @Test
    public void should_pass_6() {
        for (int i = 0; i < 100000; i++) {
            assertEquals(Integer.toHexString(i), solution.toHex(i));
        }
    }

    @Test
    public void should_pass_7() {
        int n = Integer.MAX_VALUE;
        assertEquals(Integer.toHexString(n), solution.toHex(n));
    }

    @Test
    public void should_pass_8() {
        int n = Integer.MIN_VALUE;
        assertEquals(Integer.toHexString(n), solution.toHex(n));
    }
}