package com.leetcode.leetcode_682_Baseball_Game_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution682Tests {
    private Solution682 solution = Solution682.newSolution();

    @Test
    public void should_pass_1() {
        String[] ops = new String[] {"5","2","C","D","+"};
        assertEquals(30, solution.calPoints(ops));
    }

    @Test
    public void should_pass_2() {
        String[] ops = new String[] {"5","-2","4","C","D","9","+","+"};
        assertEquals(27, solution.calPoints(ops));
    }
}