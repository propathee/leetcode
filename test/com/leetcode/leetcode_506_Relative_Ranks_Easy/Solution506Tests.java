package com.leetcode.leetcode_506_Relative_Ranks_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution506Tests {
    private Solution506 solution = Solution506.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = new int[] {5,4,3,2,1};
        String[] expect = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"};
        assertArrayEquals(expect, solution.findRelativeRanks(input));
    }

    @Test
    public void should_pass_2() {
        int[] input = new int[] {1};
        String[] expect = new String[] {"Gold Medal"};
        assertArrayEquals(expect, solution.findRelativeRanks(input));
    }

    @Test
    public void should_pass_3() {
        int[] input = new int[] {-1, 0};
        String[] expect = new String[] {"Silver Medal", "Gold Medal"};
        assertArrayEquals(expect, solution.findRelativeRanks(input));
    }

    @Test
    public void should_pass_4() {
        int[] input = new int[] {-1, 0, 1};
        String[] expect = new String[] {"Bronze Medal", "Silver Medal", "Gold Medal"};
        assertArrayEquals(expect, solution.findRelativeRanks(input));
    }
}