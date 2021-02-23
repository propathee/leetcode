package com.leetcode.leetcode_925_Long_Pressed_Name_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution925Tests {
    private Solution925 solution = Solution925.newSolution();

    @Test
    public void should_pass_1() {
        assertTrue(solution.isLongPressedName("alex", "aaleex"));
    }

    @Test
    public void should_pass_2() {
        assertFalse(solution.isLongPressedName("saeed", "ssaaedd"));
    }

    @Test
    public void should_pass_3() {
        assertTrue(solution.isLongPressedName("leelee", "lleeelee"));
    }

    @Test
    public void should_pass_4() {
        assertTrue(solution.isLongPressedName("laiden", "laiden"));
    }

    @Test
    public void should_pass_5() {
        assertTrue(solution.isLongPressedName("vtkgn", "vttkgnn"));
    }
}