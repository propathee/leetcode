package com.leetcode.leetcode_658_Find_K_Closest_Elements_Medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Solution658Tests {
    private Solution658 solution = Solution658.newSolution();

    @Test
    public void should_pass_1() {
        int[] arr = {1,2,3,4,5};
        List<Integer> expect = Arrays.asList(1,2,3,4);
        assertEquals(expect, solution.findClosestElements(arr, 4, 3));
    }

    @Test
    public void should_pass_2() {
        int[] arr = {1,2,3,4,5};
        List<Integer> expect = Arrays.asList(1,2,3,4);
        assertEquals(expect, solution.findClosestElements(arr, 4, -1));
    }

    @Test
    public void should_pass_3() {
        int[] arr = {1,2,5,9,10,11,15,17};
        List<Integer> expect = Arrays.asList(5,9,10,11);
        assertEquals(expect, solution.findClosestElements(arr, 4, 8));
    }

    @Test
    public void should_pass_4() {
        int[] arr = {1,2,3,4,5};
        List<Integer> expect = Arrays.asList(3,4,5);
        assertEquals(expect, solution.findClosestElements(arr, 3, 6));
    }

    @Test
    public void should_pass_5() {
        int[] arr = {0,0,1,2,3,3,4,7,7,8};
        List<Integer> expect = Arrays.asList(3,3,4);
        assertEquals(expect, solution.findClosestElements(arr, 3, 5));
    }

    @Test
    public void should_pass_6() {
        int[] arr = {1,1,2,2,2,2,2,3,3};
        List<Integer> expect = Arrays.asList(2,3,3);
        assertEquals(expect, solution.findClosestElements(arr, 3, 3));
    }
}