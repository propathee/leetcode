package com.leetcode.leetcode_345_Reverse_Vowels_of_a_String_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution345Tests {
    private Solution345 solution = new Solution345();

    @Test
    public void should_pass_1() {
        assertEquals("holle", solution.reverseVowels("hello"));
    }

    @Test
    public void should_pass_2() {
        assertEquals("leotcede", solution.reverseVowels("leetcode"));
    }

    @Test
    public void should_pass_3() {
        assertEquals("", solution.reverseVowels(""));
    }

    @Test
    public void should_pass_4() {
        assertEquals("l", solution.reverseVowels("l"));
    }

    @Test
    public void should_pass_5() {
        assertEquals("hOlle", solution.reverseVowels("hellO"));
    }

    @Test
    public void should_pass_6() {
        assertEquals("bmw", solution.reverseVowels("bmw"));
    }

    @Test
    public void should_pass_7() {
        assertEquals("abc", solution.reverseVowels("abc"));
    }
}