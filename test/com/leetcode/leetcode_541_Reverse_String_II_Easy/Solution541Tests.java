package com.leetcode.leetcode_541_Reverse_String_II_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution541Tests {
    private Solution541 solution = Solution541.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals("bacdfeg", solution.reverseStr("abcdefg", 2));
    }

    @Test
    public void should_pass_2() {
        assertEquals("a", solution.reverseStr("a", 1));
    }

    @Test
    public void should_pass_3() {
        assertEquals("a", solution.reverseStr("a", 2));
    }

    @Test
    public void should_pass_4() {
        assertEquals("ab", solution.reverseStr("ba", 3));
    }

    @Test
    public void should_pass_5() {
        assertEquals("bacde", solution.reverseStr("abcde", 2));
    }

    @Test
    public void should_pass_6() {
        assertEquals("bacdfe", solution.reverseStr("abcdef", 2));
    }
}