package com.leetcode.leetcode_96_unique_binary_search_trees_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution96Tests {
    private Solution96 solution = Solution96.newSolution();
    
    @Test
    public void should_pass_1() {
        assertEquals(5, solution.numTrees(3));
    }

    @Test
    public void should_pass_2() {
        assertEquals(1, solution.numTrees(1));
    }
}