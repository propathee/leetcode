package com.leetcode.leetcode_278_First_Bad_Version_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution278Tests {
    private Solution278 solution;

    @Test
    public void should_pass_1() {
        assertEquals(4, new Solution278(4).firstBadVersion(5));
    }

    @Test
    public void should_pass_2() {
        assertEquals(1, new Solution278(1).firstBadVersion(1));
    }

    @Test
    public void should_pass_3() {
        assertEquals(67, new Solution278(67).firstBadVersion(100));
    }

    @Test
    public void should_pass_4() {
        assertEquals(23, new Solution278(23).firstBadVersion(1024));
    }

    @Test
    public void should_pass_5() {
        assertEquals(138, new Solution278(138).firstBadVersion(679));
    }

    @Test
    public void should_pass_6() {
        assertEquals(1702766719, new Solution278(1702766719).firstBadVersion(2126753390));
    }

    @Test
    public void should_pass_7() {
        assertEquals(2, new Solution278(2).firstBadVersion(3));
    }
}