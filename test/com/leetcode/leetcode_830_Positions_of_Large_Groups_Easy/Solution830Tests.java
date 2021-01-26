package com.leetcode.leetcode_830_Positions_of_Large_Groups_Easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Solution830Tests {
    private Solution830 solution = Solution830.newSolution();

    @Test
    public void should_pass_1() {
        List<List<Integer>> expect = makeGroups("[3,6]");
        assertPass(expect, solution.largeGroupPositions("abbxxxxzzy"));
    }

    @Test
    public void should_pass_2() {
        assertPass(new ArrayList<>(), solution.largeGroupPositions("abc"));
    }

    @Test
    public void should_pass_3() {
        List<List<Integer>> expect = makeGroups("[3,5],[6,9],[12,14]");
        assertPass(expect, solution.largeGroupPositions("abcdddeeeeaabbbcd"));
    }

    @Test
    public void should_pass_4() {
        assertPass(new ArrayList<>(), solution.largeGroupPositions("aba"));
    }

    private List<List<Integer>> makeGroups(String s) {
        List<List<Integer>> res = new ArrayList<>();
        s = s.substring(1, s.length() - 1).replace("[", "");
        for (String ss : s.split("],")) {
            String[] pair = ss.split(",");
            int l = Integer.parseInt(pair[0]);
            int r = Integer.parseInt(pair[1]);
            res.add(Arrays.asList(l, r));
        }
        return res;
    }

    private void assertPass(List<List<Integer>> expect, List<List<Integer>> actual) {
        assertEquals(expect.size(), actual.size());
        for (int i = 0; i < expect.size(); i++) {
            assertEquals(expect.get(i), actual.get(i));
        }
    }
}