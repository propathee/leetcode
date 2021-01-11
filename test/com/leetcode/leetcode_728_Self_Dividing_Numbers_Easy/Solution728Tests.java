package com.leetcode.leetcode_728_Self_Dividing_Numbers_Easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Solution728Tests {
    private Solution728 solution = Solution728.newSolution();

    @Test
    public void should_pass_1() {
        List<Integer> expect = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22);
        assertEquals(expect, solution.selfDividingNumbers(1, 22));
    }
}