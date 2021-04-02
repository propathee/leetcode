package com.leetcode.leetcode_97_Interleaving_String_Medium;

import java.util.*;

abstract class Solution97 {
    public abstract boolean isInterleave(String s1, String s2, String s3);

    static Solution97 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution97 {
        @Override
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            return dfs(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0);
        }

        private boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k) {
            if (k == c3.length) {
                return true;
            }
            return (i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i+1, j, k+1))
                || (j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j+1, k+1));

        }
    }

    private static class S2 extends Solution97 {
        @Override
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            return dfs(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0,
                new boolean[s1.length() + 1][s2.length() + 1]);
        }

        private boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
            if (invalid[i][j]) {
                return false;
            }
            if (k == c3.length) {
                return true;
            }
            boolean isValid = (i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i+1, j, k+1, invalid))
                || (j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j+1, k+1, invalid));
            if (!isValid) {
                invalid[i][j] = true;
            }
            return isValid;
        }
    }

    private static class S3 extends Solution97 {
        @Override
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
            char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
            for (int i = 0; i <= c1.length; i++) {
                for (int j = 0; j <= c2.length; j++) {
                    if (i == 0 && j == 0) {
                        dp[i][j] = true;
                    } else if (i == 0) {
                        dp[0][j] = dp[0][j - 1] && c2[j - 1] == c3[i + j - 1];
                    } else if (j == 0) {
                        dp[i][0] = dp[i - 1][0] && c1[i - 1] == c3[i + j - 1];
                    } else {
                        dp[i][j] = (dp[i][j - 1] && c2[j - 1] == c3[i + j - 1])
                            || (dp[i - 1][j] && c1[i - 1] == c3[i + j - 1]);
                    }
                }
            }
            return dp[c1.length][c2.length];
        }
    }

    private static class S4 extends Solution97 {
        @Override
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
            Set<Point> visited = new HashSet<>();
            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(0, 0));
            int matchLen = 0;
            while (!queue.isEmpty() && matchLen < c3.length) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Point point = queue.poll();
                    int x = point.x, y = point.y;
                    if (x < c1.length && c1[x] == c3[matchLen]) {
                        Point newPoint = new Point(x + 1, y);
                        if (visited.add(newPoint)) {
                            queue.offer(newPoint);
                        }
                    }
                    if (y < c2.length && c2[y] == c3[matchLen]) {
                        Point newPoint = new Point(x, y + 1);
                        if (visited.add(newPoint)) {
                            queue.offer(newPoint);
                        }
                    }
                }
                if (!queue.isEmpty()) {
                    matchLen++;
                }
            }
            return matchLen == c3.length;
        }

        private static class Point {
            private int x;
            private int y;

            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                Point point = (Point) o;
                return x == point.x && y == point.y;
            }

            @Override
            public int hashCode() {
                return  x * 31 + y;
            }
        }
    }
}
