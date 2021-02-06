package com.leetcode.leetcode_883_Projection_Area_of_3D_Shapes_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution833Tests {
    private Solution833 solution = Solution833.newSolution();

    @Test
    public void should_pass_1() {
        int[][] grid = makeGrid("[1,2],[3,4]");
        assertEquals(17, solution.projectionArea(grid));
    }

    @Test
    public void should_pass_2() {
        int[][] grid = {{2}};
        assertEquals(5, solution.projectionArea(grid));
    }

    @Test
    public void should_pass_3() {
        int[][] grid = makeGrid("[1,0],[0,2]");
        assertEquals(8, solution.projectionArea(grid));
    }

    @Test
    public void should_pass_4() {
        int[][] grid = makeGrid("[1,1,1],[1,0,1],[1,1,1]");
        assertEquals(14, solution.projectionArea(grid));
    }

    @Test
    public void should_pass_5() {
        int[][] grid = makeGrid("[2,2,2],[2,1,2],[2,2,2]");
        assertEquals(21, solution.projectionArea(grid));
    }

    private int[][] makeGrid(String s) {
        s = s.substring(1, s.length() - 1).replace("[", "");
        String[] rs = s.split("],");
        int[][] grid = new int[rs.length][];
        for (int i = 0; i < rs.length; i++) {
            String[] vs = rs[i].split(",");
            grid[i] = new int[vs.length];
            for (int j = 0; j < vs.length; j++) {
                grid[i][j] = Integer.parseInt(vs[j]);
            }
        }
        return grid;
    }
}