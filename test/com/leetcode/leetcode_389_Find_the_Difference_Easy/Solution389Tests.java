package com.leetcode.leetcode_389_Find_the_Difference_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution389Tests {
    private Solution389 solution = Solution389.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals('e', solution.findTheDifference("abcd", "abcde"));
    }

    @Test
    public void should_pass_2() {
        assertEquals('y', solution.findTheDifference("", "y"));
    }

    @Test
    public void should_pass_3() {
        assertEquals('a', solution.findTheDifference("a", "aa"));
    }

    @Test
    public void should_pass_4() {
        assertEquals('a', solution.findTheDifference("ae", "aea"));
    }

    @Test
    public void should_pass_5() {
        assertEquals('e', solution.findTheDifference("abcd", "dceba"));
    }
}