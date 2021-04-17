package com.leetcode.leetcode_130_Surrounded_Regions_Medium;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Solution130Tests {
    private Solution130 solution = Solution130.newSolution();

    @Test
    public void should_pass_1() {
        char[][] input = toBoard("[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"O\",\"X\"],[\"X\",\"X\",\"O\",\"X\"],[\"X\",\"O\",\"X\",\"X\"]");
        char[][] expect = toBoard("[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"X\",\"X\",\"X\"],[\"X\",\"O\",\"X\",\"X\"]");
        solution.solve(input);
        assertPass(expect, input);
    }

    @Test
    public void should_pass_2() {
        char[][] input = toBoard("[\"X\"]");
        char[][] expect = toBoard("[\"X\"]");
        solution.solve(input);
        assertPass(expect, input);
    }

    private char[][] toBoard(String s) {
        s = s.substring(1, s.length() - 1).replace("\"", "").replace("[", "");
        String[] rows = s.split("],");
        char[][] board = new char[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            board[i] = toRow(rows[i]);
        }
        return board;
    }

    private char[] toRow(String s) {
        String[] chars = s.split(",");
        char[] res = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            res[i] = chars[i].charAt(0);
        }
        return res;
    }

    private void assertPass(char[][] expect, char[][] actual) {
        assertEquals(expect.length, actual.length);
        for (int i = 0; i < expect.length; i++) {
            assertArrayEquals(expect[i], actual[i]);
        }
    }
}