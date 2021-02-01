package com.leetcode.leetcode_860_Lemonade_Change_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution860Tests {
    private Solution860 solution = Solution860.newSolution();

    @Test
    public void should_pass_1() {
        int[] bills = {5,5,5,10,20};
        assertTrue(solution.lemonadeChange(bills));
    }

    @Test
    public void should_pass_2() {
        int[] bills = {5,5,10};
        assertTrue(solution.lemonadeChange(bills));
    }

    @Test
    public void should_pass_3() {
        int[] bills = {10,10};
        assertFalse(solution.lemonadeChange(bills));
    }

    @Test
    public void should_pass_4() {
        int[] bills = {5,5,10,10,20};
        assertFalse(solution.lemonadeChange(bills));
    }
}