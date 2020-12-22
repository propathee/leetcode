package com.leetcode.leetcode_504_Base_7_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution504Tests {
    private Solution504 solution = Solution504.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals("202", solution.convertToBase7(100));
    }

    @Test
    public void should_pass_2() {
        assertEquals("-10", solution.convertToBase7(-7));
    }

    @Test
    public void should_pass_3() {
        assertEquals("0", solution.convertToBase7(0));
    }

    @Test
    public void should_pass_4() {
        assertEquals("1", solution.convertToBase7(1));
    }

    @Test
    public void should_pass_5() {
        assertEquals("-1", solution.convertToBase7(-1));
    }
}