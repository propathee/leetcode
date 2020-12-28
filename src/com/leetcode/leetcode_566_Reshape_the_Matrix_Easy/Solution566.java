package com.leetcode.leetcode_566_Reshape_the_Matrix_Easy;

abstract class Solution566 {
    public abstract int[][] matrixReshape(int[][] nums, int r, int c);

    static Solution566 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution566 {
        @Override
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int oldR = nums.length;
            int oldC = nums[0].length;
            if ((oldR * oldC) != (r * c)) {
                return nums;
            }
            int [][] newMatrix = new int[r][];
            for (int i = 0; i < r; i++) {
                int[] row = new int[c];
                newMatrix[i] = row;
                for (int j = 0; j < c; j++) {
                    int index = i * c + j;
                    int oldI = index / oldC;
                    int oldJ = index % oldC;
                    row[j] = nums[oldI][oldJ];
                }
            }
            return newMatrix;
        }
    }

    private static class S2 extends Solution566 {
        @Override
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int oldC = nums[0].length;
            if (nums.length * oldC != r * c) {
                return nums;
            }
            int [][] newMatrix = new int[r][c];
            for (int i = 0; i < r * c; i++) {
                newMatrix[i / c][i % c] = nums[i / oldC][i % oldC];
            }
            return newMatrix;
        }
    }
}
