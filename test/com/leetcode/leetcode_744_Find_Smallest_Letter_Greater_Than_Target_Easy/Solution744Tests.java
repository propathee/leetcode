package com.leetcode.leetcode_744_Find_Smallest_Letter_Greater_Than_Target_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution744Tests {
    private Solution744 solution = Solution744.newSolution();

    @Test
    public void should_pass_1() {
        char[] letters = {'c','f','j'};
        assertEquals('c', solution.nextGreatestLetter(letters, 'a'));
    }

    @Test
    public void should_pass_2() {
        char[] letters = {'c','f','j'};
        assertEquals('f', solution.nextGreatestLetter(letters, 'c'));
    }

    @Test
    public void should_pass_3() {
        char[] letters = {'c','f','j'};
        assertEquals('f', solution.nextGreatestLetter(letters, 'd'));
    }

    @Test
    public void should_pass_4() {
        char[] letters = {'c','f','j'};
        assertEquals('j', solution.nextGreatestLetter(letters, 'g'));
    }

    @Test
    public void should_pass_5() {
        char[] letters = {'c','f','j'};
        assertEquals('c', solution.nextGreatestLetter(letters, 'j'));
    }

    @Test
    public void should_pass_6() {
        char[] letters = {'c','f','j'};
        assertEquals('c', solution.nextGreatestLetter(letters, 'k'));
    }

    @Test
    public void should_pass_7() {
        char[] letters = {'e','e','e','e','e','e','n','n','n','n'};
        assertEquals('n', solution.nextGreatestLetter(letters, 'e'));
    }
}