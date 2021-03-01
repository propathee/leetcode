package com.leetcode.leetcode_937_Reorder_Data_in_Log_Files_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution937Tests {
    private Solution937 solution = Solution937.newSolution();

    @Test
    public void should_pass_1() {
        String[] input = {
            "dig1 8 1 5 1",
            "let1 art can",
            "dig2 3 6",
            "let2 own kit dig",
            "let3 art zero"};
        String[] output = {
            "let1 art can",
            "let3 art zero",
            "let2 own kit dig",
            "dig1 8 1 5 1",
            "dig2 3 6"};
        assertArrayEquals(output, solution.reorderLogFiles(input));
    }

    @Test
    public void should_pass_2() {
        String[] input = {
            "a1 9 2 3 1",
            "g1 act car",
            "zo4 4 7",
            "ab1 off key dog",
            "a8 act zoo"};
        String[] output = {
            "g1 act car",
            "a8 act zoo",
            "ab1 off key dog",
            "a1 9 2 3 1",
            "zo4 4 7"};
        assertArrayEquals(output, solution.reorderLogFiles(input));
    }
}