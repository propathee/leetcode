package com.leetcode.leetcode_120_Triangle_Medium;

import java.util.List;

abstract class Solution120 {
    public abstract int minimumTotal(List<List<Integer>> triangle);

    static Solution120 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution120 {
        @Override
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] dp = new int[n][n];
            dp[0][0] = triangle.get(0).get(0);
            for (int x = 1; x < n; x++) {
                dp[x][0] = dp[x-1][0] + triangle.get(x).get(0);
                for (int y = 1; y < x; y++) {
                    dp[x][y] = Math.min(dp[x-1][y-1], dp[x-1][y]) + triangle.get(x).get(y);
                }
                dp[x][x] = dp[x-1][x-1] + triangle.get(x).get(x);
            }
            int min = dp[n-1][0];
            for (int num : dp[n-1]) {
                if (num < min) {
                    min = num;
                }
            }
            return min;
        }
    }

    private static class S2 extends Solution120 {
        @Override
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                dp[n-1][i] = triangle.get(n-1).get(i);
            }
            for (int x = n - 2; x >= 0; x--) {
                for (int y = 0; y <= x; y++) {
                    dp[x][y] = Math.min(dp[x+1][y], dp[x+1][y+1]) + triangle.get(x).get(y);
                }
            }
            return dp[0][0];
        }
    }

    private static class S3 extends Solution120 {
        @Override
        public int minimumTotal(List<List<Integer>> triangle) {
            int[] dp = new int[triangle.size() + 1];
            for (int i = triangle.size() - 1; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
                }
            }
            return dp[0];
        }
    }

    private static class S4 extends Solution120 {
        @Override
        public int minimumTotal(List<List<Integer>> triangle) {
            for (int i = triangle.size() - 2; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    triangle.get(i).set(j,
                        Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)) + triangle.get(i).get(j));
                }
            }
            return triangle.get(0).get(0);
        }
    }
}
