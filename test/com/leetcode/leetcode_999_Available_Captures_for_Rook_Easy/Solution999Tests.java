package com.leetcode.leetcode_999_Available_Captures_for_Rook_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution999Tests {
    private Solution999 solution = Solution999.newSolution();

    @Test
    public void should_pass_1() {
        String input = "[.,.,.,.,.,.,.,.],[.,.,.,p,.,.,.,.],[.,.,.,R,.,.,.,p],[.,.,.,.,.,.,.,.],[.,.,.,.,.,.,.,.],[.,.,.,p,.,.,.,.],[.,.,.,.,.,.,.,.],[.,.,.,.,.,.,.,.]";
        char[][] board = makeChessBoard(input);
        assertEquals(3, solution.numRookCaptures(board));
    }

    @Test
    public void should_pass_2() {
        String input = "[.,.,.,.,.,.,.,.],[.,p,p,p,p,p,.,.],[.,p,p,B,p,p,.,.],[.,p,B,R,B,p,.,.],[.,p,p,B,p,p,.,.],[.,p,p,p,p,p,.,.],[.,.,.,.,.,.,.,.],[.,.,.,.,.,.,.,.]";
        char[][] board = makeChessBoard(input);
        assertEquals(0, solution.numRookCaptures(board));
    }

    @Test
    public void should_pass_3() {
        String input = "[.,.,.,.,.,.,.,.],[.,.,.,p,.,.,.,.],[.,.,.,p,.,.,.,.],[p,p,.,R,.,p,B,.],[.,.,.,.,.,.,.,.],[.,.,.,B,.,.,.,.],[.,.,.,p,.,.,.,.],[.,.,.,.,.,.,.,.]";
        char[][] board = makeChessBoard(input);
        assertEquals(3, solution.numRookCaptures(board));
    }

    private char[][] makeChessBoard(String input) {
        input = input.substring(1, input.length() - 1).replace("[", "");
        String[] rows = input.split("],");
        char[][] board = new char[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            board[i] = makeRow(rows[i]);
        }
        return board;
    }

    private char[] makeRow(String input) {
        String[] row = input.split(",");
        char[] res = new char[row.length];
        for (int i = 0; i < row.length; i++) {
            res[i] = row[i].charAt(0);
        }
        return res;
    }
}