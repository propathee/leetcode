package com.leetcode.leetcode_448_Find_All_Numbers_Disappeared_in_an_Array_Easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class Solution448Tests {
    private Solution448 solution = Solution448.newSolution();

    @Test
    public void should_pass_1() {
        List<Integer> expect = Arrays.asList(5,6);
        int[] input = new int[] {4,3,2,7,8,2,3,1};
        assertPass(expect, solution.findDisappearedNumbers(input));
    }

    @Test
    public void should_pass_2() {
        List<Integer> expect = Arrays.asList();
        int[] input = new int[] {1};
        assertEquals(expect, solution.findDisappearedNumbers(input));
    }

    @Test
    public void should_pass_3() {
        List<Integer> expect = Arrays.asList();
        int[] input = new int[] {1, 2};
        assertEquals(expect, solution.findDisappearedNumbers(input));
    }

    private void assertPass(List<Integer> expect, List<Integer> actual) {
        Collections.sort(expect);
        Collections.sort(actual);
        assertEquals(expect, actual);
    }
}