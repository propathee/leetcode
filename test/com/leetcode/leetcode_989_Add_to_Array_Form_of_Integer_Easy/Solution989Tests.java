package com.leetcode.leetcode_989_Add_to_Array_Form_of_Integer_Easy;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class Solution989Tests {
    private Solution989 solution = Solution989.newSolution();

    @Test
    public void should_pass_1() {
        int[] A = {1,2,0,0};
        int K = 34;
        int[] expect = {1,2,3,4};
        assertPass(expect, solution.addToArrayForm(A, K));
    }

    @Test
    public void should_pass_2() {
        int[] A = {2,7,4};
        int K = 181;
        int[] expect = {4,5,5};
        assertPass(expect, solution.addToArrayForm(A, K));
    }

    @Test
    public void should_pass_3() {
        int[] A = {2,1,5};
        int K = 806;
        int[] expect = {1,0,2,1};
        assertPass(expect, solution.addToArrayForm(A, K));
    }

    @Test
    public void should_pass_4() {
        int[] A = {9,9,9,9,9,9,9,9,9,9};
        int K = 1;
        int[] expect = {1,0,0,0,0,0,0,0,0,0,0};
        assertPass(expect, solution.addToArrayForm(A, K));
    }

    private void assertPass(int[] expect, List<Integer> actual) {
        assertEquals(expect.length, actual.size());
        for (int i = 0; i < expect.length; i++) {
            assertEquals(expect[i], (long) actual.get(i));
        }
    }
}