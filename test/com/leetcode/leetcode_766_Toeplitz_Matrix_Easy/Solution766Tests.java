package com.leetcode.leetcode_766_Toeplitz_Matrix_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution766Tests {
    private Solution766 solution = Solution766.newSolution();

    @Test
    public void should_pass_1() {
        int[][] matrix = makeMatrix("[1,2,3,4],[5,1,2,3],[9,5,1,2]");
        assertTrue(solution.isToeplitzMatrix(matrix));
    }

    @Test
    public void should_pass_2() {
        int[][] matrix = makeMatrix("[1,2],[2,2]");
        assertFalse(solution.isToeplitzMatrix(matrix));
    }

    private int[][] makeMatrix(String s) {
        s = s.substring(1, s.length() - 1).replace("[", "");
        String[] rows = s.split("],");
        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] values = rows[i].split(",");
            int[] row = new int[values.length];
            for (int j = 0; j < values.length; j++) {
                row[j] = Integer.parseInt(values[j]);
            }
            matrix[i] = row;
        }
        return matrix;
    }
}