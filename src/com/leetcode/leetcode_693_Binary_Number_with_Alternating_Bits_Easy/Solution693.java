package com.leetcode.leetcode_693_Binary_Number_with_Alternating_Bits_Easy;

abstract class Solution693 {
    /**
     * 1 <= n <= 2^31 - 1
     */
    public abstract boolean hasAlternatingBits(int n);

    static Solution693 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution693 {
        @Override
        public boolean hasAlternatingBits(int n) {
            int sqr = 1;
            while (n >>> sqr != 0) {
                sqr++;
            }
            return (n ^ (n >>> 1)) == Math.pow(2, sqr) - 1;
        }
    }

    private static class S2 extends Solution693 {
        @Override
        public boolean hasAlternatingBits(int n) {
            n ^= (n >>> 1); // >> is okay
            return (n & (n + 1)) == 0;
        }
    }

    private static class S3 extends Solution693 {
        @Override
        public boolean hasAlternatingBits(int n) {
            int d = n & 1;
            while ((n & 1) == d) {
                d = 1 - d;
                n >>= 1;
            }
            return n == 0;
        }
    }
}
