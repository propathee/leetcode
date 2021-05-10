package com.leetcode.leetcode_189_Rotate_Array_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution189Tests {
    private Solution189 solution = Solution189.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = {1,2,3,4,5,6,7};
        int[] expect = {5,6,7,1,2,3,4};
        solution.rotate(input, 3);
        assertArrayEquals(expect, input);
    }

    @Test
    public void should_pass_2() {
        int[] input = {-1,-100,3,99};
        int[] expect = {3,99,-1,-100};
        solution.rotate(input, 2);
        assertArrayEquals(expect, input);
    }

    @Test
    public void should_pass_3() {
        int[] input = {1,2,3};
        int[] expect = {1,2,3};
        solution.rotate(input, 3);
        assertArrayEquals(expect, input);
    }

    @Test
    public void should_pass_4() {
        int[] input = {1,2,3};
        int[] expect = {3,1,2};
        solution.rotate(input, 4);
        assertArrayEquals(expect, input);
    }
}