package com.leetcode.leetcode_412_Fizz_Buzz_Easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Solution412Tests {
    private Solution412 solution = Solution412.newSolution();

    @Test
    public void should_pass_1() {
        List<String> expect = Arrays.asList(
            "1", "2", "Fizz", "4", "Buzz",
            "Fizz", "7", "8", "Fizz", "Buzz",
            "11", "Fizz", "13", "14", "FizzBuzz");
        assertEquals(expect, solution.fizzBuzz(15));
    }

    @Test
    public void should_pass_2() {
        assertEquals(new ArrayList<>(), solution.fizzBuzz(0));
    }
}