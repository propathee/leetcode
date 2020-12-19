package com.leetcode.leetcode_461_Hamming_Distance_Easy;

abstract class Solution461 {
    /**
     * The Hamming distance between two integers is
     * the number of positions at which the corresponding bits are different.
     * <p>
     * Given two integers x and y, calculate the Hamming distance.
     * <p>
     * 0 ≤ x, y < 2^31.
     */
    public abstract int hammingDistance(int x, int y);

    static Solution461 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution461 {
        @Override
        public int hammingDistance(int x, int y) {
            int z = x ^ y;
            int dist = 0;
            do {
                if ((z & 1) != 0) {
                    dist++;
                }
                z >>>= 1;
            } while (z != 0);
            return dist;
        }
    }

    private static class S2 extends Solution461 {
        @Override
        public int hammingDistance(int x, int y) {
            int z = x ^ y;
            int dist = 0;
            while (z != 0) {
                dist += (z & 1);
                z >>>= 1;
            }
            return dist;
        }
    }

    private static class S3 extends Solution461 {
        @Override
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }

    private static class S4 extends Solution461 {
        @Override
        public int hammingDistance(int x, int y) {
            int z = x ^ y;
            int dist = 0;
            for (int i = 0; i < 32; i++) {
                dist += (z >>> i & 1);
            }
            return dist;
        }
    }

    private static class S5 extends Solution461 {
        @Override
        public int hammingDistance(int x, int y) {
            int z = x ^ y;
            int dist = 0;
            while (z != 0) {
                dist++;
                z &= (z - 1);
            }
            return dist;
        }
    }
}
