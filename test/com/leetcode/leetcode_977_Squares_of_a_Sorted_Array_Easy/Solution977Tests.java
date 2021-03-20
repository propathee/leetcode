package com.leetcode.leetcode_977_Squares_of_a_Sorted_Array_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution977Tests {
    private Solution977 solution = Solution977.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = {-4,-1,0,3,10};
        int[] output = {0,1,9,16,100};
        assertArrayEquals(output, solution.sortedSquares(input));
    }

    @Test
    public void should_pass_2() {
        int[] input = {-7,-3,2,3,11};
        int[] output = {4,9,9,49,121};
        assertArrayEquals(output, solution.sortedSquares(input));
    }

    @Test
    public void should_pass_3() {
        int[] input = {0};
        int[] output = {0};
        assertArrayEquals(output, solution.sortedSquares(input));
    }

    @Test
    public void should_pass_4() {
        int[] input = {-1};
        int[] output = {1};
        assertArrayEquals(output, solution.sortedSquares(input));
    }
}