package com.leetcode.leetcode_892_Surface_Area_of_3D_Shapes_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution892Tests {
    private Solution892 solution = Solution892.newSolution();

    @Test
    public void should_pass_1() {
        int[][] grid = makeGrid("[2]");
        assertEquals(10, solution.surfaceArea(grid));
    }

    @Test
    public void should_pass_2() {
        int[][] grid = makeGrid("[1,2],[3,4]");
        assertEquals(34, solution.surfaceArea(grid));
    }

    @Test
    public void should_pass_3() {
        int[][] grid = makeGrid("[1,0],[0,2]");
        assertEquals(16, solution.surfaceArea(grid));
    }

    @Test
    public void should_pass_4() {
        int[][] grid = makeGrid("[1,1,1],[1,0,1],[1,1,1]");
        assertEquals(32, solution.surfaceArea(grid));
    }

    @Test
    public void should_pass_5() {
        int[][] grid = makeGrid("[2,2,2],[2,1,2],[2,2,2]");
        assertEquals(46, solution.surfaceArea(grid));
    }

    private int[][] makeGrid(String s) {
        s = s.substring(1, s.length() - 1).replace("[", "");
        String[] rs = s.split("],");
        int[][] grid = new int[rs.length][rs.length];
        for (int i = 0; i < rs.length; i++) {
            String[] vs = rs[i].split(",");
            for (int j = 0; j < vs.length; j++) {
                grid[i][j] = Integer.parseInt(vs[j]);
            }
        }
        return grid;
    }
}