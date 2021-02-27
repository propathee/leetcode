package com.leetcode.leetcode_933_Number_of_Recent_Calls_Easy;

import static org.junit.Assert.*;

import com.leetcode.leetcode_933_Number_of_Recent_Calls_Easy.Solution933.RecentCounter;
import org.junit.Test;

public class Solution933Tests {
    private RecentCounter counter = Solution933.newCounter();

    @Test
    public void should_pass_1() {
        assertEquals(1, counter.ping(1));
        assertEquals(2, counter.ping(100));
        assertEquals(3, counter.ping(3001));
        assertEquals(3, counter.ping(3002));
    }
}