package com.leetcode.leetcode_888_Fair_Candy_Swap_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution888Tests {
    private Solution888 solution = Solution888.newSolution();

    @Test
    public void should_pass_1() {
        int[] A = {1,1};
        int[] B = {2,2};
        int[] exchange = {1,2};
        assertArrayEquals(exchange, solution.fairCandySwap(A, B));
    }

    @Test
    public void should_pass_2() {
        int[] A = {1,2};
        int[] B = {2,3};
        int[] exchange = {1,2};
        assertArrayEquals(exchange, solution.fairCandySwap(A, B));
    }

    @Test
    public void should_pass_3() {
        int[] A = {2};
        int[] B = {1,3};
        int[] exchange = {2,3};
        assertArrayEquals(exchange, solution.fairCandySwap(A, B));
    }

    @Test
    public void should_pass_4() {
        int[] A = {1,2,5};
        int[] B = {2,4};
        int[] exchange = {5,4};
        assertArrayEquals(exchange, solution.fairCandySwap(A, B));
    }
}