package com.leetcode.leetcode_976_Largest_Perimeter_Triangle_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution976Tests {
    private Solution976 solution = Solution976.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = {2,1,2};
        assertEquals(5, solution.largestPerimeter(input));
    }

    @Test
    public void should_pass_2() {
        int[] input = {1,2,1};
        assertEquals(0, solution.largestPerimeter(input));
    }

    @Test
    public void should_pass_3() {
        int[] input = {3,2,3,4};
        assertEquals(10, solution.largestPerimeter(input));
    }

    @Test
    public void should_pass_4() {
        int[] input = {3,6,2,3};
        assertEquals(8, solution.largestPerimeter(input));
    }
}