package com.leetcode.leetcode_628_Maximum_Product_of_Three_Numbers_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution628Tests {
    private Solution628 solution = Solution628.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = new int[] {1,2,3};
        assertEquals(6, solution.maximumProduct(nums));
    }

    @Test
    public void should_pass_2() {
        int[] nums = new int[] {1,2,3,4};
        assertEquals(24, solution.maximumProduct(nums));
    }

    @Test
    public void should_pass_3() {
        int[] nums = new int[] {-1,-2,-3};
        assertEquals(-6, solution.maximumProduct(nums));
    }

    @Test
    public void should_pass_4() {
        int[] nums = new int[] {-100,-98,-1,2,3,4};
        assertEquals(39200, solution.maximumProduct(nums));
    }
}