package com.leetcode.leetcode_492_Construct_the_Rectangle_Easy;

abstract class Solution492 {
    /**
     * 1 <= area <= 10^7
     */
    public abstract int[] constructRectangle(int area);

    static Solution492 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution492 {
        @Override
        public int[] constructRectangle(int area) {
            for (int width = (int) Math.sqrt(area); width >= 1; width--) {
                if (area % width == 0) {
                    return new int[] {area / width, width};
                }
            }
            return new int[] {area, 1};
        }
    }

    private static class S2 extends Solution492 {
        @Override
        public int[] constructRectangle(int area) {
            int width = (int) Math.sqrt(area);
            while (area % width != 0) {
                width--;
            }
            return new int[] {area / width, width};
        }
    }
}
