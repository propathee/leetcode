package com.leetcode.leetcode_207_Course_Schedule_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution207Tests {
    private Solution207 solution = Solution207.newSolution();

    @Test
    public void should_pass_1() {
        int[][] prerequisites = parsePrerequisites("[1,0]");
        assertTrue(solution.canFinish(2, prerequisites));
    }

    @Test
    public void should_pass_2() {
        int[][] prerequisites = parsePrerequisites("[1,0],[0,1]");
        assertFalse(solution.canFinish(2, prerequisites));
    }

    private int[][] parsePrerequisites(String s) {
        s = s.substring(0, s.length() - 1).replace("[", "");
        String[] edges = s.split("],");
        int[][] res = new int[edges.length][];
        for (int i = 0; i < edges.length; i++) {
            res[i] = parseEdge(edges[i]);
        }
        return res;
    }

    private int[] parseEdge(String s) {
        int[] res = new int[2];
        String[] nodes = s.split(",");
        res[0] = Integer.parseInt(nodes[0]);
        res[1] = Integer.parseInt(nodes[1]);
        return res;
    }
}