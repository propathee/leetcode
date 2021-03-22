package com.leetcode.leetcode_989_Add_to_Array_Form_of_Integer_Easy;

import java.util.LinkedList;
import java.util.List;

abstract class Solution989 {
    public abstract List<Integer> addToArrayForm(int[] A, int K);

    static Solution989 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution989 {
        @Override
        public List<Integer> addToArrayForm(int[] A, int K) {
            List<Integer> res = new LinkedList<>();
            for (int i = A.length - 1; i >= 0; i--) {
                res.add(0, (A[i] + K) % 10);
                K = (A[i] + K) / 10;
            }
            while (K > 0) {
                res.add(0, K % 10);
                K /= 10;
            }
            return res;
        }
    }
}
