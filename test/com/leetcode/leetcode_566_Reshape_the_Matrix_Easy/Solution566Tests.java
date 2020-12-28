package com.leetcode.leetcode_566_Reshape_the_Matrix_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution566Tests {
    private Solution566 solution = Solution566.newSolution();

    @Test
    public void should_pass_1() {
        int[][] input = makeMatrix("1,2", "3,4");
        int[][] expect = makeMatrix("1,2,3,4");
        assertArrayEquals(expect, solution.matrixReshape(input, 1, 4));
    }

    @Test
    public void should_pass_2() {
        int[][] input = makeMatrix("1,2", "3,4");
        int[][] expect = makeMatrix("1,2", "3,4");
        assertArrayEquals(expect, solution.matrixReshape(input, 2, 4));
    }

    private int[][] makeMatrix(String... rows) {
        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] strColumns = rows[i].split(",");
            int[] columns = new int[strColumns.length];
            for (int j = 0; j < strColumns.length; j++) {
                columns[j] = Integer.parseInt(strColumns[j]);
            }
            matrix[i] = columns;
        }
        return matrix;
    }
}