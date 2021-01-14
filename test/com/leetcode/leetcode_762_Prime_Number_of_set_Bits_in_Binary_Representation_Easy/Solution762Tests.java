package com.leetcode.leetcode_762_Prime_Number_of_set_Bits_in_Binary_Representation_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution762Tests {
    private Solution762 solution = Solution762.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals(4, solution.countPrimeSetBits(6, 10));
    }

    @Test
    public void should_pass_2() {
        assertEquals(5, solution.countPrimeSetBits(10, 15));
    }
}