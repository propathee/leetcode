package com.leetcode.leetcode_292_Nim_Game_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution292Tests {
    private Solution292 solution = new Solution292();

    @Test
    public void should_pass_1() {
        assertTrue(solution.canWinNim(1));
    }

    @Test
    public void should_pass_2() {
        assertTrue(solution.canWinNim(2));
    }

    @Test
    public void should_pass_3() {
        assertTrue(solution.canWinNim(3));
    }

    @Test
    public void should_pass_4() {
        assertFalse(solution.canWinNim(4));
    }
    @Test
    public void should_pass_5() {
        assertTrue(solution.canWinNim(5));
    }

    @Test
    public void should_pass_6() {
        assertTrue(solution.canWinNim(6));
    }

    @Test
    public void should_pass_7() {
        assertTrue(solution.canWinNim(7));
    }

    @Test
    public void should_pass_8() {
        assertFalse(solution.canWinNim(8));
    }
}