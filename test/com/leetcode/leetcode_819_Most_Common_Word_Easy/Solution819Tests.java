package com.leetcode.leetcode_819_Most_Common_Word_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution819Tests {
    private Solution819 solution = Solution819.newSolution();

    @Test
    public void should_pass_1() {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        assertEquals("ball", solution.mostCommonWord(paragraph, banned));
    }

    @Test
    public void should_pass_2() {
        String paragraph = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};
        assertEquals("b", solution.mostCommonWord(paragraph, banned));
    }

    @Test
    public void should_pass_3() {
        String paragraph = "Bob";
        String[] banned = {};
        assertEquals("bob", solution.mostCommonWord(paragraph, banned));
    }
}