package com.leetcode.leetcode_852_Peak_Index_in_a_Mountain_Array_Easy;

abstract class Solution852 {
    public abstract int peakIndexInMountainArray(int[] arr);

    static Solution852 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution852 {
        @Override
        public int peakIndexInMountainArray(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] < arr[i]) {
                    return i;
                }
            }
            return -1;
        }
    }

    private static class S2 extends Solution852 {
        @Override
        public int peakIndexInMountainArray(int[] arr) {
            int l = 0, r = arr.length - 1;
            while (l < r) {
                int m = (l + r) / 2;
                if (arr[m] < arr[m - 1]) {
                    r = m;
                } else if (arr[m] < arr[m + 1]) {
                    l = m;
                } else {
                    return m;
                }
            }
            return -1;
        }
    }

    private static class S3 extends Solution852 {
        @Override
        public int peakIndexInMountainArray(int[] arr) {
            int l = 0, r = arr.length - 1;
            while (l < r) {
                int m = (l + r) / 2;
                if (arr[m] < arr[m + 1]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            return l;
        }
    }
}
