package com.leetcode.leetcode_227_Basic_Calculator_II_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution227Tests {
    private Solution227 solution = Solution227.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals(7, solution.calculate("3+2*2"));
    }

    @Test
    public void should_pass_2() {
        assertEquals(1, solution.calculate(" 3/2 "));
    }

    @Test
    public void should_pass_3() {
        assertEquals(5, solution.calculate(" 3+5 / 2 "));
    }
}