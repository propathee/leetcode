package com.leetcode.leetcode_436_Find_Right_Interval_Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Solution436 {
    public abstract int[] findRightInterval(int[][] intervals);

    static Solution436 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution436 {
        @Override
        public int[] findRightInterval(int[][] intervals) {
            int[] leftBoundaries = new int[intervals.length];
            Map<Integer, Integer> lBound2idx = new HashMap<>();
            for (int i = 0; i < intervals.length; i++) {
                leftBoundaries[i] = intervals[i][0];
                lBound2idx.put(intervals[i][0], i);
            }
            Arrays.sort(leftBoundaries);

            int[] res = new int[intervals.length];
            for (int i = 0; i < intervals.length; i++) {
                int j = binarySearch(leftBoundaries, intervals[i][1]);
                if (j == leftBoundaries.length) {
                    res[i] = -1;
                } else {
                    res[i] = lBound2idx.get(leftBoundaries[j]);
                }
            }
            return res;
        }

        private int binarySearch(int[] array, int val) {
            int l = 0, r = array.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (array[mid] < val) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return array[l] >= val ? l : l + 1;
        }
    }

    private static class S2 extends Solution436 {
        @Override
        public int[] findRightInterval(int[][] intervals) {
            int[] result = new int[intervals.length];
            TreeMap<Integer, Integer> intervalMap = new TreeMap<>();

            for (int i = 0; i < intervals.length; ++i) {
                intervalMap.put(intervals[i][0], i);
            }

            for (int i = 0; i < intervals.length; ++i) {
                Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i][1]);
                result[i] = (entry != null) ? entry.getValue() : -1;
            }

            return result;
        }
    }

    private static class S3 extends Solution436 {
        @Override
        public int[] findRightInterval(int[][] intervals) {
            int[][] indexedIntervals = new int[intervals.length][3];
            for (int i = 0; i < intervals.length; i++) {
                indexedIntervals[i][0] = intervals[i][0];
                indexedIntervals[i][1] = intervals[i][1];
                indexedIntervals[i][2] = i;
            }
            Arrays.sort(indexedIntervals, (x, y) -> x[0] - y[0]);

            int[] res = new int[intervals.length];
            for (int i = 0; i < intervals.length; i++) {
                int j = binarySearch(indexedIntervals, intervals[i][1]);
                if (j == intervals.length) {
                    res[i] = -1;
                } else {
                    res[i] = indexedIntervals[j][2];
                }
            }
            return res;
        }

        private int binarySearch(int[][] array, int val) {
            int l = 0, r = array.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (array[mid][0] < val) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
    }
}
