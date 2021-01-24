package com.leetcode.leetcode_821_Shortest_Distance_to_a_Character_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution821Tests {
    private Solution821 solution = Solution821.newSolution();

    @Test
    public void should_pass_1() {
        int[] expect = {3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0};
        assertArrayEquals(expect, solution.shortestToChar("loveleetcode", 'e'));
    }
}