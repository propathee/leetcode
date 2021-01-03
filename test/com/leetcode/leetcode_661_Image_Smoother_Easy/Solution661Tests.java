package com.leetcode.leetcode_661_Image_Smoother_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution661Tests {
    private Solution661 solution = Solution661.newSolution();

    @Test
    public void should_pass_1() {
        int[][] input = makeMatrix("1,1,1", "1,0,1", "1,1,1");
        int[][] expect = makeMatrix("0,0,0", "0,0,0", "0,0,0");
        assertArrayEquals(expect, solution.imageSmoother(input));
    }

    @Test
    public void should_pass_2() {
        int[][] input = makeMatrix2("[2,3,4],[5,6,7],[8,9,10],[11,12,13],[14,15,16]");
        int[][] expect = makeMatrix2("[4,4,5],[5,6,6],[8,9,9],[11,12,12],[13,13,14]");
        assertArrayEquals(expect, solution.imageSmoother(input));
    }

    @Test
    public void should_pass_3() {
        int[][] input = makeMatrix2("[1]");
        int[][] expect = makeMatrix2("[1]");
        assertArrayEquals(expect, solution.imageSmoother(input));
    }

    private int[][] makeMatrix(String... rows) {
        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] columns = rows[i].split(",");
            matrix[i] = new int[columns.length];
            for (int j = 0; j < columns.length; j++) {
                matrix[i][j] = Integer.parseInt(columns[j]);
            }
        }
        return matrix;
    }

    private int[][] makeMatrix2(String v) {
        String[] rows = v.substring(1, v.length() - 1).replace("[", "").split("],");
        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] columns = rows[i].split(",");
            matrix[i] = new int[columns.length];
            for (int j = 0; j < columns.length; j++) {
                matrix[i][j] = Integer.parseInt(columns[j]);
            }
        }
        return matrix;
    }
}