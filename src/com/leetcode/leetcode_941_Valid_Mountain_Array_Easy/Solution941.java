package com.leetcode.leetcode_941_Valid_Mountain_Array_Easy;

abstract class Solution941 {
    public abstract boolean validMountainArray(int[] arr);

    static Solution941 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution941 {
        @Override
        public boolean validMountainArray(int[] arr) {
            boolean goDown = false;
            int peak = 0;
            for (int i = 1; i < arr.length; i++) {
                if (goDown) {
                    if (arr[i] >= arr[i - 1]) {
                        return false;
                    }
                } else {
                    if (arr[i] == arr[i - 1]) {
                        return false;
                    } else if (arr[i] < arr[i - 1]) {
                        goDown = true;
                        peak = i - 1;
                    }
                }
            }
            return peak > 0;
        }
    }

    private static class S2 extends Solution941 {
        @Override
        public boolean validMountainArray(int[] arr) {
            boolean goDown = false;
            int peak = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == arr[i - 1]) {
                    return false;
                }
                if (goDown) {
                    if (arr[i] > arr[i - 1]) {
                        return false;
                    }
                } else {
                    if (arr[i] < arr[i - 1]) {
                        goDown = true;
                        peak = i - 1;
                    }
                }
            }
            return peak > 0;
        }
    }

    private static class S3 extends Solution941 {
        @Override
        public boolean validMountainArray(int[] arr) {
            int n = arr.length, i = 0, j = n - 1;
            while (i < n - 1 && arr[i] < arr[i + 1]) {
                i++;
            }
            while (j > 0 && arr[j] < arr[j - 1]) {
                j--;
            }
            return i > 0 && i == j && j < n - 1;
        }
    }
}
