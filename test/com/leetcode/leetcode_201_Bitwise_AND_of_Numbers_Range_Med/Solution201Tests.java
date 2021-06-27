package com.leetcode.leetcode_201_Bitwise_AND_of_Numbers_Range_Med;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution201Tests {
    private Solution201 solution = Solution201.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals(4, solution.rangeBitwiseAnd(5, 7));
    }

    @Test
    public void should_pass_2() {
        assertEquals(0, solution.rangeBitwiseAnd(0, 0));
    }

    @Test
    public void should_pass_3() {
        assertEquals(0, solution.rangeBitwiseAnd(1, 2147483647));
    }

    @Test
    public void should_pass_4() {
        assertEquals(1, solution.rangeBitwiseAnd(1, 1));
    }

    @Test
    public void should_pass_5() {
        assertEquals(5, solution.rangeBitwiseAnd(5, 5));
    }
}