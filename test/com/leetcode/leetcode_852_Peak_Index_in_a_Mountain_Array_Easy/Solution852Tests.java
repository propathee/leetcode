package com.leetcode.leetcode_852_Peak_Index_in_a_Mountain_Array_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution852Tests {
    private Solution852 solution = Solution852.newSolution();

    @Test
    public void should_pass_1() {
        int[] arr = {0,1,0};
        assertEquals(1, solution.peakIndexInMountainArray(arr));
    }

    @Test
    public void should_pass_2() {
        int[] arr = {0,2,1,0};
        assertEquals(1, solution.peakIndexInMountainArray(arr));
    }

    @Test
    public void should_pass_3() {
        int[] arr = {0,10,5,2};
        assertEquals(1, solution.peakIndexInMountainArray(arr));
    }

    @Test
    public void should_pass_4() {
        int[] arr = {3,4,5,1};
        assertEquals(2, solution.peakIndexInMountainArray(arr));
    }

    @Test
    public void should_pass_5() {
        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        assertEquals(2, solution.peakIndexInMountainArray(arr));
    }

    @Test
    public void should_pass_6() {
        int[] arr = {18,29,38,59,98,100,99,98,90};
        assertEquals(5, solution.peakIndexInMountainArray(arr));
    }
}