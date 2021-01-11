package com.leetcode.leetcode_733_Flood_Fill_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution733Tests {
    private Solution733 solution = Solution733.newSolution();

    @Test
    public void should_pass_1() {
        int[][] image = makeMatrix("[1,1,1],[1,1,0],[1,0,1]");
        int[][] expect = makeMatrix("[2,2,2],[2,2,0],[2,0,1]");
        assertArrayEquals(expect, solution.floodFill(image, 1, 1, 2));
    }

    @Test
    public void should_pass_2() {
        int[][] image = makeMatrix("[0,0,0],[0,1,1]");
        int[][] expect = makeMatrix("[0,0,0],[0,1,1]");
        assertArrayEquals(expect, solution.floodFill(image, 1, 1, 1));
    }

    private int[][] makeMatrix(String s) {
        s = s.substring(0, s.length() - 1).replace("[", "");
        String[] values = s.split("],");
        int[][] matrix = new int[values.length][];
        for (int i = 0; i < values.length; i++) {
            String[] nums = values[i].split(",");
            int[] row = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                row[j] = Integer.parseInt(nums[j]);
            }
            matrix[i] = row;
        }
        return matrix;
    }
}