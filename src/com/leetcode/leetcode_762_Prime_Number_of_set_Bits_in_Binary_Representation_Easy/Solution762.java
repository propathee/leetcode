package com.leetcode.leetcode_762_Prime_Number_of_set_Bits_in_Binary_Representation_Easy;

abstract class Solution762 {
    public abstract int countPrimeSetBits(int L, int R);

    static Solution762 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution762 {
        @Override
        public int countPrimeSetBits(int L, int R) {
            int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
            boolean[] isPrimes = new boolean[32];
            for (int prime : primes) {
                isPrimes[prime] = true;
            }
            int res = 0;
            for (int n = L; n <= R; n++) {
                int cnt = 0;
                int tmp = n;
                for (; tmp != 0; tmp >>= 1) {
                    if ((tmp & 1) == 1) {
                        cnt++;
                    }
                }
                if (isPrimes[cnt]) {
                    res++;
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution762 {
        @Override
        public int countPrimeSetBits(int L, int R) {
            int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
            boolean[] isPrimes = new boolean[32];
            for (int prime : primes) {
                isPrimes[prime] = true;
            }
            int res = 0;
            for (int n = L; n <= R; n++) {
                int cnt = 0;
                for (int tmp = n; tmp > 0; tmp >>= 1) {
                    cnt += tmp & 1;
                }
                if (isPrimes[cnt]) {
                    res++;
                }
            }
            return res;
        }
    }
}
