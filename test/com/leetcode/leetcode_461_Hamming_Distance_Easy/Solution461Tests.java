package com.leetcode.leetcode_461_Hamming_Distance_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution461Tests {
    private Solution461 solution = Solution461.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals(2, solution.hammingDistance(1, 4));
    }
}