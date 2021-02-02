package com.leetcode.leetcode_867_Transpose_Matrix_Easy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Solution867Tests {
    private Solution867 solution = Solution867.newSolution();

    @Test
    public void should_pass_1() {
        int[][] input = makeMatrix("[1,2,3],[4,5,6],[7,8,9]");
        int[][] output = makeMatrix("[1,4,7],[2,5,8],[3,6,9]");
        assertArrayEquals(output, solution.transpose(input));
    }

    @Test
    public void should_pass_2() {
        int[][] input = makeMatrix("[1,2,3],[4,5,6]");
        int[][] output = makeMatrix("[1,4],[2,5],[3,6]");
        assertArrayEquals(output, solution.transpose(input));
    }

    private int[][] makeMatrix(String s) {
        s = s.substring(1, s.length() - 1).replace("[", "");
        String[] rs = s.split("],");
        int[][] matrix = new int[rs.length][];
        for (int i = 0; i < rs.length; i++) {
            String[] vs = rs[i].split(",");
            matrix[i] = new int[vs.length];
            for (int j = 0; j < vs.length; j++) {
                matrix[i][j] = Integer.parseInt(vs[j]);
            }
        }
        return matrix;
    }
}