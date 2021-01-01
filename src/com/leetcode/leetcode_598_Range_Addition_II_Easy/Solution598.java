package com.leetcode.leetcode_598_Range_Addition_II_Easy;

abstract class Solution598 {
    public abstract int maxCount(int m, int n, int[][] ops);

    static Solution598 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution598 {
        @Override
        public int maxCount(int m, int n, int[][] ops) {
            int r = m, c = n;
            for (int[] op : ops) {
                r = Math.min(op[0], r);
                c = Math.min(op[1], c);
            }
            return r * c;
        }
    }
}
