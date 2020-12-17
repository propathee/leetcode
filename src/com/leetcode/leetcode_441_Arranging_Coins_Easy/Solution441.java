package com.leetcode.leetcode_441_Arranging_Coins_Easy;

public abstract class Solution441 {
    /**
     * You have a total of n coins that you want to form in a staircase shape,
     * where every k-th row must have exactly k coins.
     * <p>
     * Given n, find the total number of full staircase rows that can be formed.
     * @param n n is a non-negative integer and fits within the range of a 32-bit signed integer.
     */
    public abstract int arrangeCoins(int n);

    static Solution441 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution441 {
        @Override
        public int arrangeCoins(int n) {
            int cnt = 0;
            while (n > cnt) {
                cnt++;
                n -= cnt;
            }
            return cnt;
        }
    }

    private static class S2 extends Solution441 {
        @Override
        public int arrangeCoins(int n) {
            int cnt = 1;
            for (; n >= cnt; cnt++) {
                n -= cnt;
            }
            return cnt - 1;
        }
    }

    private static class S3 extends Solution441 {
        @Override
        public int arrangeCoins(int n) {
            int cnt = 0;
            while (n > 0) {
                cnt++;
                n = n - cnt - 1;
            }
            return cnt;
        }
    }

    private static class S4 extends Solution441 {
        @Override
        public int arrangeCoins(int n) {
            return (int) (Math.sqrt((double) 2 * n + 0.25) - 0.5);
        }
    }

    private static class S5 extends Solution441 {
        @Override
        public int arrangeCoins(int n) {
            return (int) (Math.sqrt((long) 2 * n + 0.25) - 0.5);
        }
    }
}
