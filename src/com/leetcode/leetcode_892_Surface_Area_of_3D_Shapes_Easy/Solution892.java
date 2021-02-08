package com.leetcode.leetcode_892_Surface_Area_of_3D_Shapes_Easy;

abstract class Solution892 {
    public abstract int surfaceArea(int[][] grid);

    static Solution892 newSolution() {
        return new S6();
    }

    private static class S1 extends Solution892 {
        @Override
        public int surfaceArea(int[][] grid) {
            int area = 0, n = grid.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int h = 1; h <= grid[i][j]; h++) {
                        if (h == 1) {
                            area++;
                        }
                        if (h == grid[i][j]) {
                            area++;
                        }
                        if (i == 0 || h > grid[i - 1][j]) {
                            area++;
                        }
                        if (i == n - 1 || h > grid[i + 1][j]) {
                            area++;
                        }
                        if (j == 0 || h > grid[i][j - 1]) {
                            area++;
                        }
                        if (j == n - 1 || h > grid[i][j + 1]) {
                            area++;
                        }
                    }
                }
            }
            return area;
        }
    }

    private static class S2 extends Solution892 {
        @Override
        public int surfaceArea(int[][] grid) {
            int area = 0, n = grid.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int h = grid[i][j];
                    if (h > 0) {
                        area += 2;
                    }
                    if (i == 0) {
                        area += h;
                    } else if (h > grid[i - 1][j]) {
                        area += (h - grid[i - 1][j]);
                    }
                    if (i == n - 1) {
                        area += h;
                    } else if (h > grid[i + 1][j]) {
                        area += (h - grid[i + 1][j]);
                    }
                    if (j == 0) {
                        area += h;
                    } else if (h > grid[i][j - 1]) {
                        area += (h - grid[i][j - 1]);
                    }
                    if (j == n - 1) {
                        area += h;
                    } else if (h > grid[i][j + 1]) {
                        area += (h - grid[i][j + 1]);
                    }
                }
            }
            return area;
        }
    }

    private static class S3 extends Solution892 {
        @Override
        public int surfaceArea(int[][] grid) {
            int area = 0, n = grid.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int h = grid[i][j];
                    if (h > 0) {
                        area += 2;
                    }
                    if (i == 0) {
                        area += h;
                    } else {
                        area += Math.abs(h - grid[i - 1][j]);
                    }
                    if (i == n - 1) {
                        area += h;
                    }
                    if (j == 0) {
                        area += h;
                    } else {
                        area += Math.abs(h - grid[i][j - 1]);
                    }
                    if (j == n - 1) {
                        area += h;
                    }
                }
            }
            return area;
        }
    }

    private static class S4 extends Solution892 {
        @Override
        public int surfaceArea(int[][] grid) {
            int area = 0, n = grid.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int h = grid[i][j];
                    if (h > 0) {
                        area += (4 * h + 2);
                    }
                    if (i > 0) {
                        area -= (2 * Math.min(h, grid[i - 1][j]));
                    }
                    if (j > 0) {
                        area -= (2 * Math.min(h, grid[i][j - 1]));
                    }
                }
            }
            return area;
        }
    }

    private static class S5 extends Solution892 {
        @Override
        public int surfaceArea(int[][] grid) {
            int area = 0, n = grid.length;
            for (int i = 0; i < n; i++) {
                int pre = 0;
                for (int j = 0; j < n; j++) {
                    int cur = grid[i][j];
                    if (cur > 0) {
                        area++;
                    }
                    if (cur > pre) {
                        area += (cur - pre);
                    }
                    pre = cur;
                }
            }
            for (int j = 0; j < n; j++) {
                int pre = 0;
                for (int i = 0; i < n; i++) {
                    int cur = grid[i][j];
                    if (cur > pre) {
                        area += (cur - pre);
                    }
                    pre = cur;
                }
            }
            return area * 2;
        }
    }

    private static class S6 extends Solution892 {
        @Override
        public int surfaceArea(int[][] grid) {
            int area = 0, n = grid.length;
            for (int i = 0; i < n; i++) {
                int preX = 0, preY = 0;
                for (int j = 0; j < n; j++) {
                    int curX = grid[i][j];
                    int curY = grid[j][i];
                    if (curX > 0) {
                        area++;
                    }
                    if (curX > preX) {
                        area += (curX - preX);
                    }
                    if (curY > preY) {
                        area += (curY - preY);
                    }
                    preX = curX;
                    preY = curY;
                }
            }
            return area * 2;
        }
    }
}
