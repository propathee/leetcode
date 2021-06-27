package com.leetcode.leetcode_200_Number_of_Islands_Med;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Solution200Tests {
    private Solution200 solution = Solution200.newSolution();

    @Test
    public void should_pass_1() {
        char[][] grid = makeGrid(Arrays.asList(
            "1,1,1,1,0",
            "1,1,0,1,0",
            "1,1,0,0,0",
            "0,0,0,0,0"
        ));
        assertEquals(1, solution.numIslands(grid));
    }

    @Test
    public void should_pass_2() {
        char[][] grid = makeGrid(Arrays.asList(
            "1,1,0,0,0",
            "1,1,0,0,0",
            "0,0,1,0,0",
            "0,0,0,1,1"
        ));
        assertEquals(3, solution.numIslands(grid));
    }

    @Test
    public void should_pass_3() {
        char[][] grid = makeGrid(Arrays.asList(
            "1,1,1",
            "0,1,0",
            "1,1,1"
        ));
        assertEquals(1, solution.numIslands(grid));
    }

    private char[][] makeGrid(List<String> rows) {
        char[][] grid = new char[rows.size()][];
        for (int i = 0; i < rows.size(); i++) {
            grid[i] = makeRow(rows.get(i));
        }
        return grid;
    }

    private char[] makeRow(String row) {
        String[] nodes = row.split(",");
        char[] res = new char[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            res[i] = nodes[i].charAt(0);
        }
        return res;
    }
}