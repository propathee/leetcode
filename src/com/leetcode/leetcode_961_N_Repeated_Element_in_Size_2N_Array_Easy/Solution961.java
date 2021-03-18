package com.leetcode.leetcode_961_N_Repeated_Element_in_Size_2N_Array_Easy;

import java.util.HashSet;
import java.util.Set;

abstract class Solution961 {
    public abstract int repeatedNTimes(int[] A);

    static Solution961 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution961 {
        @Override
        public int repeatedNTimes(int[] A) {
            Set<Integer> set = new HashSet<>();
            for (int num : A) {
                if (!set.add(num)) {
                    return num;
                }
            }
            return -1;
        }
    }

    private static class S2 extends Solution961 {
        @Override
        public int repeatedNTimes(int[] A) {
            int[] counts = new int[10001];
            for (int num : A) {
                if (++counts[num] > 1) {
                    return num;
                }
            }
            return -1;
        }
    }

    private static class S3 extends Solution961 {
        @Override
        public int repeatedNTimes(int[] A) {
            for (int i = 2; i < A.length; i++) {
                if (A[i] == A[i - 1] || A[i] == A[i - 2]) {
                    return A[i];
                }
            }
            return A[0];
        }
    }
}
