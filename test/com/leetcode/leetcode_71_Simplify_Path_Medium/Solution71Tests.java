package com.leetcode.leetcode_71_Simplify_Path_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution71Tests {
    private Solution71 solution = Solution71.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals("/home", solution.simplifyPath("/home/"));
    }

    @Test
    public void should_pass_2() {
        assertEquals("/", solution.simplifyPath("/../"));
    }

    @Test
    public void should_pass_3() {
        assertEquals("/home/foo", solution.simplifyPath("/home//foo/"));
    }

    @Test
    public void should_pass_4() {
        assertEquals("/c", solution.simplifyPath("/a/./b/../../c/"));
    }

    @Test
    public void should_pass_5() {
        assertEquals("/a/b/c", solution.simplifyPath("/a//b////c/d//././/.."));
    }
}