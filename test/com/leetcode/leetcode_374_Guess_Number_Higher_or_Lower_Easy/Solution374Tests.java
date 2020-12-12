package com.leetcode.leetcode_374_Guess_Number_Higher_or_Lower_Easy;

import org.junit.Test;

import static com.leetcode.leetcode_374_Guess_Number_Higher_or_Lower_Easy.Solution374.newSolution;
import static org.junit.Assert.*;

public class Solution374Tests {
    @Test
    public void should_pass_1() {
        assertEquals(6, newSolution(6).guessNumber(10));
    }

    @Test
    public void should_pass_2() {
        assertEquals(1, newSolution(1).guessNumber(1));
    }

    @Test
    public void should_pass_3() {
        assertEquals(1, newSolution(1).guessNumber(2));
    }

    @Test
    public void should_pass_4() {
        assertEquals(2, newSolution(2).guessNumber(2));
    }

    @Test
    public void should_pass_5() {
        assertEquals(1, newSolution(1).guessNumber(3));
    }

    @Test
    public void should_pass_6() {
        assertEquals(2, newSolution(2).guessNumber(3));
    }

    @Test
    public void should_pass_7() {
        assertEquals(3, newSolution(3).guessNumber(3));
    }

    @Test
    public void should_pass_8() {
        assertEquals(1, newSolution(1).guessNumber(4));
    }

    @Test
    public void should_pass_9() {
        assertEquals(2, newSolution(2).guessNumber(4));
    }

    @Test
    public void should_pass_10() {
        assertEquals(3, newSolution(3).guessNumber(4));
    }

    @Test
    public void should_pass_11() {
        assertEquals(4, newSolution(4).guessNumber(4));
    }
}