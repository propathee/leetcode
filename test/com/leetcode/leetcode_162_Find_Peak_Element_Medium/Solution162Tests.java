package com.leetcode.leetcode_162_Find_Peak_Element_Medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Solution162Tests {
    private Solution162 solution = Solution162.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = {1,2,3,1};
        assertContains(new int[]{2}, solution.findPeakElement(nums));
    }

    @Test
    public void should_pass_2() {
        int[] nums = {1,2,1,3,5,6,4};
        assertContains(new int[]{1,5}, solution.findPeakElement(nums));
    }

    @Test
    public void should_pass_3() {
        int[] nums = {1,2};
        assertContains(new int[]{1}, solution.findPeakElement(nums));
    }

    private void assertContains(int[] peeks, int res) {
        List<Integer> list = Arrays.stream(peeks).boxed().collect(Collectors.toList());
        assertTrue(list.contains(res));
    }
}