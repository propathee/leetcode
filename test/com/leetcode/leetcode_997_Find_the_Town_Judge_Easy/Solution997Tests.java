package com.leetcode.leetcode_997_Find_the_Town_Judge_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution997Tests {
    private Solution997 solution = Solution997.newSolution();

    @Test
    public void should_pass_1() {
        int[][] trusts = {{1,2}};
        assertEquals(2, solution.findJudge(2, trusts));
    }

    @Test
    public void should_pass_2() {
        int[][] trusts = {{1,3},{2,3}};
        assertEquals(3, solution.findJudge(3, trusts));
    }

    @Test
    public void should_pass_3() {
        int[][] trusts = {{1,3},{2,3},{3,1}};
        assertEquals(-1, solution.findJudge(3, trusts));
    }

    @Test
    public void should_pass_4() {
        int[][] trusts = {{1,2},{2,3}};
        assertEquals(-1, solution.findJudge(3, trusts));
    }

    @Test
    public void should_pass_5() {
        int[][] trusts = {{1,3},{1,4},{2,3},{2,4},{4,3}};
        assertEquals(3, solution.findJudge(4, trusts));
    }

    @Test
    public void should_pass_6() {
        int[][] trusts = {};
        assertEquals(1, solution.findJudge(1, trusts));
    }
}