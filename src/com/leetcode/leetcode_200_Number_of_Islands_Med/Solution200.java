package com.leetcode.leetcode_200_Number_of_Islands_Med;

import java.util.LinkedList;
import java.util.Queue;

abstract class Solution200 {
    public abstract int numIslands(char[][] grid);

    static Solution200 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution200 {
        private static final int[][] MOVES = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        @Override
        public int numIslands(char[][] grid) {
            int cnt = 0;
            int xNum = grid.length, yNum = grid[0].length;
            boolean[][] visit = new boolean[xNum][yNum];
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                    if (!visit[x][y]) {
                        visit[x][y] = true;
                        if (grid[x][y] == '1') {
                            cnt++;
                            dfs(grid, visit, x, y, xNum, yNum);
                        }
                    }
                }
            }
            return cnt;
        }

        private void dfs(char[][] grid, boolean[][] visit, int x, int y, int xNum, int yNum) {
            for (int[] move : MOVES) {
                int x1 = x + move[0], y1 = y + move[1];
                if (x1 >= 0 && x1 < xNum && y1 >= 0 && y1 < yNum && !visit[x1][y1]) {
                    visit[x1][y1] = true;
                    if (grid[x1][y1] == '1') {
                        dfs(grid, visit, x1, y1, xNum, yNum);
                    }
                }
            }
        }
    }

    private static class S2 extends Solution200 {
        @Override
        public int numIslands(char[][] grid) {
            int cnt = 0;
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                    if (grid[x][y] == '1') {
                        cnt++;
                        dfs(grid, x, y);
                    }
                }
            }
            return cnt;
        }

        private void dfs(char[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
                return;
            }
            grid[x][y] = '#';
            dfs(grid, x - 1, y);
            dfs(grid, x + 1, y);
            dfs(grid, x, y - 1);
            dfs(grid, x, y + 1);
        }
    }

    private static class S3 extends Solution200 {
        private static final int[][] MOVES = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        @Override
        public int numIslands(char[][] grid) {
            int cnt = 0;
            Queue<int[]> queue = new LinkedList<>();
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[0].length; y++) {
                    if (grid[x][y] == '1') {
                        cnt++;
                        queue.offer(new int[]{x, y});
                        bfs(grid, queue);
                    }
                }
            }
            return cnt;
        }

        private void bfs(char[][] grid, Queue<int[]> queue) {
            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                int x = node[0], y = node[1];
                grid[x][y] = '#';
                for (int[] move : MOVES) {
                    int x1 = x + move[0], y1 = y + move[1];
                    if (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length && grid[x1][y1] == '1') {
                        queue.offer(new int[] {x1, y1});
                    }
                }
            }
        }
    }
}
