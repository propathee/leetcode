package com.leetcode.leetcode_661_Image_Smoother_Easy;

abstract class Solution661 {
    public abstract int[][] imageSmoother(int[][] M);

    static Solution661 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution661 {
        @Override
        public int[][] imageSmoother(int[][] M) {
            int r = M.length, c = M[0].length;
            int[][] matrix = new int[r + 2][c + 2];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    matrix[i + 1][j + 1] = M[i][j];
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int sum = 0;
                    int cnt = 0;
                    for (int x = i; x < i + 3; x++) {
                        for (int y = j; y < j + 3; y++) {
                            sum += matrix[x][y];
                            if (x > 0 && x <= r && y > 0 && y <= c) {
                                cnt++;
                            }
                        }
                    }
                    M[i][j] = sum / cnt;
                }
            }
            return M;
        }
    }

    private static class S2 extends Solution661 {
        @Override
        public int[][] imageSmoother(int[][] M) {
            int r = M.length, c = M[0].length;
            int[][] matrix = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int sum = 0;
                    int cnt = 0;
                    for (int x = i - 1; x <= i + 1; x++) {
                        for (int y = j - 1; y <= j + 1; y++) {
                            if (x >= 0 && x < r && y >= 0 && y < c) {
                                sum += M[x][y];
                                cnt++;
                            }
                        }
                    }
                    matrix[i][j] = sum / cnt;
                }
            }
            return matrix;
        }
    }

    private static class S3 extends Solution661 {
        @Override
        public int[][] imageSmoother(int[][] M) {
            int r = M.length, c = M[0].length;
            int[][] moves = {{0,1},{0,-1},{1,0},{1,1},{1,-1},{-1,0},{-1,1},{-1,-1}};
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    int sum = M[i][j], cnt = 1;
                    for (int[] move : moves) {
                        int x = i + move[0], y = j + move[1];
                        if (x >= 0 && x < r && y >= 0 && y < c) {
                            sum += (M[x][y] & 255);
                            cnt++;
                        }
                    }
                    M[i][j] |= ((sum / cnt) << 8);
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    M[i][j] >>= 8;
                }
            }
            return M;
        }
    }

    private static class S4 extends Solution661 {
        @Override
        public int[][] imageSmoother(int[][] M) {
            int r = M.length, c = M[0].length;
            for (int i = 0; i < r; i++) {
                sumRow(M[i], c);
            }
            for (int j = 0; j < c; j++) {
                sumCol(M, j, r);
            }
            smooth(M, r, c);
            return M;
        }

        private void sumRow(int[] row, int c) {
            int pre = 0;
            for (int i = 0; i < c - 1; i++) {
                int tmp = row[i];
                row[i] = pre + tmp + row[i + 1];
                pre = tmp;
            }
            row[c - 1] += pre;
        }

        private void sumCol(int[][] m, int col, int r) {
            int pre = 0;
            for (int j = 0; j < r - 1; j++) {
                int tmp = m[j][col];
                m[j][col] = pre + tmp + m[j + 1][col];
                pre = tmp;
            }
            m[r - 1][col] += pre;
        }

        private void smooth(int[][] m, int r, int c) {
            int cnt;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (r == 1) {
                        if (c == 1) {
                            cnt = 1;
                        } else if (j == 0 || j == c - 1) {
                            cnt = 2;
                        } else {
                            cnt = 3;
                        }
                    } else if (c == 1) {
                        if (i == 0 || i == r - 1) {
                            cnt = 2;
                        } else {
                            cnt = 3;
                        }
                    } else if (i == 0 || i == r - 1) {
                        if (j == 0 || j == c - 1) {
                            cnt = 4;
                        } else {
                            cnt = 6;
                        }
                    } else {
                        if (j == 0 || j == c - 1) {
                            cnt = 6;
                        } else {
                            cnt = 9;
                        }
                    }
                    m[i][j] /= cnt;
                }
            }
        }
    }
}
