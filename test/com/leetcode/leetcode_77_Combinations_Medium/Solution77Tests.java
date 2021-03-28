package com.leetcode.leetcode_77_Combinations_Medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Solution77Tests {
    private Solution77 solution = Solution77.newSolution();

    @Test
    public void should_pass_1() {
        List<List<Integer>> expect = parse("2,4;3,4;2,3;1,2;1,3;1,4");
        List<List<Integer>> output = solution.combine(4, 2);
        assertPass(expect, output);
    }

    private List<List<Integer>> parse(String s) {
        return Arrays.stream(s.split(";"))
            .map(x -> x.split(","))
            .map(Arrays::asList)
            .map(list -> list.stream().map(Integer::parseInt).collect(Collectors.toList()))
            .collect(Collectors.toList());
    }

    private void assertPass(List<List<Integer>> expect, List<List<Integer>> actual) {
        sort(expect);
        sort(actual);
        assertEquals(expect, actual);
    }

    private void sort(List<List<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            Collections.sort(list.get(i));
        }
        list.sort((o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                if (!o1.get(i).equals(o2.get(i))) {
                    return o1.get(i) - o2.get(i);
                }
            }
            return 0;
        });
    }
}