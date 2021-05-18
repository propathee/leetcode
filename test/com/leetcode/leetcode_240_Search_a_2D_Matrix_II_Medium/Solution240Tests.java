package com.leetcode.leetcode_240_Search_a_2D_Matrix_II_Medium;

import org.junit.Test;

import static com.leetcode.utils.TestCaseUtil.parseTwoDimensionalIntArray;
import static org.junit.Assert.*;

public class Solution240Tests {
    private Solution240 solution = Solution240.newSolution();

    @Test
    public void should_pass_1() {
        int[][] matrix = parseTwoDimensionalIntArray("[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]");
        assertTrue(solution.searchMatrix(matrix, 5));
    }

    @Test
    public void should_pass_2() {
        int[][] matrix = parseTwoDimensionalIntArray("[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]");
        assertFalse(solution.searchMatrix(matrix, 20));
    }
}