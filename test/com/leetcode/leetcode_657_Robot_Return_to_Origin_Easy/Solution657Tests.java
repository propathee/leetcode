package com.leetcode.leetcode_657_Robot_Return_to_Origin_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution657Tests {
    private Solution657 solution = Solution657.newSolution();

    @Test
    public void should_pass_1() {
        String moves = "UD";
        assertTrue(solution.judgeCircle(moves));
    }

    @Test
    public void should_pass_2() {
        String moves = "LL";
        assertFalse(solution.judgeCircle(moves));
    }

    @Test
    public void should_pass_3() {
        String moves = "RRDD";
        assertFalse(solution.judgeCircle(moves));
    }
    @Test
    public void should_pass_4() {
        String moves = "LDRRLRUULR";
        assertFalse(solution.judgeCircle(moves));
    }

    @Test
    public void should_pass_5() {
        String moves = "LR";
        assertTrue(solution.judgeCircle(moves));
    }

    @Test
    public void should_pass_6() {
        String moves = "UDLR";
        assertTrue(solution.judgeCircle(moves));
    }
}