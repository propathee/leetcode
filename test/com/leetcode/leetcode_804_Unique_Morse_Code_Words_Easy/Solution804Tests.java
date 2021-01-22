package com.leetcode.leetcode_804_Unique_Morse_Code_Words_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution804Tests {
    private Solution804 solution = Solution804.newSolution();

    @Test
    public void should_pass_1() {
        String[] words = {"gin", "zen", "gig", "msg"};
        assertEquals(2, solution.uniqueMorseRepresentations(words));
    }
}