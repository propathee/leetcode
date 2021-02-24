package com.leetcode.leetcode_929_Unique_Email_Addresses_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution929Tests {
    private Solution929 solution = Solution929.newSolution();

    @Test
    public void should_pass_1() {
        String[] emails = {
            "test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com"
        };
        assertEquals(2, solution.numUniqueEmails(emails));
    }

    @Test
    public void should_pass_2() {
        String[] emails = {
            "test.email+alex@leetcode.com",
            "test.email@leetcode.com"
        };
        assertEquals(1, solution.numUniqueEmails(emails));
    }
}