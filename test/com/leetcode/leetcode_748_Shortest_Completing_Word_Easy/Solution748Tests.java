package com.leetcode.leetcode_748_Shortest_Completing_Word_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution748Tests {
    private Solution748 solution = Solution748.newSolution();

    @Test
    public void should_pass_1() {
        String licensePlate = "1s3 PSt";
        String[] words = {"step","steps","stripe","stepple"};
        assertEquals("steps", solution.shortestCompletingWord(licensePlate, words));
    }

    @Test
    public void should_pass_2() {
        String licensePlate = "1s3 456";
        String[] words = {"looks","pest","stew","show"};
        assertEquals("pest", solution.shortestCompletingWord(licensePlate, words));
    }

    @Test
    public void should_pass_3() {
        String licensePlate = "Ah71752";
        String[] words = {"suggest","letter","of","husband","easy","education","drug","prevent","writer","old"};
        assertEquals("husband", solution.shortestCompletingWord(licensePlate, words));
    }
}