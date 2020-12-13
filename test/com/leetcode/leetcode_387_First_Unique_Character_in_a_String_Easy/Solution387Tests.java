package com.leetcode.leetcode_387_First_Unique_Character_in_a_String_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution387Tests {
    private Solution387 solution = Solution387.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals(0, solution.firstUniqChar("leetcode"));
    }

    @Test
    public void should_pass_2() {
        assertEquals(2, solution.firstUniqChar("loveleetcode"));
    }

    @Test
    public void should_pass_3() {
        assertEquals(-1, solution.firstUniqChar("aa"));
    }

    @Test
    public void should_pass_4() {
        assertEquals(0, solution.firstUniqChar("a"));
    }

    @Test
    public void should_pass_5() {
        assertEquals(-1, solution.firstUniqChar(""));
    }
}