package com.leetcode.leetcode_812_Largest_Triangle_Area_Easy;

import java.util.ArrayList;
import java.util.List;

abstract class Solution812 {
    public abstract double largestTriangleArea(int[][] points);

    static Solution812 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution812 {
        @Override
        public double largestTriangleArea(int[][] points) {
            double max = 0;
            for (int a = 0; a < points.length; a++) {
                for (int b = a + 1; b < points.length; b++) {
                    for (int c = b + 1; c < points.length; c++) {
                        double area = 0.5 * Math.abs(points[a][0] * points[b][1]
                            + points[b][0] * points[c][1]
                            + points[c][0] * points[a][1]
                            - points[a][0] * points[c][1]
                            - points[b][0] * points[a][1]
                            - points[c][0] * points[b][1]);
                        max = Math.max(max, area);
                    }
                }
            }
            return max;
        }
    }

    private static class S2 extends Solution812 {
        @Override
        public double largestTriangleArea(int[][] points) {
            double max = 0;
            for (int[] a : points) {
                for (int[] b : points) {
                    for (int[] c : points) {
                        double area = 0.5 * Math.abs(
                            a[0] * b[1] + b[0] * c[1] + c[0] * a[1]
                            - a[0] * c[1] - b[0] * a[1] - c[0] * b[1]);
                        max = Math.max(max, area);
                    }
                }
            }
            return max;
        }
    }

    private static class S3 extends Solution812 { // wrong answer!
        @Override
        public double largestTriangleArea(int[][] points) {
            int u = -50, d = 50, l = 50, r = -50;
            List<int[]> uPoints = new ArrayList<>(), dPoints = new ArrayList<>(),
                lPoints = new ArrayList<>(), rPoints = new ArrayList<>();
            for (int[] point : points) {
                u = compareThenUpdate(point, false, point[1], u, uPoints);
                d = compareThenUpdate(point, true, point[1], d, dPoints);
                l = compareThenUpdate(point, true, point[0], l, lPoints);
                r = compareThenUpdate(point, false, point[0], r, rPoints);
            }
            uPoints.addAll(dPoints);
            uPoints.addAll(lPoints);
            uPoints.addAll(rPoints);
            double max = 0;
            int n = uPoints.size();
            for (int a = 0; a < n; a++) {
                for (int b = a + 1; b < n; b++) {
                    for (int c = b + 1; c < n; c++) {
                        max = Math.max(max, area(uPoints.get(a), uPoints.get(b), uPoints.get(c)));
                    }
                }
            }
            return max;
        }

        private int compareThenUpdate(int[] point, boolean reverse, int newV, int oldV, List<int[]> points) {
            if (newV == oldV) {
                points.add(point);
                return oldV;
            } else if ((newV < oldV) == reverse) {
                points.clear();
                points.add(point);
                return newV;
            } else {
                return oldV;
            }
        }

        private double area(int[] a, int[] b, int[] c) {
            return 0.5 * Math.abs(a[0] * b[1] + b[0] * c[1] + c[0] * a[1]
                - a[0] * c[1] - b[0] * a[1] - c[0] * b[1]);
        }
    }
}
