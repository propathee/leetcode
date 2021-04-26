package com.leetcode.leetcode_139_Word_Break_Medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Solution139Tests {
    private Solution139 solution = Solution139.newSolution();

    @Test
    public void should_pass_1() {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet","code");
        assertTrue(solution.wordBreak(s, wordDict));
    }

    @Test
    public void should_pass_2() {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("apple","pen");
        assertTrue(solution.wordBreak(s, wordDict));
    }

    @Test
    public void should_pass_3() {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");
        assertFalse(solution.wordBreak(s, wordDict));
    }
}