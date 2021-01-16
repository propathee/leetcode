package com.leetcode.leetcode_766_Toeplitz_Matrix_Easy;

abstract class Solution766 {
    public abstract boolean isToeplitzMatrix(int[][] matrix);

    static Solution766 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution766 {
        @Override
        public boolean isToeplitzMatrix(int[][] matrix) {
            for (int r = 0; r < matrix.length; r++) {
                if (!isToeplitz(matrix, r, 0)) {
                    return false;
                }
            }
            for (int c = 1; c < matrix[0].length; c++) {
                if (!isToeplitz(matrix, 0, c)) {
                    return false;
                }
            }
            return true;
        }

        private boolean isToeplitz(int[][] matrix, int r, int c) {
            int n = matrix[r][c];
            for (; r < matrix.length && c < matrix[0].length; r++, c++) {
                if (matrix[r][c] != n) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class S2 extends Solution766 {
        @Override
        public boolean isToeplitzMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length - 1; i ++) {
                for (int j = 0; j < matrix[0].length - 1; j++) {
                    if (matrix[i][j] != matrix[i + 1][j + 1]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
