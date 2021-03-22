package com.leetcode.leetcode_985_Sum_of_Even_Numbers_After_Queries_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution985Tests {
    private Solution985 solution = Solution985.newSolution();

    @Test
    public void should_pass_1() {
        int[] array = {1,2,3,4};
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        int[] output = {8,6,2,4};
        assertArrayEquals(output, solution.sumEvenAfterQueries(array, queries));
    }
}