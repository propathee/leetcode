package com.leetcode.leetcode_643_Maximum_Average_Subarray_I_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution643Tests {
    private Solution643 solution = Solution643.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = new int[] {1,12,-5,-6,50,3};
        int k = 4;
        assertEquals(12.75, solution.findMaxAverage(input, k), 0.0);
    }

    @Test
    public void should_pass_2() {
        int[] input = new int[] {0,4,0,3,2};
        int k = 1;
        assertEquals(4.0, solution.findMaxAverage(input, k), 0.0);
    }

    @Test
    public void should_pass_3() {
        int[] input = new int[] {5};
        int k = 1;
        assertEquals(5.0, solution.findMaxAverage(input, k), 0.0);
    }

    @Test
    public void should_pass_4() {
        int[] input = new int[] {0,1,1,3,3};
        int k = 4;
        assertEquals(2.0, solution.findMaxAverage(input, k), 0.0);
    }
}