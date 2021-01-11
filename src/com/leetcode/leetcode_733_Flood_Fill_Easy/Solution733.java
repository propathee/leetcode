package com.leetcode.leetcode_733_Flood_Fill_Easy;

abstract class Solution733 {
    public abstract int[][] floodFill(int[][] image, int sr, int sc, int newColor);

    static Solution733 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution733 {
        @Override
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            markAll(image, sr, sc, image[sr][sc]);
            for (int i = 0; i < image.length; i++) {
                for (int j = 0; j < image[0].length; j++) {
                    if (image[i][j] < 0) {
                        image[i][j] = newColor;
                    }
                }
            }
            return image;
        }

        private void markAll(int[][] image, int r, int c, int n) {
            if (image[r][c] != n || image[r][c] == -1) {
                return;
            }
            image[r][c] = -1;
            if (r > 0) {
                markAll(image, r - 1, c, n);
            }
            if (r < image.length - 1) {
                markAll(image, r + 1, c, n);
            }
            if (c > 0) {
                markAll(image, r, c - 1, n);
            }
            if (c < image[0].length - 1) {
                markAll(image, r, c + 1, n);
            }
        }
    }

    private static class S2 extends Solution733 {
        @Override
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            if (image[sr][sc] != newColor) {
                helper(image, sr, sc, newColor, image[sr][sc]);
            }
            return image;
        }

        private void helper(int[][] image, int r, int c, int newColor, int oldColor) {
            if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != oldColor) {
                return;
            }
            image[r][c] = newColor;
            helper(image, r - 1, c, newColor, oldColor);
            helper(image, r + 1, c, newColor, oldColor);
            helper(image, r, c - 1, newColor, oldColor);
            helper(image, r, c + 1, newColor, oldColor);
        }
    }
}
