package com.leetcode.leetcode_120_Triangle_Medium;

import org.junit.Test;

import java.util.List;

import static com.leetcode.utils.TestCaseUtil.parseTwoDimensionalIntList;
import static org.junit.Assert.*;

public class Solution120Tests {
    private Solution120 solution = Solution120.newSolution();

    @Test
    public void should_pass_1() {
        List<List<Integer>> triangle = parseTwoDimensionalIntList("[2],[3,4],[6,5,7],[4,1,8,3]");
        assertEquals(11, solution.minimumTotal(triangle));
    }

    @Test
    public void should_pass_2() {
        List<List<Integer>> triangle = parseTwoDimensionalIntList("[-10]");
        assertEquals(-10, solution.minimumTotal(triangle));
    }
}