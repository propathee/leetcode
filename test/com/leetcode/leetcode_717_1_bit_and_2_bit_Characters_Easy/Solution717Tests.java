package com.leetcode.leetcode_717_1_bit_and_2_bit_Characters_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution717Tests {
    private Solution717 solution = Solution717.newSolution();

    @Test
    public void should_pass_1() {
        int[] bits = {1,0,0};
        assertTrue(solution.isOneBitCharacter(bits));
    }

    @Test
    public void should_pass_2() {
        int[] bits = {1,1,1,0};
        assertFalse(solution.isOneBitCharacter(bits));
    }

    @Test
    public void should_pass_3() {
        int[] bits = {0};
        assertTrue(solution.isOneBitCharacter(bits));
    }

    @Test
    public void should_pass_4() {
        int[] bits = {1,0,1,0,0};
        assertTrue(solution.isOneBitCharacter(bits));
    }

    @Test
    public void should_pass_5() {
        int[] bits = {1,1,1,0,0};
        assertTrue(solution.isOneBitCharacter(bits));
    }
}