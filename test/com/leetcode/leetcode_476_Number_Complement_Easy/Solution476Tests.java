package com.leetcode.leetcode_476_Number_Complement_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution476Tests {
    private Solution476 solution = Solution476.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals(2, solution.findComplement(5));
    }

    @Test
    public void should_pass_2() {
        assertEquals(0, solution.findComplement(1));
    }

    @Test
    public void should_pass_3() {
        assertEquals(7, solution.findComplement(8));
    }

    @Test
    public void should_pass_4() {
        assertEquals(0, solution.findComplement(7));
    }
    @Test
    public void should_pass_5() {
        assertEquals(0, solution.findComplement(2147483647));
    }
}