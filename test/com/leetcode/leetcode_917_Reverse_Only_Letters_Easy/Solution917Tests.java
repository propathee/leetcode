package com.leetcode.leetcode_917_Reverse_Only_Letters_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution917Tests {
    private Solution917 solution = Solution917.newSolution();

    @Test
    public void should_pass_1() {
        String input = "ab-cd";
        String output = "dc-ba";
        assertEquals(output, solution.reverseOnlyLetters(input));
    }

    @Test
    public void should_pass_2() {
        String input = "a-bC-dEf-ghIj";
        String output = "j-Ih-gfE-dCba";
        assertEquals(output, solution.reverseOnlyLetters(input));
    }

    @Test
    public void should_pass_3() {
        String input = "Test1ng-Leet=code-Q!";
        String output = "Qedo1ct-eeLg=ntse-T!";
        assertEquals(output, solution.reverseOnlyLetters(input));
    }
}