package com.leetcode.leetcode_557_Reverse_Words_in_a_String_III_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution557Tests {
    private Solution557 solution = Solution557.newSolution();

    @Test
    public void should_pass_1() {
        String input = "Let's take LeetCode contest";
        String expect = "s'teL ekat edoCteeL tsetnoc";
        assertEquals(expect, solution.reverseWords(input));
    }

    @Test
    public void should_pass_2() {
        String input = "a";
        String expect = "a";
        assertEquals(expect, solution.reverseWords(input));
    }

    @Test
    public void should_pass_3() {
        String input = "ac";
        String expect = "ca";
        assertEquals(expect, solution.reverseWords(input));
    }
}