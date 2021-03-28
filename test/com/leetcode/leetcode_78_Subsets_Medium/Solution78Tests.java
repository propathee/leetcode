package com.leetcode.leetcode_78_Subsets_Medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Solution78Tests {
    private Solution78 solution = Solution78.newSolution();

    @Test
    public void should_pass_1() {
        String s = "[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]";
        List<List<Integer>> expect = parse(s);
        List<List<Integer>> actual = solution.subsets(new int[] {1,2,3});
        assertPass(expect, actual);
    }

    @Test
    public void should_pass_2() {
        String s = "[],[0]";
        List<List<Integer>> expect = parse(s);
        List<List<Integer>> actual = solution.subsets(new int[] {0});
        assertPass(expect, actual);
    }

    private List<List<Integer>> parse(String s) {
        s = s.substring(1, s.length() - 1).replace("[", "");
        return Arrays.stream(s.split("],"))
            .map(str -> toIntList(str))
            .collect(Collectors.toList());
    }

    private List<Integer> toIntList(String s) {
        if (s.isEmpty()) {
            return new ArrayList<>();
        } else {
            return Arrays.stream(s.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        }
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
            if (o1.size() != o2.size()) {
                return o1.size() - o2.size();
            }
            for (int i = 0; i < o1.size(); i++) {
                if (!o1.get(i).equals(o2.get(i))) {
                    return o1.get(i) - o2.get(i);
                }
            }
            return 0;
        });
    }
}