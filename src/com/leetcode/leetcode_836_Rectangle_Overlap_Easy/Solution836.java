package com.leetcode.leetcode_836_Rectangle_Overlap_Easy;

abstract class Solution836 {
    public abstract boolean isRectangleOverlap(int[] rec1, int[] rec2);

    static Solution836 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution836 {
        @Override
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            return isRectangle(rec1) && isRectangle(rec2)
                && isOverlap(rec1[0], rec1[2], rec2[0], rec2[2])
                && isOverlap(rec1[1], rec1[3], rec2[1], rec2[3]);
        }

        private boolean isRectangle(int[] rec) {
            return rec[2] > rec[0] && rec[3] > rec[1];
        }

        private boolean isOverlap(int m1, int n1, int m2, int n2) {
            return (m1 <= m2 && m2 < n1) || (m2 <= m1 && m1 < n2);
        }
    }

    private static class S2 extends Solution836 {
        @Override
        public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
            return isOverlap(rec1[0], rec1[2], rec2[0], rec2[2])
                && isOverlap(rec1[1], rec1[3], rec2[1], rec2[3]);
        }

        private boolean isOverlap(int low1, int high1, int low2, int high2) {
            return low1 > low2 ? isOverlap(low2, high2, low1, high1)
                : low1 < high2 && low2 < high1 && low2 != high2;
        }
    }
}
