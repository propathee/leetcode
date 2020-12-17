package com.leetcode.leetcode_415_Add_Strings_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution415Tests {
    private Solution415 solution = Solution415.newSolution();

    @Test
    public void should_pass_1() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                assertEquals(String.valueOf(i + j), solution.addStrings(String.valueOf(i), String.valueOf(j)));
            }
        }
    }

    @Test
    public void should_pass_2() {
        long n1 = Integer.MAX_VALUE;
        long n2 = Integer.MAX_VALUE;
        String expect = String.valueOf(n1 + n2);
        assertEquals(expect, solution.addStrings(String.valueOf(n1), String.valueOf(n2)));
    }
}