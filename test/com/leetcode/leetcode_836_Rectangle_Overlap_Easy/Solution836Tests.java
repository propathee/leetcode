package com.leetcode.leetcode_836_Rectangle_Overlap_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution836Tests {
    private Solution836 solution = Solution836.newSolution();

    @Test
    public void should_pass_1() {
        int[] rec1 = {0,0,2,2};
        int[] rec2 = {1,1,3,3};
        assertTrue(solution.isRectangleOverlap(rec1, rec2));
    }

    @Test
    public void should_pass_2() {
        int[] rec1 = {0,0,1,1};
        int[] rec2 = {1,0,2,1};
        assertFalse(solution.isRectangleOverlap(rec1, rec2));
    }

    @Test
    public void should_pass_3() {
        int[] rec1 = {0,0,1,1};
        int[] rec2 = {2,2,3,3};
        assertFalse(solution.isRectangleOverlap(rec1, rec2));
    }

    @Test
    public void should_pass_4() {
        int[] rec1 = {-6,-10,9,2};
        int[] rec2 = {0,5,4,8};
        assertFalse(solution.isRectangleOverlap(rec1, rec2));
    }

    @Test
    public void should_pass_5() {
        int[] rec1 = {-1,0,1,1};
        int[] rec2 = {0,-1,0,1};
        assertFalse(solution.isRectangleOverlap(rec1, rec2));
    }
}