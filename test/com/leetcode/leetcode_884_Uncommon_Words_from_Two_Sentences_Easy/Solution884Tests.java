package com.leetcode.leetcode_884_Uncommon_Words_from_Two_Sentences_Easy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution884Tests {
    private Solution884 solution = Solution884.newSolution();

    @Test
    public void should_pass_1() {
        String a = "this apple is sweet";
        String b = "this apple is sour";
        String[] words = {"sweet","sour"};
        assertPass(words, solution.uncommonFromSentences(a, b));
    }

    @Test
    public void should_pass_2() {
        String a = "apple apple";
        String b = "banana";
        String[] words = {"banana"};
        assertPass(words, solution.uncommonFromSentences(a, b));
    }

    private void assertPass(String[] expect, String[] actual) {
        Arrays.sort(expect);
        Arrays.sort(actual);
        assertArrayEquals(expect, actual);
    }
}
