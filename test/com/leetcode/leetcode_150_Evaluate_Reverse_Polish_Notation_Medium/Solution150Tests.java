package com.leetcode.leetcode_150_Evaluate_Reverse_Polish_Notation_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution150Tests {
    private Solution150 solution = Solution150.newSolution();

    @Test
    public void should_pass_1() {
        String[] tokens = {"2","1","+","3","*"};
        assertEquals(9, solution.evalRPN(tokens));
    }

    @Test
    public void should_pass_2() {
        String[] tokens = {"4","13","5","/","+"};
        assertEquals(6, solution.evalRPN(tokens));
    }

    @Test
    public void should_pass_3() {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        assertEquals(22, solution.evalRPN(tokens));
    }
}