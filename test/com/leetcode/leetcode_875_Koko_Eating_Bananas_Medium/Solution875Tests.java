package com.leetcode.leetcode_875_Koko_Eating_Bananas_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution875Tests {
    private Solution875 solution = Solution875.newSolution();

    @Test
    public void should_pass_1() {
        int[] piles = {3,6,7,11};
        assertEquals(4, solution.minEatingSpeed(piles, 8));
    }

    @Test
    public void should_pass_2() {
        int[] piles = {30,11,23,4,20};
        assertEquals(30, solution.minEatingSpeed(piles, 5));
    }

    @Test
    public void should_pass_3() {
        int[] piles = {30,11,23,4,20};
        assertEquals(23, solution.minEatingSpeed(piles, 6));
    }

    @Test
    public void should_pass_4() {
        int[] piles = {312884470};
        assertEquals(1, solution.minEatingSpeed(piles, 968709470));
    }

    @Test
    public void should_pass_5() {
        int[] piles = {312884470};
        assertEquals(2, solution.minEatingSpeed(piles, 312884469));
    }
}