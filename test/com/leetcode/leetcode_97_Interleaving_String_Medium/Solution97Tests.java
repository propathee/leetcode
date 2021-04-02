package com.leetcode.leetcode_97_Interleaving_String_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution97Tests {
    private Solution97 solution = Solution97.newSolution();

    @Test
    public void should_pass_1() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        assertTrue(solution.isInterleave(s1, s2, s3));
    }

    @Test
    public void should_pass_2() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        assertFalse(solution.isInterleave(s1, s2, s3));
    }

    @Test
    public void should_pass_3() {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        assertTrue(solution.isInterleave(s1, s2, s3));
    }

    @Test
    public void should_pass_4() {
        String s1 = "aa";
        String s2 = "ab";
        String s3 = "aaba";
        assertTrue(solution.isInterleave(s1, s2, s3));
    }
}
