package com.leetcode.leetcode_905_Sort_Array_By_Parity_Easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class Solution905Tests {
    private Solution905 solution = Solution905.newSolution();

    @Test
    public void should_pass_1() {
        int[] input = {3,1,2,4};
        int[] output = {2,4,1,3};
        assertPass(output, solution.sortArrayByParity(input));
    }

    private void assertPass(int[] expect, int[] actual) {
        List<Integer> expectEven = new ArrayList<>();
        List<Integer> expectOdd = new ArrayList<>();
        List<Integer> actualEven = new ArrayList<>();
        List<Integer> actualOdd = new ArrayList<>();
        int boundary = 0;
        for (; boundary < expect.length && expect[boundary] % 2 == 0; boundary++) {
        }
        for (int i = 0; i < boundary; i++) {
            expectEven.add(expect[i]);
            actualEven.add(actual[i]);
        }
        for (int i = boundary; i < expect.length; i++) {
            expectOdd.add(expect[i]);
            actualOdd.add(actual[i]);
        }
        Collections.sort(expectEven);
        Collections.sort(actualEven);
        assertEquals(expectEven, actualEven);

        Collections.sort(expectOdd);
        Collections.sort(actualOdd);
        assertEquals(expectOdd, actualOdd);
    }
}