package com.leetcode.leetcode_551_Student_Attendance_Record_I_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution551Tests {
    private Solution551 solution = Solution551.newSolution();

    @Test
    public void should_pass_1() {
        assertTrue(solution.checkRecord("PPALLP"));
    }

    @Test
    public void should_pass_2() {
        assertFalse(solution.checkRecord("PPALLL"));
    }

    @Test
    public void should_pass_3() {
        assertTrue(solution.checkRecord("LALL"));
    }
}