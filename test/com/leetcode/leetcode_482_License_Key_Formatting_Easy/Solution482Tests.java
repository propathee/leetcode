package com.leetcode.leetcode_482_License_Key_Formatting_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution482Tests {
    private Solution482 solution = Solution482.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals("5F3Z-2E9W", solution.licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }

    @Test
    public void should_pass_2() {
        assertEquals("2-5G-3J", solution.licenseKeyFormatting("2-5g-3-J", 2));
    }

    @Test
    public void should_pass_3() {
        assertEquals("AA-AA", solution.licenseKeyFormatting("--a-a-a-a--", 2));
    }

    @Test
    public void should_pass_4() {
        assertEquals("", solution.licenseKeyFormatting("---", 3));
    }
}