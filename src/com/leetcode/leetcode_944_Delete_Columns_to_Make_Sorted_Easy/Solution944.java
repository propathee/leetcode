package com.leetcode.leetcode_944_Delete_Columns_to_Make_Sorted_Easy;

abstract class Solution944 {
    public abstract int minDeletionSize(String[] strs);

    static Solution944 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution944 {
        @Override
        public int minDeletionSize(String[] strs) {
            int res = 0, m = strs[0].length(), n = strs.length;
            for (int i = 0; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (strs[j].charAt(i) - strs[j - 1].charAt(i) < 0) {
                        res++;
                        break;
                    }
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution944 {
        @Override
        public int minDeletionSize(String[] strs) {
            char[][] grid = new char[strs.length][];
            for (int i = 0; i < grid.length; i++) {
                grid[i] = strs[i].toCharArray();
            }
            int res = 0;
            for (int column = 0; column < grid[0].length; column++) {
                char prev = 0;
                for (int row = 0; row < grid.length; row++) {
                    char c = grid[row][column];
                    if (c < prev) {
                        res++;
                        break;
                    }
                    prev = c;
                }
            }
            return res;
        }
    }
}
