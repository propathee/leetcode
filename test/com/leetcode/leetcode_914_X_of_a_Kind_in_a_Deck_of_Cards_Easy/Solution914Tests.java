package com.leetcode.leetcode_914_X_of_a_Kind_in_a_Deck_of_Cards_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution914Tests {
    private Solution914 solution = Solution914.newSolution();

    @Test
    public void should_pass_1() {
        int[] cards = {1,2,3,4,4,3,2,1};
        assertTrue(solution.hasGroupsSizeX(cards));
    }

    @Test
    public void should_pass_2() {
        int[] cards = {1,1,1,2,2,2,3,3};
        assertFalse(solution.hasGroupsSizeX(cards));
    }

    @Test
    public void should_pass_3() {
        int[] cards = {1};
        assertFalse(solution.hasGroupsSizeX(cards));
    }

    @Test
    public void should_pass_4() {
        int[] cards = {1,1};
        assertTrue(solution.hasGroupsSizeX(cards));
    }

    @Test
    public void should_pass_5() {
        int[] cards = {1,1,2,2,2,2};
        assertTrue(solution.hasGroupsSizeX(cards));
    }
}