package com.leetcode.leetcode_90_Subsets_II_Medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Solution90Tests {
    private Solution90 solution = Solution90.newSolution();

    @Test
    public void should_pass_1() {
        int[] nums = {1,2,2};
        String output = "[],[1],[1,2],[1,2,2],[2],[2,2]";
        List<List<Integer>> expect = parse(output);
        assertPass(expect, solution.subsetsWithDup(nums));
    }

    @Test
    public void should_pass_2() {
        int[] nums = {0};
        String output = "[],[0]";
        List<List<Integer>> expect = parse(output);
        assertPass(expect, solution.subsetsWithDup(nums));
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