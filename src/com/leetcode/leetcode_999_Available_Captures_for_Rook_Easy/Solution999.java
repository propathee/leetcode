package com.leetcode.leetcode_999_Available_Captures_for_Rook_Easy;

abstract class Solution999 {
    public abstract int numRookCaptures(char[][] board);

    static Solution999 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution999 {
        @Override
        public int numRookCaptures(char[][] board) {
            int n = board.length, res = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    if (board[x][y] != 'R') {
                        continue;
                    }
                    for (int[] move : new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}}) {
                        res += capture(board, x, y, move);
                    }
                    return res;
                }
            }
            return 0;
        }

        private int capture(char[][] board, int x, int y, int[] move) {
            for (int x0 = x + move[0], y0 = y + move[1]; x0 >= 0 && x0 < board.length && y0 >= 0 && y0 < board.length; x0 += move[0], y0 += move[1]) {
                if (board[x0][y0] == 'p') {
                    return 1;
                }
                if (board[x0][y0] != '.') {
                    break;
                }
            }
            return 0;
        }
    }
}
