package com.leetcode.leetcode_229_Majority_Element_II_Medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Solution229Tests {
    private Solution229 solution = Solution229.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = {3,2,3};
        List<Integer> actual = solution.majorityElement(nums);
        List<Integer> expect = Arrays.asList(3);
        assertEquals(expect, actual);
    }

    @Test
    public void should_pass_2() {
        int[] nums = {1};
        List<Integer> actual = solution.majorityElement(nums);
        List<Integer> expect = Arrays.asList(1);
        assertEquals(expect, actual);
    }

    @Test
    public void should_pass_3() {
        int[] nums = {1,2};
        List<Integer> actual = solution.majorityElement(nums);
        List<Integer> expect = Arrays.asList(1,2);
        assertEquals(expect, actual);
    }
}