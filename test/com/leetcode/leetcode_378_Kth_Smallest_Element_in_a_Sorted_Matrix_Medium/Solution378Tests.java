package com.leetcode.leetcode_378_Kth_Smallest_Element_in_a_Sorted_Matrix_Medium;

import org.junit.Test;

import static com.leetcode.utils.TestCaseUtil.parseTwoDimensionalIntArray;
import static org.junit.Assert.*;

public class Solution378Tests {
    private Solution378 solution = Solution378.newSolution();

    @Test
    public void should_pass_1() {
        int[][] matrix = parseTwoDimensionalIntArray("[1,5,9],[10,11,13],[12,13,15]");
        assertEquals(13, solution.kthSmallest(matrix, 8));
    }

    @Test
    public void should_pass_2() {
        int[][] matrix = parseTwoDimensionalIntArray("[-5]");
        assertEquals(-5, solution.kthSmallest(matrix, 1));
    }
}