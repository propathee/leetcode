package com.leetcode.leetcode_507_Perfect_Number_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution507Tests {
    private Solution507 solution = Solution507.newSolution();

    @Test
    public void should_pass_1() {
        assertTrue(solution.checkPerfectNumber(28));
    }

    @Test
    public void should_pass_2() {
        assertTrue(solution.checkPerfectNumber(6));
    }

    @Test
    public void should_pass_3() {
        assertTrue(solution.checkPerfectNumber(496));
    }

    @Test
    public void should_pass_4() {
        assertTrue(solution.checkPerfectNumber(8128));
    }

    @Test
    public void should_pass_5() {
        assertFalse(solution.checkPerfectNumber(8));
    }

    @Test
    public void should_pass_6() {
        assertFalse(solution.checkPerfectNumber(1));
    }
}