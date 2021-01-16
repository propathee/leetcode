package com.leetcode.leetcode_771_Jewels_and_Stones_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution771Tests {
    private Solution771 solution = Solution771.newSolution();

    @Test
    public void should_pass_1() {
        String jewels = "aA";
        String stones = "aAAbbbb";
        assertEquals(3, solution.numJewelsInStones(jewels, stones));
    }

    @Test
    public void should_pass_2() {
        String jewels = "z";
        String stones = "ZZ";
        assertEquals(0, solution.numJewelsInStones(jewels, stones));
    }
}