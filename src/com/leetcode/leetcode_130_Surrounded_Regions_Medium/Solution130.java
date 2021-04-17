package com.leetcode.leetcode_130_Surrounded_Regions_Medium;

abstract class Solution130 {
    public abstract void solve(char[][] board);

    static Solution130 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution130 {
        @Override
        public void solve(char[][] board) {
            int row = board.length;
            int col = board[0].length;
            for (int x = 0; x < row; x++) {
                doSolve(board, x, 0, row, col);
            }
            for (int x = 0; x < row; x++) {
                doSolve(board, x, col - 1, row, col);
            }
            for (int y = 0; y < col; y++) {
                doSolve(board, 0, y, row, col);
            }
            for (int y = 0; y < col; y++) {
                doSolve(board, row - 1, y, row , col);
            }
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {
                    if (board[x][y] == 'A') {
                        board[x][y] = 'O';
                    } else if (board[x][y] == 'O') {
                        board[x][y] = 'X';
                    }
                }
            }
        }

        private void doSolve(char[][] board, int x, int y, int row, int col) {
            if (board[x][y] == 'X' || board[x][y] == 'A') {
                return;
            }
            if (board[x][y] == 'O') {
                board[x][y] = 'A';
                if (x > 1) {
                    doSolve(board, x - 1, y, row, col);
                }
                if (x < row - 1) {
                    doSolve(board, x + 1, y, row, col);
                }
                if (y > 1) {
                    doSolve(board, x, y - 1, row, col);
                }
                if (y < col - 1) {
                    doSolve(board, x, y + 1, row, col);
                }
            }
        }
    }

    private static class S2 extends Solution130 {
        @Override
        public void solve(char[][] board) {
            int row = board.length;
            int col = board[0].length;
            for (int x = 0; x < row; x++) {
                doSolve(board, x, 0, row, col, 'R');
                if (col > 1) {
                    doSolve(board, x, col - 1, row, col, 'L');
                }
            }
            for (int y = 1; y < col - 1; y++) {
                doSolve(board, 0, y, row, col, 'D');
                if (row > 1) {
                    doSolve(board, row - 1, y, row , col, 'U');
                }
            }
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {
                    if (board[x][y] == 'A') {
                        board[x][y] = 'O';
                    } else if (board[x][y] == 'O') {
                        board[x][y] = 'X';
                    }
                }
            }
        }

        private void doSolve(char[][] board, int x, int y, int row, int col, char direction) {
            if (board[x][y] == 'X' || board[x][y] == 'A') {
                return;
            }
            if (board[x][y] == 'O') {
                board[x][y] = 'A';
                if (x > 1 && direction != 'D') {
                    doSolve(board, x - 1, y, row, col, 'U');
                }
                if (x < row - 1 && direction != 'U') {
                    doSolve(board, x + 1, y, row, col, 'D');
                }
                if (y > 1 && direction != 'R') {
                    doSolve(board, x, y - 1, row, col, 'L');
                }
                if (y < col - 1 && direction != 'L') {
                    doSolve(board, x, y + 1, row, col, 'R');
                }
            }
        }
    }

    private static class S3 extends Solution130 {
        @Override
        public void solve(char[][] board) {
            int row = board.length;
            int col = board[0].length;
            boolean[][] visited = new boolean[row][col];
            for (int x = 0; x < row; x++) {
                doSolve(board, x, 0, visited);
                doSolve(board, x, col - 1, visited);
            }
            for (int y = 1; y < col - 1; y++) {
                doSolve(board, 0, y, visited);
                doSolve(board, row - 1, y, visited);
            }
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {
                    if (board[x][y] == 'A') {
                        board[x][y] = 'O';
                    } else if (board[x][y] == 'O') {
                        board[x][y] = 'X';
                    }
                }
            }
        }

        private void doSolve(char[][] board, int x, int y, boolean[][] visited) {
            if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1) {
                return;
            }
            if (visited[x][y] || board[x][y] == 'X' || board[x][y] == 'A') {
                return;
            }
            if (board[x][y] == 'O') {
                board[x][y] = 'A';
                visited[x][y] = true;
                doSolve(board, x - 1, y, visited);
                doSolve(board, x + 1, y, visited);
                doSolve(board, x, y - 1, visited);
                doSolve(board, x, y + 1, visited);
            }
        }
    }

    private static class S4 extends Solution130 {
        private int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        @Override
        public void solve(char[][] board) {
            int row = board.length;
            int col = board[0].length;
            boolean[][] visited = new boolean[row][col];
            for (int x = 0; x < row; x++) {
                if (board[x][0] == 'O') {
                    doSolve(board, x, 0, visited);
                }
                if (board[x][col - 1] == 'O') {
                    doSolve(board, x, col - 1, visited);
                }
            }
            for (int y = 1; y < col - 1; y++) {
                if (board[0][y] == 'O') {
                    doSolve(board, 0, y, visited);
                }
                if (board[row - 1][y] == 'O') {
                    doSolve(board, row - 1, y, visited);
                }
            }
            for (int x = 0; x < row; x++) {
                for (int y = 0; y < col; y++) {
                    if (board[x][y] == 'A') {
                        board[x][y] = 'O';
                    } else if (board[x][y] == 'O') {
                        board[x][y] = 'X';
                    }
                }
            }
        }

        private void doSolve(char[][] board, int x, int y, boolean[][] visited) {
            board[x][y] = 'A';
            visited[x][y] = true;
            for (int[] move : moves) {
                int x1 = x + move[0];
                int y1 = y + move[1];
                if (!(x1 < 0 || x1 > board.length - 1 || y1 < 0 || y1 > board[0].length - 1)
                    && !visited[x1][y1]
                    && board[x1][y1] == 'O') {
                    doSolve(board, x1, y1, visited);
                }
            }
        }
    }
}
