package com.leetcode.leetcode_349_Intersection_of_Two_Arrays_Easy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution349Tests {
    private Solution349 solution = new Solution349();

    @Test
    public void should_pass_1() {
        int[] input1 = new int[] {1,2,2,1};
        int[] input2 = new int[] {2,2};
        int[] expect = new int[] {2};
        assertPass(expect, solution.intersection(input1, input2));
    }

    @Test
    public void should_pass_2() {
        int[] input1 = new int[] {4,9,5};
        int[] input2 = new int[] {9,4,9,8,4};
        int[] expect = new int[] {9,4};
        assertPass(expect, solution.intersection(input1, input2));
    }

    @Test
    public void should_pass_3() {
        int[] input1 = new int[] {1};
        int[] input2 = new int[] {2};
        int[] expect = new int[] {};
        assertPass(expect, solution.intersection(input1, input2));
    }

    private void assertPass(int[] expect, int[] actual) {
        assertEquals(expect.length, actual.length);
        Arrays.sort(expect);
        Arrays.sort(actual);
        assertArrayEquals(expect, actual);
    }
}