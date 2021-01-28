package com.leetcode.leetcode_832_Flipping_an_Image_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution832Tests {
    private Solution832 solution = Solution832.newSolution();

    @Test
    public void should_pass_1() {
        int[][] matrix = makeMatrix("[1,1,0],[1,0,1],[0,0,0]");
        int[][] expect = makeMatrix("[1,0,0],[0,1,0],[1,1,1]");
        assertArrayEquals(expect, solution.flipAndInvertImage(matrix));
    }

    @Test
    public void should_pass_2() {
        int[][] matrix = makeMatrix("[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]");
        int[][] expect = makeMatrix("[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]");
        assertArrayEquals(expect, solution.flipAndInvertImage(matrix));
    }

    private int[][] makeMatrix(String s) {
        s = s.substring(1, s.length() - 1).replace("[", "");
        String[] rs = s.split("],");
        int[][] matrix = new int[rs.length][];
        for (int i = 0; i < rs.length; i++) {
            String r = rs[i];
            String[] vs = r.split(",");
            matrix[i] = new int[vs.length];
            for (int j = 0; j < vs.length; j++) {
                matrix[i][j] = Integer.parseInt(vs[j]);
            }
        }
        return matrix;
    }
}