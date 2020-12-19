package com.leetcode.leetcode_463_Island_Perimeter_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution463Tests {
    private Solution463 solution = Solution463.newSolution();

    @Test
    public void should_pass_1() {
        int[][] grid = makeGrid("0,1,0,0","1,1,1,0","0,1,0,0","1,1,0,0");
        assertEquals(16, solution.islandPerimeter(grid));
    }

    @Test
    public void should_pass_2() {
        int[][] grid = makeGrid("1");
        assertEquals(4, solution.islandPerimeter(grid));
    }

    @Test
    public void should_pass_3() {
        int[][] grid = makeGrid("1,0");
        assertEquals(4, solution.islandPerimeter(grid));
    }

    private int[][] makeGrid(String... rows) {
        int[][] grid = new int[rows.length][];
        for (int x = 0; x < rows.length; x++) {
            String row0 = rows[x];
            String[] row1 = row0.split(",");
            int[] row2 = new int[row1.length];
            for (int y = 0; y < row1.length; y++) {
                row2[y] = Integer.parseInt(row1[y]);
            }
            grid[x] = row2;
        }
        return grid;
    }
}