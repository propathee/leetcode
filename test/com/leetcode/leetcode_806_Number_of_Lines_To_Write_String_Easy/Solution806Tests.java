package com.leetcode.leetcode_806_Number_of_Lines_To_Write_String_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution806Tests {
    private Solution806 solution = Solution806.newSolution();

    @Test
    public void should_pass_1() {
        int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        int[] expect = {3, 60};
        assertArrayEquals(expect, solution.numberOfLines(widths, s));
    }

    @Test
    public void should_pass_2() {
        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "bbbcccdddaaa";
        int[] expect = {2, 4};
        assertArrayEquals(expect, solution.numberOfLines(widths, s));
    }
}