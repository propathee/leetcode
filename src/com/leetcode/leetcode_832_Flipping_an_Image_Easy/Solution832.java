package com.leetcode.leetcode_832_Flipping_an_Image_Easy;

abstract class Solution832 {
    public abstract int[][] flipAndInvertImage(int[][] A);

    static Solution832 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution832 {
        @Override
        public int[][] flipAndInvertImage(int[][] A) {
            int n = A[0].length;
            for (int[] row : A) {
                for (int i = 0; i < (n + 1) / 2; i++) {
                    int tmp = 1 - row[i];
                    row[i] = 1 - row[n - i - 1];
                    row[n - i - 1] = tmp;
                }
            }
            return A;
        }
    }

    private static class S2 extends Solution832 {
        @Override
        public int[][] flipAndInvertImage(int[][] A) {
            int n = A[0].length;
            for (int[] row : A) {
                for (int i = 0; 2 * i < n; i++) {
                    if (row[i] == row[n - i - 1]) {
                        row[i] = row[n - i - 1] ^= 1;
                    }
                }
            }
            return A;
        }
    }
}
