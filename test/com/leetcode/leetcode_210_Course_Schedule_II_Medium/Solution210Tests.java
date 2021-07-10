package com.leetcode.leetcode_210_Course_Schedule_II_Medium;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class Solution210Tests {
    private Solution210 solution = Solution210.newSolution();

    @Test
    public void should_pass_1() {
        int[][] requisites = parsePrerequisites("[1,0]");
        int[] output = solution.findOrder(2, requisites);
        int[][] possibleOutputs = parsePossibleOutputs("[0,1]");
        assertPass(possibleOutputs, output);
    }

    @Test
    public void should_pass_2() {
        int[][] requisites = parsePrerequisites("[1,0],[2,0],[3,1],[3,2]");
        int[] output = solution.findOrder(4, requisites);
        int[][] possibleOutputs = parsePossibleOutputs("[0,1,2,3],[0,2,1,3]");
        assertPass(possibleOutputs, output);
    }

    @Test
    public void should_pass_3() {
        int[][] requisites = parsePrerequisites("[]");
        int[] output = solution.findOrder(1, requisites);
        int[][] possibleOutputs = parsePossibleOutputs("[0]");
        assertPass(possibleOutputs, output);
    }

    private int[][] parsePrerequisites(String s) {
        s = s.substring(0, s.length() - 1).replace("[", "");
        if (s.isEmpty()) {
            return new int[0][];
        }
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

    private int[][] parsePossibleOutputs(String s) {
        s = s.substring(0, s.length() - 1).replace("[", "");
        String[] courses = s.split("],");
        int[][] res = new int[courses.length][];
        for (int i = 0; i < courses.length; i++) {
            res[i] = parseCourses(courses[i]);
        }
        return res;
    }

    private int[] parseCourses(String s) {
        String[] courses = s.split(",");
        int[] res = new int[courses.length];
        for (int i = 0; i < courses.length; i++) {
            res[i] = Integer.parseInt(courses[i]);
        }
        return res;
    }

    private void assertPass(int[][] allAns, int[] ans) {
        StringBuilder sb = new StringBuilder();
        for (int[] expectAns : allAns) {
            sb.append(Arrays.toString(expectAns));
        }
        System.out.println(sb.toString());
        System.out.println(Arrays.toString(ans));
        assertTrue(sb.toString().contains(Arrays.toString(ans)));
    }
}