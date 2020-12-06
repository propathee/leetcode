package com.leetcode.leetcode_268_Missing_Number_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution268Tests {
    private Solution268 solution = new Solution268();

    @Test
    public void should_pass_1() {
        assertEquals(2, solution.missingNumber(new int[] {3,0,1}));
    }

    @Test
    public void should_pass_2() {
        assertEquals(2, solution.missingNumber(new int[] {0,1}));
    }

    @Test
    public void should_pass_3() {
        assertEquals(8, solution.missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
    }

    @Test
    public void should_pass_4() {
        assertEquals(1, solution.missingNumber(new int[] {0}));
    }

    @Test
    public void should_pass_5() {
        assertEquals(0, solution.missingNumber(new int[] {1,2,3}));
    }

    @Test
    public void should_pass_6() {
        assertEquals(3, solution.missingNumber(new int[] {2,0,1}));
    }
}