package com.leetcode.leetcode_868_Binary_Gap_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution868Tests {
    private Solution868 solution = Solution868.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals(2, solution.binaryGap(22));
    }

    @Test
    public void should_pass_2() {
        assertEquals(2, solution.binaryGap(5));
    }

    @Test
    public void should_pass_3() {
        assertEquals(1, solution.binaryGap(6));
    }

    @Test
    public void should_pass_4() {
        assertEquals(0, solution.binaryGap(8));
    }

    @Test
    public void should_pass_5() {
        assertEquals(0, solution.binaryGap(1));
    }
}