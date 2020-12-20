package com.leetcode.leetcode_492_Construct_the_Rectangle_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution492Tests {
    private Solution492 solution = Solution492.newSolution();

    @Test
    public void should_pass_1() {
        int[] expect = new int[] {2, 2};
        assertArrayEquals(expect, solution.constructRectangle(4));
    }

    @Test
    public void should_pass_2() {
        int[] expect = new int[] {37, 1};
        assertArrayEquals(expect, solution.constructRectangle(37));
    }

    @Test
    public void should_pass_3() {
        int[] expect = new int[] {427, 286};
        assertArrayEquals(expect, solution.constructRectangle(122122));
    }
}