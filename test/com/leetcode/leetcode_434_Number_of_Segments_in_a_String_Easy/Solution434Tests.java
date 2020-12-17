package com.leetcode.leetcode_434_Number_of_Segments_in_a_String_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution434Tests {
    private Solution434 solution = Solution434.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals(5, solution.countSegments("Hello, my name is John"));
    }

    @Test
    public void should_pass_2() {
        assertEquals(1, solution.countSegments("Hello"));
    }

    @Test
    public void should_pass_3() {
        assertEquals(4, solution.countSegments("love live! mu'sic forever"));
    }

    @Test
    public void should_pass_4() {
        assertEquals(0, solution.countSegments(""));
    }

    @Test
    public void should_pass_5() {
        assertEquals(2, solution.countSegments(" a b"));
    }

    @Test
    public void should_pass_6() {
        assertEquals(2, solution.countSegments("a b "));
    }

    @Test
    public void should_pass_7() {
        assertEquals(2, solution.countSegments("a  b"));
    }

    @Test
    public void should_pass_8() {
        assertEquals(0, solution.countSegments("  "));
    }
}