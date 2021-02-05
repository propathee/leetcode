package com.leetcode.leetcode_874_Walking_Robot_Simulation_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution874Tests {
    private Solution874 solution = Solution874.newSolution();

    @Test
    public void should_pass_1() {
        int[] commands = {4,-1,3};
        int[][] obstacles = {};
        assertEquals(25, solution.robotSim(commands, obstacles));
    }

    @Test
    public void should_pass_2() {
        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};
        assertEquals(65, solution.robotSim(commands, obstacles));
    }

    @Test
    public void should_pass_3() {
        int[] commands = {-2,-1,-2,3,7};
        int[][] obstacles = makeObstacles("[1,-3],[2,-3],[4,0],[-2,5],[-5,2],[0,0],[4,-4],[-2,-5],[-1,-2],[0,2]");
        assertEquals(100, solution.robotSim(commands, obstacles));
    }

    private int[][] makeObstacles(String s) {
        String[] points = s.substring(1, s.length() - 1).replace("[", "").split("],");
        int[][] obstacles = new int[points.length][2];
        for (int i = 0; i < points.length; i++) {
            String[] point = points[i].split(",");
            obstacles[i][0] = Integer.parseInt(point[0]);
            obstacles[i][1] = Integer.parseInt(point[1]);
        }
        return obstacles;
    }
}