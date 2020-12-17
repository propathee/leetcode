package com.leetcode.leetcode_441_Arranging_Coins_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution441Tests {
    private Solution441 solution = Solution441.newSolution();

    @Test
    public void should_pass_0() {
        assertEquals(0, solution.arrangeCoins(0));
    }

    @Test
    public void should_pass_1() {
        assertEquals(1, solution.arrangeCoins(1));
    }

    @Test
    public void should_pass_2() {
        assertEquals(1, solution.arrangeCoins(2));
    }
    @Test
    public void should_pass_3() {
        assertEquals(2, solution.arrangeCoins(3));
    }
    @Test
    public void should_pass_4() {
        assertEquals(2, solution.arrangeCoins(5));
    }

    @Test
    public void should_pass_5() {
        assertEquals(3, solution.arrangeCoins(6));
    }

    @Test
    public void should_pass_6() {
        assertEquals(3, solution.arrangeCoins(9));
    }

    @Test
    public void should_pass_7() {
        assertEquals(4, solution.arrangeCoins(10));
    }

    @Test
    public void should_pass_8() {
        assertEquals(60070, solution.arrangeCoins(1804289383));
    }
}