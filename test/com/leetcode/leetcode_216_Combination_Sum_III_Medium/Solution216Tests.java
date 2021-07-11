package com.leetcode.leetcode_216_Combination_Sum_III_Medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Solution216Tests {
    private Solution216 solution = Solution216.newSolution();

    @Test
    public void should_pass_1() {
        List<List<Integer>> actual = solution.combinationSum3(3, 7);
        List<List<Integer>> expect = parseCombination("[1,2,4]");
        assertPass(expect, actual);
    }

    @Test
    public void should_pass_2() {
        List<List<Integer>> actual = solution.combinationSum3(3, 9);
        List<List<Integer>> expect = parseCombination("[1,2,6],[1,3,5],[2,3,4]");
        assertPass(expect, actual);
    }

    @Test
    public void should_pass_3() {
        List<List<Integer>> actual = solution.combinationSum3(4, 1);
        List<List<Integer>> expect = new ArrayList<>();
        assertPass(expect, actual);
    }

    @Test
    public void should_pass_4() {
        List<List<Integer>> actual = solution.combinationSum3(3, 2);
        List<List<Integer>> expect = new ArrayList<>();
        assertPass(expect, actual);
    }

    @Test
    public void should_pass_5() {
        List<List<Integer>> actual = solution.combinationSum3(9, 45);
        List<List<Integer>> expect = parseCombination("[1,2,3,4,5,6,7,8,9]");
        assertPass(expect, actual);
    }

    private List<List<Integer>> parseCombination(String s) {
        s = s.substring(1, s.length() - 1).replace("[", "");
        String[] items = s.split("],");
        List<List<Integer>> res = new ArrayList<>();
        for (String item : items) {
            List<Integer> combination = new ArrayList<>();
            String[] templates = item.split(",");
            for (String temp : templates) {
                combination.add(Integer.parseInt(temp));
            }
            res.add(combination);
        }
        return res;
    }

    private void assertPass(List<List<Integer>> expect, List<List<Integer>> actual) {
        assertEquals(expect.size(), actual.size());
        for (int i = 0; i < expect.size(); i++) {
            Collections.sort(expect.get(i));
            Collections.sort(actual.get(i));
        }
        List<String> expect1 = expect.stream().map(List::toString).collect(Collectors.toList());
        List<String> actual1 = actual.stream().map(List::toString).collect(Collectors.toList());
        assertEquals(expect1, actual1);
    }
}