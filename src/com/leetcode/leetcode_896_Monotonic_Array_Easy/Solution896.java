package com.leetcode.leetcode_896_Monotonic_Array_Easy;

abstract class Solution896 {
    public abstract boolean isMonotonic(int[] A);

    static Solution896 newSolution() {
        return new S6();
    }

    private static class S1 extends Solution896 {
        @Override
        public boolean isMonotonic(int[] A) {
            boolean isIncrease = false;
            int start = 1;
            for (int i = 1; i < A.length; i++) {
                if (A[i] != A[i - 1]) {
                    isIncrease = A[i] > A[i - 1];
                    start = i;
                    break;
                }
            }
            for (int i = start + 1; i < A.length; i++) {
                if (A[i] != A[i - 1] && (A[i] > A[i - 1]) != isIncrease) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class S2 extends Solution896 {
        @Override
        public boolean isMonotonic(int[] A) {
            int pre = 0;
            for (int i = 1; i < A.length; i++) {
                int cur = A[i] - A[i - 1];
                if (cur != 0) {
                    if ((cur > 0 && pre < 0) || (cur < 0 && pre > 0)) {
                        return false;
                    }
                    pre = cur;
                }
            }
            return true;
        }
    }

    private static class S3 extends Solution896 {
        @Override
        public boolean isMonotonic(int[] A) {
            int pre = 0;
            for (int i = 1; i < A.length; i++) {
                int cur = A[i] - A[i - 1];
                if (cur != 0) {
                    if (pre != 0 && (cur ^ pre) < 0) {
                        return false;
                    }
                    pre = cur;
                }
            }
            return true;
        }
    }

    private static class S4 extends Solution896 {
        @Override
        public boolean isMonotonic(int[] A) {
            boolean inc = true, dec = true;
            for (int i = 1; i < A.length; i++) {
                inc &= A[i] >= A[i - 1];
                dec &= A[i] <= A[i - 1];
            }
            return inc || dec;
        }
    }

    private static class S5 extends Solution896 {
        @Override
        public boolean isMonotonic(int[] A) {
            boolean inc = false, dec = false;
            for (int i = 1; i < A.length; i++) {
                if (A[i] > A[i - 1]) {
                    inc = true;
                } else if (A[i] < A[i - 1]) {
                    dec = true;
                }
                if (inc && dec) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class S6 extends Solution896 {
        @Override
        public boolean isMonotonic(int[] A) {
            if (A.length <= 1) {
                return true;
            }
            boolean inc = A[A.length - 1] > A[0];
            for (int i = 1; i < A.length; i++) {
                if (A[i] != A[i - 1] && (A[i] > A[i - 1]) != inc) {
                    return false;
                }
            }
            return true;
        }
    }
}
