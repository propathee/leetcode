package com.leetcode.leetcode_283_Move_Zeroes_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution283Tests {
    private Solution283 solution = new Solution283();

    @Test
    public void should_pass_1() {
        int[] input = new int[] {0,1,0,3,12};
        int[] expect = new int[] {1,3,12,0,0};
        solution.moveZeroes(input);
        assertArrayEquals(expect, input);
    }

    @Test
    public void should_pass_2() {
        int[] input = new int[] {0};
        int[] expect = new int[] {0};
        solution.moveZeroes(input);
        assertArrayEquals(expect, input);
    }

    @Test
    public void should_pass_3() {
        int[] input = new int[] {1};
        int[] expect = new int[] {1};
        solution.moveZeroes(input);
        assertArrayEquals(expect, input);
    }

    @Test
    public void should_pass_4() {
        int[] input = new int[] {};
        int[] expect = new int[] {};
        solution.moveZeroes(input);
        assertArrayEquals(expect, input);
    }
}