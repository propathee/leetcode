package com.leetcode.leetcode_908_Smallest_Range_I_Easy;

abstract class Solution908 {
    public abstract int smallestRangeI(int[] A, int K);

    static Solution908 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution908 {
        @Override
        public int smallestRangeI(int[] A, int K) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int num : A) {
                max = Math.max(max, num - K);
                min = Math.min(min, num + K);
            }
            return Math.max(0, max - min);
        }
    }

    private static class S2 extends Solution908 {
        @Override
        public int smallestRangeI(int[] A, int K) {
            int max = A[0], min = A[0];
            for (int num : A) {
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            return Math.max(0, max - min - K * 2);
        }
    }
}
