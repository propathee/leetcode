package com.leetcode.leetcode_704_Binary_Search_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution704Tests {
    private Solution704 solution = Solution704.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = new int[] {-1,0,3,5,9,12};
        assertEquals(4, solution.search(nums, 9));
    }

    @Test
    public void should_pass_2() {
        int[] nums = new int[] {-1,0,3,5,9,12};
        assertEquals(-1, solution.search(nums, 2));
    }

    @Test
    public void should_pass_3() {
        int[] nums = new int[] {1};
        assertEquals(0, solution.search(nums, 1));
    }

    @Test
    public void should_pass_4() {
        int[] nums = new int[] {1};
        assertEquals(-1, solution.search(nums, 2));
    }

    @Test
    public void should_pass_5() {
        int[] nums = new int[] {1,2};
        assertEquals(0, solution.search(nums, 1));
    }

    @Test
    public void should_pass_6() {
        int[] nums = new int[] {1,2};
        assertEquals(1, solution.search(nums, 2));
    }

    @Test
    public void should_pass_7() {
        int[] nums = new int[] {1,2};
        assertEquals(-1, solution.search(nums, 0));
    }

    @Test
    public void should_pass_8() {
        int[] nums = new int[] {1,2};
        assertEquals(-1, solution.search(nums, 3));
    }
}