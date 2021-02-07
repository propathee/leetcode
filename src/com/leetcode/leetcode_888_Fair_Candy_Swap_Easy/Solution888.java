package com.leetcode.leetcode_888_Fair_Candy_Swap_Easy;

import java.util.HashSet;
import java.util.Set;

abstract class Solution888 {
    public abstract int[] fairCandySwap(int[] A, int[] B);

    static Solution888 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution888 {
        @Override
        public int[] fairCandySwap(int[] A, int[] B) {
            int sumA = 0, sumB = 0;
            Set<Integer> setB = new HashSet<>();
            for (int n : B) {
                sumB += n;
                setB.add(n);

            }
            for (int n : A) {
                sumA += n;
            }
            int diff = (sumB - sumA) / 2;
            for (int n : A) {
                if (setB.contains(n + diff)) {
                    return new int[] {n, n + diff};
                }
            }
            return new int[0];
        }
    }
}
