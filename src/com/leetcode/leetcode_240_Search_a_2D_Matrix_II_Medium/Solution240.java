package com.leetcode.leetcode_240_Search_a_2D_Matrix_II_Medium;

abstract class Solution240 {
    public abstract boolean searchMatrix(int[][] matrix, int target);

    static Solution240 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution240 {
        @Override
        public boolean searchMatrix(int[][] matrix, int target) {
            int x = 0, y = matrix[0].length - 1;
            while (x < matrix.length && y >= 0) {
                if (matrix[x][y] == target) {
                    return true;
                } else if (matrix[x][y] < target) {
                    x++;
                } else {
                    y--;
                }
            }
            return false;
        }
    }
}
