package com.leetcode.leetcode_500_Keyboard_Row_Easy;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution500Tests {
    private Solution500 solution = Solution500.newSolution();

    @Test
    public void should_pass_1() {
        String[] input = new String[] {"Hello", "Alaska", "Dad", "Peace"};
        String[] expect = new String[] {"Alaska", "Dad"};
        assertArrayEquals(expect, solution.findWords(input));
    }

    @Test
    public void should_pass_2() {
        String[] input = new String[] {};
        String[] expect = new String[] {};
        assertArrayEquals(expect, solution.findWords(input));
    }

    @Ignore
    public void should_pass_3() {
        String[] input = new String[] {""};
        String[] expect = new String[] {""};
        assertArrayEquals(expect, solution.findWords(input));
    }
}