package com.leetcode.leetcode_4_Median_of_Two_Sorted_Arrays_Hard;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution4Tests {
    private Solution4 solution = Solution4.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        assertEquals(2.0, solution.findMedianSortedArrays(nums1, nums2), 0.);
    }

    @Test
    public void should_pass_2() {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), 0.);
    }

    @Test
    public void should_pass_3() {
        int[] nums1 = {};
        int[] nums2 = {1};
        assertEquals(1.0, solution.findMedianSortedArrays(nums1, nums2), 0.);
    }

    @Test
    public void should_pass_4() {
        int[] nums1 = {2};
        int[] nums2 = {};
        assertEquals(2.0, solution.findMedianSortedArrays(nums1, nums2), 0.);
    }

    @Test
    public void should_pass_5() {
        int[] nums1 = {1,3};
        int[] nums2 = {2,7};
        assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), 0.);
    }

    @Test
    public void should_pass_6() {
        int[] nums1 = {3,4};
        int[] nums2 = {};
        assertEquals(3.5, solution.findMedianSortedArrays(nums1, nums2), 0.);
    }

    @Test
    public void should_pass_7() {
        int[] nums1 = {3,4,5};
        int[] nums2 = {1,2};
        assertEquals(3.0, solution.findMedianSortedArrays(nums1, nums2), 0.);
    }

    @Test
    public void should_pass_8() {
        int[] nums1 = {};
        int[] nums2 = {1};
        assertEquals(1.0, solution.findMedianSortedArrays(nums1, nums2), 0.);
    }
}