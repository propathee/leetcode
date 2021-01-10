package com.leetcode.leetcode_709_To_Lower_Case_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution709Tests {
    private Solution709 solution = Solution709.newSolution();

    @Test
    public void should_pass_1() {
        assertEquals("hello", solution.toLowerCase("Hello"));
    }

    @Test
    public void should_pass_2() {
        assertEquals("lovely", solution.toLowerCase("LOVELY"));
    }

    @Test
    public void should_pass_3() {
        assertEquals("az", solution.toLowerCase("AZ"));
    }

    @Test
    public void should_pass_4() {
        assertEquals("al&phabet", solution.toLowerCase("al&phaBET"));
    }

    @Test
    public void print() {
        System.out.println((int) 'A');
        System.out.println((int) 'a');
    }
}