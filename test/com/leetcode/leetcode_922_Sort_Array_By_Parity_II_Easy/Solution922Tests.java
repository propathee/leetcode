package com.leetcode.leetcode_922_Sort_Array_By_Parity_II_Easy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Solution922Tests {
    private Solution922 solution = Solution922.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = {4,2,5,7};
        int[] output = {4,5,2,7};
        assertPass(output, solution.sortArrayByParityII(input));
    }

    @Test
    public void should_pass_2() {
        int[] input = {1,2};
        int[] output = {2,1};
        assertPass(output, solution.sortArrayByParityII(input));
    }

    @Test
    public void should_pass_3() {
        int[] input = {2,3};
        int[] output = {2,3};
        assertPass(output, solution.sortArrayByParityII(input));
    }

    @Test
    public void should_pass_4() {
        int[] input = {2,0,3,4,1,3};
        int[] output = {2,3,0,1,4,3};
        assertPass(output, solution.sortArrayByParityII(input));
    }

    private void assertPass(int[] expect, int[] actual) {
        assertEquals(expect.length, actual.length);
        assertEqualsAfterSorted(collectNumAtEvenIndex(expect), collectNumAtEvenIndex(actual));
        assertEqualsAfterSorted(collectNumAtOddIndex(expect), collectNumAtOddIndex(actual));
    }

    private void assertEqualsAfterSorted(int[] expect, int[] actual) {
        Arrays.sort(expect);
        Arrays.sort(actual);
        assertArrayEquals(expect, actual);
    }

    private int[] collectNumAtEvenIndex(int[] nums) {
        int[] res = new int[nums.length / 2];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i * 2];
        }
        return res;
    }

    private int[] collectNumAtOddIndex(int[] nums) {
        int[] res = new int[nums.length / 2];
        for (int i = 0; i < res.length; i++) {
            res[i] = nums[i * 2 + 1];
        }
        return res;
    }
}