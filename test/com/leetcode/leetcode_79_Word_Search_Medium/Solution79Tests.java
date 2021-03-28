package com.leetcode.leetcode_79_Word_Search_Medium;

import static org.junit.Assert.*;

import org.junit.Test;

public class Solution79Tests {
    private Solution79 solution = Solution79.newSolution();

    @Test
    public void should_pass_1() {
        String s = "[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]";
        char[][] board = parseBoard(s);
        assertTrue(solution.exist(board, "ABCCED"));
    }

    @Test
    public void should_pass_2() {
        String s = "[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]";
        char[][] board = parseBoard(s);
        assertTrue(solution.exist(board, "SEE"));
    }

    @Test
    public void should_pass_3() {
        String s = "[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]";
        char[][] board = parseBoard(s);
        assertFalse(solution.exist(board, "ABCB"));
    }

    @Test
    public void should_pass_4() {
        String s = "[\"C\",\"A\",\"A\"],[\"A\",\"A\",\"A\"],[\"B\",\"C\",\"D\"]";
        char[][] board = parseBoard(s);
        assertTrue(solution.exist(board, "AAB"));
    }

    private char[][] parseBoard(String s) {
        s = s.substring(1, s.length() - 1).replace("[", "").replace("\"", "");
        String[] rows = s.split("],");
        char[][] board = new char[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            board[i] = parseRow(rows[i]);
        }
        return board;
    }

    private char[] parseRow(String s) {
        String[] row = s.split(",");
        char[] res = new char[row.length];
        for (int i = 0; i < row.length; i++) {
            res[i] = row[i].charAt(0);
        }
        return res;
    }
}
