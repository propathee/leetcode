package com.leetcode.leetcode_496_Next_Greater_Element_I_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution496Tests {
    private Solution496 solution = Solution496.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums1 = new int[] {4, 1, 2};
        int[] nums2 = new int[] {1, 3, 4, 2};
        int[] expect = new int[] {-1, 3, -1};
        assertArrayEquals(expect, solution.nextGreaterElement(nums1, nums2));
    }

    @Test
    public void should_pass_2() {
        int[] nums1 = new int[] {2, 4};
        int[] nums2 = new int[] {1, 2, 3, 4};
        int[] expect = new int[] {3, -1};
        assertArrayEquals(expect, solution.nextGreaterElement(nums1, nums2));
    }
}