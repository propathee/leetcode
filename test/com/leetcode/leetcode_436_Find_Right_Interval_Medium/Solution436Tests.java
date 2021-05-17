package com.leetcode.leetcode_436_Find_Right_Interval_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution436Tests {
    private Solution436 solution = Solution436.newSolution();

    @Test
    public void should_pass_1() {
        int[][] intervals = parseIntervals("[1,2]");
        int[] expect = {-1};
        assertArrayEquals(expect, solution.findRightInterval(intervals));
    }

    @Test
    public void should_pass_2() {
        int[][] intervals = parseIntervals("[3,4],[2,3],[1,2]");
        int[] expect = {-1,0,1};
        assertArrayEquals(expect, solution.findRightInterval(intervals));
    }

    @Test
    public void should_pass_3() {
        int[][] intervals = parseIntervals("[1,4],[2,3],[3,4]");
        int[] expect = {-1,2,-1};
        assertArrayEquals(expect, solution.findRightInterval(intervals));
    }

    @Test
    public void should_pass_4() {
        int[][] intervals = parseIntervals("[1,1],[2,3]");
        int[] expect = {1,-1};
        assertArrayEquals(expect, solution.findRightInterval(intervals));
    }

    @Test
    public void should_pass_5() {
        int[][] intervals = parseIntervals("[0,1],[1,1]");
        int[] expect = {1,-1};
        assertArrayEquals(expect, solution.findRightInterval(intervals));
    }

    @Test
    public void should_pass_6() {
        int[][] intervals = parseIntervals("[1,1],[0,1]");
        int[] expect = {-1,1};
        assertArrayEquals(expect, solution.findRightInterval(intervals));
    }

    private int[][] parseIntervals(String s) {
        s = s.substring(1, s.length() - 1).replace("[", "");
        String[] sArray = s.split("],");
        int[][] res = new int[sArray.length][];
        for (int i = 0; i < sArray.length; i++) {
            res[i] = parseInterval(sArray[i]);
        }
        return res;
    }

    private int[] parseInterval(String s) {
        String[] sArray = s.split(",");
        int[] res = new int[sArray.length];
        for (int i = 0; i < sArray.length; i++) {
            res[i] = Integer.parseInt(sArray[i]);
        }
        return res;
    }
}