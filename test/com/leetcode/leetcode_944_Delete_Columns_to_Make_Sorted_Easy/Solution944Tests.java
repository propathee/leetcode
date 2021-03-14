package com.leetcode.leetcode_944_Delete_Columns_to_Make_Sorted_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution944Tests {
    private Solution944 solution = Solution944.newSolution();

    @Test
    public void should_pass_1() {
        String[] input = {"cba", "daf", "ghi"};
        assertEquals(1, solution.minDeletionSize(input));
    }

    @Test
    public void should_pass_2() {
        String[] input = {"a", "b"};
        assertEquals(0, solution.minDeletionSize(input));
    }

    @Test
    public void should_pass_3() {
        String[] input = {"zyx","wvu","tsr"};
        assertEquals(3, solution.minDeletionSize(input));
    }
}