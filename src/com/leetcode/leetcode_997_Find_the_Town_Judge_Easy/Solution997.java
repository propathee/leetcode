package com.leetcode.leetcode_997_Find_the_Town_Judge_Easy;

abstract class Solution997 {
    public abstract int findJudge(int N, int[][] trust);

    static Solution997 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution997 {
        @Override
        public int findJudge(int N, int[][] trust) {
            int[] counts = new int[N + 1];
            for (int i = 0; i < trust.length; i++) {
                counts[trust[i][0]]--;
                counts[trust[i][1]]++;
            }
            for (int i = 1; i < counts.length; i++) {
                if (counts[i] == N - 1) {
                    return i;
                }
            }
            return -1;
        }
    }
}
