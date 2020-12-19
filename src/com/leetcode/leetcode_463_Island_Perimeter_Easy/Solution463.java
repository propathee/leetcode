package com.leetcode.leetcode_463_Island_Perimeter_Easy;

abstract class Solution463 {
    public abstract int islandPerimeter(int[][] grid);

    static Solution463 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution463 {
        @Override
        public int islandPerimeter(int[][] grid) {
            int perimeter = 0;
            int height = grid.length;
            int width = grid[0].length;
            for (int x = 0; x < height; x++) {
                for (int y = 0; y < width; y++) {
                    if (grid[x][y] == 0) {
                        continue;
                    }
                    if (x == 0 || grid[x - 1][y] == 0) {
                        perimeter++;
                    }
                    if (y == 0 || grid[x][y - 1] == 0) {
                        perimeter++;
                    }
                    if (x == height - 1 || grid[x + 1][y] == 0) {
                        perimeter++;
                    }
                    if (y == width - 1 || grid[x][y + 1] == 0) {
                        perimeter++;
                    }
                }
            }
            return perimeter;
        }
    }

    private static class S2 extends Solution463 {
        @Override
        public int islandPerimeter(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            int islands = 0;
            int neighbors = 0;
            for (int x = 0; x < height; x++) {
                for (int y = 0; y < width; y++) {
                    if (grid[x][y] == 0) {
                        continue;
                    }
                    islands++;
                    if (x < height - 1 && grid[x + 1][y] == 1) {
                        neighbors++;
                    }
                    if (y < width - 1 && grid[x][y + 1] == 1) {
                        neighbors++;
                    }
                }
            }
            return 4 * islands - 2 * neighbors;
        }
    }
}
