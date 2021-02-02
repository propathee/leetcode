package com.leetcode.leetcode_867_Transpose_Matrix_Easy;

abstract class Solution867 {
    public abstract int[][] transpose(int[][] A);

    static Solution867 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution867 {
        @Override
        public int[][] transpose(int[][] A) {
            int[][] res = new int[A[0].length][];
            for (int i = 0; i < res.length; i++) {
                res[i] = new int[A.length];
            }
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    res[j][i] = A[i][j];
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution867 {
        @Override
        public int[][] transpose(int[][] A) {
            int[][] res = new int[A[0].length][];
            for (int i = 0; i < A[0].length; i++) {
                res[i] = new int[A.length];
                for (int j = 0; j < A.length; j++) {
                    res[i][j] = A[j][i];
                }
            }
            return res;
        }
    }

    private static class S3 extends Solution867 {
        @Override
        public int[][] transpose(int[][] A) {
            int[][] res = new int[A[0].length][A.length];
            for (int i = 0; i < A[0].length; i++) {
                for (int j = 0; j < A.length; j++) {
                    res[i][j] = A[j][i];
                }
            }
            return res;
        }
    }
}
