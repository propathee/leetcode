package com.leetcode.leetcode_893_Groups_of_Special_Equivalent_Strings_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution893Tests {
    private Solution893 solution = Solution893.newSolution();

    @Test
    public void should_pass_1() {
        String[] A = {"abcd","cdab","cbad","xyzz","zzxy","zzyx"};
        assertEquals(3, solution.numSpecialEquivGroups(A));
    }

    @Test
    public void should_pass_2() {
        String[] A = {"abc","acb","bac","bca","cab","cba"};
        assertEquals(3, solution.numSpecialEquivGroups(A));
    }
}