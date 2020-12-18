package com.leetcode.leetcode_453_Minimum_Moves_to_Equal_Array_Elements_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution453Tests {
    private Solution453 solution = Solution453.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = new int[] {1, 2, 3};
        assertEquals(3, solution.minMoves(input));
    }

    @Test
    public void should_pass_2() {
        int[] input = new int[] {1};
        assertEquals(0, solution.minMoves(input));
    }

    @Test
    public void should_pass_3() {
        int[] input = new int[] {1, 2};
        assertEquals(1, solution.minMoves(input));
    }

    @Test
    public void should_pass_4() {
        int[] input = new int[] {1, 3};
        assertEquals(2, solution.minMoves(input));
    }

    @Test
    public void should_pass_5() {
        int[] input = new int[] {1, 1};
        assertEquals(0, solution.minMoves(input));
    }

    @Test
    public void should_pass_6() {
        int[] input = new int[] {1, 2, 5};
        assertEquals(5, solution.minMoves(input));
    }

    @Test
    public void should_pass_7() {
        int[] input = new int[] {1, 3, 7};
        assertEquals(8, solution.minMoves(input));
    }

    @Test
    public void should_pass_8() {
        int[] input = new int[] {1, 2, 3, 4};
        assertEquals(6, solution.minMoves(input));
    }

    @Test
    public void should_pass_9() {
        int[] input = new int[] {2, 5, 8, 10};
        assertEquals(17, solution.minMoves(input));
    }

    @Test
    public void should_pass_10() {
        int[] input = new int[] {2, 2, 5, 9};
        assertEquals(10, solution.minMoves(input));
    }
}