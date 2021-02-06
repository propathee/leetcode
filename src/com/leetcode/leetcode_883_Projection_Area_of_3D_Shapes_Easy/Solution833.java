package com.leetcode.leetcode_883_Projection_Area_of_3D_Shapes_Easy;

abstract class Solution833 {
    public abstract int projectionArea(int[][] grid);

    static Solution833 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution833 {
        @Override
        public int projectionArea(int[][] grid) {
            return xyArea(grid) + xzArea(grid) + yzArea(grid);
        }

        private int xyArea(int[][] grid) {
            int area = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] > 0) {
                        area++;
                    }
                }
            }
            return area;
        }

        private int xzArea(int[][] grid) {
            int area = 0;
            for (int i = 0; i < grid.length; i++) {
                int height = 0;
                for (int j = 0; j < grid[0].length; j++) {
                    height = Math.max(height, grid[i][j]);
                }
                area += height;
            }
            return area;
        }

        private int yzArea(int[][] grid) {
            int area = 0;
            for (int j = 0; j < grid[0].length; j++) {
                int height = 0;
                for (int i = 0; i < grid.length; i++) {
                    height = Math.max(height, grid[i][j]);
                }
                area += height;
            }
            return area;
        }
    }

    private static class S2 extends Solution833 {
        @Override
        public int projectionArea(int[][] grid) {
            int area = 0, n = grid.length;
            for (int i = 0; i < n; i++) {
                int x = 0, y = 0;
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > 0) {
                        area++;
                    }
                    x = Math.max(x, grid[i][j]);
                    y = Math.max(y, grid[j][i]);
                }
                area = area + x + y;
            }
            return area;
        }
    }
}
