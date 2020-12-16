package com.leetcode.leetcode_414_Third_Maximum_Number_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution414Tests {
    private Solution414 solution = Solution414.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = new int[] {3, 2, 1};
        assertEquals(1, solution.thirdMax(input));
    }

    @Test
    public void should_pass_2() {
        int[] input = new int[] {1, 2};
        assertEquals(2, solution.thirdMax(input));
    }

    @Test
    public void should_pass_3() {
        int[] input = new int[] {2, 2, 3, 1};
        assertEquals(1, solution.thirdMax(input));
    }

    @Test
    public void should_pass_4() {
        int[] input = new int[] {1};
        assertEquals(1, solution.thirdMax(input));
    }

    @Test
    public void should_pass_5() {
        int[] input = new int[] {1, 2, 2};
        assertEquals(2, solution.thirdMax(input));
    }

    @Test
    public void should_pass_6() {
        int[] input = new int[] {1, 2, 3, 4, 2};
        assertEquals(2, solution.thirdMax(input));
    }
}