package com.leetcode.leetcode_598_Range_Addition_II_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution598Tests {
    private Solution598 solution = Solution598.newSolution();

    @Test
    public void should_pass_1() {
        int[][] ops = makeOps("[2,2],[3,3]");
        assertEquals(4, solution.maxCount(3, 3, ops));
    }

    @Test
    public void should_pass_2() {
        int[][] ops = makeOps("[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]");
        assertEquals(4, solution.maxCount(3, 3, ops));
    }

    @Test
    public void should_pass_3() {
        int[][] ops = new int[0][0];
        assertEquals(9, solution.maxCount(3, 3, ops));
    }

    private int[][] makeOps(String ops) {
        String[] rows = ops.split("],");
        int[][] res = new int[rows.length][2];
        for (int i = 0; i < rows.length; i++) {
            String row = rows[i].replace("[", "").replace("]", "");
            res[i][0] = Integer.parseInt(row.split(",")[0]);
            res[i][1] = Integer.parseInt(row.split(",")[1]);
        }
        return res;
    }
}