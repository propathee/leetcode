package com.leetcode.leetcode_378_Kth_Smallest_Element_in_a_Sorted_Matrix_Medium;

import java.util.Arrays;

abstract class Solution378 {
    public abstract int kthSmallest(int[][] matrix, int k);

    static Solution378 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution378 {
        @Override
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int[] array = new int[n * n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i * n + j] = matrix[i][j];
                }
            }
            Arrays.sort(array);
            return array[k - 1];
        }
    }

    private static class S2 extends Solution378 {
        @Override
        public int kthSmallest(int[][] matrix, int k) {
            int low = matrix[0][0], high = matrix[matrix.length - 1][matrix.length - 1];
            while (low < high) {
                int mid = low + (high - low) / 2;
                int cnt = countNonBiggerThan(mid, matrix);
                if (cnt < k) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        private int countNonBiggerThan(int val, int[][] matrix) {
            int cnt = 0;
            for (int x = 0; x < matrix.length; x++) {
                for (int y = 0; y < matrix.length && matrix[x][y] <= val; y++) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

    private static class S3 extends Solution378 {
        @Override
        public int kthSmallest(int[][] matrix, int k) {
            int low = matrix[0][0], high = matrix[matrix.length - 1][matrix.length - 1];
            while (low < high) {
                int mid = low + (high - low) / 2;
                int cnt = countNonBiggerThan(mid, matrix);
                if (cnt < k) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }

        private int countNonBiggerThan(int val, int[][] matrix) {
            int cnt = 0;
            int x = 0, y = matrix.length - 1;
            while (x < matrix.length && y >= 0) {
                if (matrix[x][y] <= val) {
                    cnt += (y + 1);
                    x++;
                } else {
                    y--;
                }
            }
            return cnt;
        }
    }
}
