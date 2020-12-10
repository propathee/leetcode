package com.leetcode.leetcode_344_Reverse_String_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution344Tests {
    private Solution344 solution = new Solution344();

    @Test
    public void should_pass_1() {
        char[] input = "hello".toCharArray();
        char[] expect = "olleh".toCharArray();
        solution.reverseString(input);
        assertArrayEquals(expect, input);
    }

    @Test
    public void should_pass_2() {
        char[] input = "Hannah".toCharArray();
        char[] expect = "hannaH".toCharArray();
        solution.reverseString(input);
        assertArrayEquals(expect, input);
    }

    @Test
    public void should_pass_3() {
        char[] input = "h".toCharArray();
        char[] expect = "h".toCharArray();
        solution.reverseString(input);
        assertArrayEquals(expect, input);
    }

    @Test
    public void should_pass_4() {
        char[] input = "".toCharArray();
        char[] expect = "".toCharArray();
        solution.reverseString(input);
        assertArrayEquals(expect, input);
    }

    @Test
    public void should_pass_5() {
        char[] input = "he".toCharArray();
        char[] expect = "eh".toCharArray();
        solution.reverseString(input);
        assertArrayEquals(expect, input);
    }

    @Test
    public void should_pass_6() {
        char[] input = "abc".toCharArray();
        char[] expect = "cba".toCharArray();
        solution.reverseString(input);
        assertArrayEquals(expect, input);
    }
}