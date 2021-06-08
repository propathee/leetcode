package com.leetcode.leetcode_187_Repeated_DNA_Sequences_Medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class Solution187Tests {
    private Solution187 solution = Solution187.newSolution();

    @Test
    public void should_pass_1() {
        String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> output = Arrays.asList("AAAAACCCCC","CCCCCAAAAA");
        assertPass(output, solution.findRepeatedDnaSequences(input));
    }

    @Test
    public void should_pass_2() {
        String input = "AAAAAAAAAAAAA";
        List<String> output = Arrays.asList("AAAAAAAAAA");
        assertPass(output, solution.findRepeatedDnaSequences(input));
    }

    @Test
    public void should_pass_3() {
        String input = "AAAAAAAAAAA";
        List<String> output = Arrays.asList("AAAAAAAAAA");
        assertPass(output, solution.findRepeatedDnaSequences(input));
    }

    @Test
    public void should_pass_4() {
        String input = "A";
        List<String> output = new ArrayList<>();
        assertPass(output, solution.findRepeatedDnaSequences(input));
    }

    private void assertPass(List<String> expect, List<String> actual) {
        expect = new ArrayList<>(expect);
        Collections.sort(expect);
        Collections.sort(actual);
        assertEquals(expect, actual);
    }
}