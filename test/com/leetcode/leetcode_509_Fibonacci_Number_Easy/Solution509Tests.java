package com.leetcode.leetcode_509_Fibonacci_Number_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution509Tests {
    private Solution509 solution = Solution509.newSolution();

    @Test
    public void should_pass_0() {
        assertEquals(0, solution.fib(0));
    }

    @Test
    public void should_pass_1() {
        assertEquals(1, solution.fib(1));
    }

    @Test
    public void should_pass_2() {
        assertEquals(1, solution.fib(2));
    }
    @Test
    public void should_pass_3() {
        assertEquals(2, solution.fib(3));
    }

    @Test
    public void should_pass_4() {
        assertEquals(3, solution.fib(4));
    }
}