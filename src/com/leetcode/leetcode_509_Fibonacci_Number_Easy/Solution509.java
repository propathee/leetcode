package com.leetcode.leetcode_509_Fibonacci_Number_Easy;

abstract class Solution509 {
    /**
     * @param n 0 <= n <= 30
     */
    public abstract int fib(int n);

    static Solution509 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution509 {
        @Override
        public int fib(int n) {
            return n < 2 ? n : fib(n - 1) + fib(n - 2);
        }
    }

    private static class S2 extends Solution509 {
        @Override
        public int fib(int n) {
            if (n < 2) {
                return n;
            }
            int p = 0, q = 1;
            int r = 0;
            for (int i = 2; i <= n; i++) {
                r = p + q;
                p = q;
                q = r;
            }
            return r;
        }
    }

    private static class S3 extends Solution509 {
        @Override
        public int fib(int n) {
            if (n < 2) {
                return n;
            }
            int p = 0, q = 1;
            for (int i = 2; i <= n; i++) {
                int sum = p + q;
                p = q;
                q = sum;
            }
            return q;
        }
    }
}
