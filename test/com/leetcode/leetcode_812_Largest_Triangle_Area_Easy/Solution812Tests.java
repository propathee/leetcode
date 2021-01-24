package com.leetcode.leetcode_812_Largest_Triangle_Area_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution812Tests {
    private Solution812 solution = Solution812.newSolution();

    @Test
    public void should_pass_1() {
        int[][] points = makePoints("[0,0],[0,1],[1,0],[0,2],[2,0]");
        assertEquals(2, solution.largestTriangleArea(points), 1e-6);
    }

    @Test
    public void should_pass_2() {
        int[][] points = makePoints("[10,7],[0,4],[5,7]");
        assertEquals(7.5, solution.largestTriangleArea(points), 1e-6);
    }

    @Test
    public void should_pass_3() {
        int[][] points = makePoints("[2,5],[7,7],[10,8],[10,10],[1,1]");
        assertEquals(14.5, solution.largestTriangleArea(points), 1e-6);
    }

    private int[][] makePoints(String s) {
        String[] values = s.substring(1, s.length() - 1).replace("[", "").split("],");
        int[][] points = new int[values.length][];
        for (int i = 0; i < values.length; i++) {
            String[] locations = values[i].split(",");
            int[] point = new int[2];
            point[0] = Integer.parseInt(locations[0]);
            point[1] = Integer.parseInt(locations[1]);
            points[i] = point;
        }
        return points;
    }
}