package com.leetcode.leetcode_540_Single_Element_in_a_Sorted_Array_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution540Tests {
    private Solution540 solution = Solution540.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = {1,1,2,3,3,4,4,8,8};
        assertEquals(2, solution.singleNonDuplicate(nums));
    }

    @Test
    public void should_pass_2() {
        int[] nums = {3,3,7,7,10,11,11};
        assertEquals(10, solution.singleNonDuplicate(nums));
    }

    @Test
    public void should_pass_3() {
        int[] nums = {1};
        assertEquals(1, solution.singleNonDuplicate(nums));
    }
}