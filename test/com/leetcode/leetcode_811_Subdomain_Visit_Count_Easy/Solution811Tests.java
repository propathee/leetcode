package com.leetcode.leetcode_811_Subdomain_Visit_Count_Easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class Solution811Tests {
    private Solution811 solution = Solution811.newSolution();

    @Test
    public void should_pass_1() {
        String[] cpdomains = {"9001 discuss.leetcode.com"};
        List<String> expect = Arrays.asList("9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com");
        assertPass(expect, solution.subdomainVisits(cpdomains));
    }

    @Test
    public void should_pass_2() {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> expect = Arrays.asList("901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com");
        assertPass(expect, solution.subdomainVisits(cpdomains));
    }

    private void assertPass(List<String> expect, List<String> actual) {
        Collections.sort(expect);
        Collections.sort(actual);
        assertEquals(expect, actual);
    }
}