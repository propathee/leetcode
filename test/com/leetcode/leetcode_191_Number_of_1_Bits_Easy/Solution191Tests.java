package com.leetcode.leetcode_191_Number_of_1_Bits_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution191Tests {
    private Solution191 solution = new Solution191();

    @Test
    public void should_pass_1() {
        assertEquals(3, solution.hammingWeight(11));
    }

    @Test
    public void should_pass_2() {
        assertEquals(1, solution.hammingWeight(8));
    }

    @Test
    public void should_pass_3() {
        assertEquals(2, solution.hammingWeight(3));
    }
}