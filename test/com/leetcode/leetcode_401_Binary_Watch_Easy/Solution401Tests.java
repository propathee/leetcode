package com.leetcode.leetcode_401_Binary_Watch_Easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class Solution401Tests {
    private Solution401 solution = Solution401.newSolution();

    @Test
    public void should_pass_0() {
        List<String> expect = Arrays.asList("0:00");
        assertPass(expect, solution.readBinaryWatch(0));
    }

    @Test
    public void should_pass_1() {
        List<String> expect = Arrays.asList("1:00", "2:00", "4:00", "8:00",
            "0:01", "0:02", "0:04", "0:08", "0:16", "0:32");
        assertPass(expect, solution.readBinaryWatch(1));
    }

    private void assertPass(List<String> expect, List<String> actual) {
        assertEquals(expect.size(), actual.size());
        Collections.sort(expect);
        Collections.sort(actual);
        assertEquals(expect, actual);
    }
}