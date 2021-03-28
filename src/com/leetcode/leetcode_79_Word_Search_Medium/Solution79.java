package com.leetcode.leetcode_79_Word_Search_Medium;

import java.util.HashSet;
import java.util.Set;

abstract class Solution79 {
    public abstract boolean exist(char[][] board, String word);

    static Solution79 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution79 {
        private Set<String> used = new HashSet<>();

        @Override
        public boolean exist(char[][] board, String word) {
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[0].length; y++) {
                    if (board[x][y] == word.charAt(0)) {
                        used.add(makeKey(x, y));
                        if (search(board, word, 1, x, y)) {
                            return true;
                        } else {
                            used.clear();
                        }
                    }
                }
            }
            return false;
        }

        private boolean search(char[][] board, String word, int index, int x, int y) {
            if (index >= word.length()) {
                return true;
            }
            int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};
            for (int[] move : moves) {
                int x1 = x + move[0];
                int y1 = y + move[1];
                if (x1 < 0 || x1 >= board.length || y1 < 0 || y1 >= board[0].length) {
                    continue;
                }
                if (board[x1][y1] == word.charAt(index) && !used.contains(makeKey(x1, y1))) {
                    used.add(makeKey(x1, y1));
                    if (search(board, word, index + 1, x1, y1)) {
                        return true;
                    } else {
                        used.remove(makeKey(x1, y1));
                    }
                }
            }
            return false;
        }

        private String makeKey(int x, int y) {
            return x + "," + y;
        }
    }

    private static class S2 extends Solution79 {
        @Override
        public boolean exist(char[][] board, String word) {
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[0].length; y++) {
                    if (search(board, word, 0, x, y)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean search(char[][] board, String word, int index, int x, int y) {
            if (index == word.length()) {
                return true;
            }
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length
                || board[x][y] != word.charAt(index)) {
                return false;
            }
            char tmp = board[x][y];
            board[x][y] = '!';
            if (search(board, word, index + 1, x + 1, y)
                || search(board, word, index + 1, x - 1, y)
                || search(board, word, index + 1, x, y + 1)
                || search(board, word, index + 1, x, y - 1)) {
                return true;
            }
            board[x][y] = tmp;
            return false;
        }
    }

    private static class S3 extends Solution79 {
        @Override
        public boolean exist(char[][] board, String word) {
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[0].length; y++) {
                    if (search(board, word, 0, x, y)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean search(char[][] board, String word, int index, int x, int y) {
            if (index == word.length()) {
                return true;
            }
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length
                || board[x][y] != word.charAt(index)) {
                return false;
            }
            board[x][y] ^= 256;
            if (search(board, word, index + 1, x + 1, y)
                || search(board, word, index + 1, x - 1, y)
                || search(board, word, index + 1, x, y + 1)
                || search(board, word, index + 1, x, y - 1)) {
                return true;
            }
            board[x][y] ^= 256;
            return false;
        }
    }

    private static class S4 extends Solution79 {
        private static int[][] moves = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        @Override
        public boolean exist(char[][] board, String word) {
            for (int x = 0; x < board.length; x++) {
                for (int y = 0; y < board[0].length; y++) {
                    if (search(board, word, 0, x, y)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean search(char[][] board, String word, int index, int x, int y) {
            if (board[x][y] != word.charAt(index)) {
                return false;
            }
            if (index == word.length() - 1) {
                return true;
            }
            char tmp = board[x][y];
            board[x][y] = '!';
            for (int[] move : moves) {
                int x1 = x + move[0];
                int y1 = y + move[1];
                if (x1 >= 0 && x1 < board.length && y1 >= 0 && y1 < board[0].length) {
                    if (search(board, word, index + 1, x1, y1)) {
                        return true;
                    }
                }
            }
            board[x][y] = tmp;
            return false;
        }
    }
}
