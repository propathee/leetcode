package com.leetcode.leetcode_367_Valid_Perfect_Square_Easy;

public abstract class Solution367 {
    /**
     * Given a positive integer num, write a function
     * which returns True if num is a perfect square else False.
     * <p>Follow up: Do not use any built-in library function such as sqrt.
     * @param num 1 <= num <= 2^31 - 1
     */
    public abstract boolean isPerfectSquare(int num);

    public static Solution367 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution367 {
        @Override
        public boolean isPerfectSquare(int num) {
            for (int i = 1; ; i++) {
                int pow = i * i;
                if (pow < num) {
                    if (Integer.MAX_VALUE - pow >= (2 * i + 1)) {
                        continue;
                    } else {
                        return false;
                    }
                }
                return pow == num;
            }
        }
    }

    private static class S2 extends Solution367 {
        @Override
        public boolean isPerfectSquare(int num) {
            for (long i = 1; ; i++) {
                long pow = i * i;
                if (pow < num) {
                    continue;
                }
                return pow == num;
            }
        }
    }

    private static class S3 extends Solution367 {
        @Override
        public boolean isPerfectSquare(int num) {
            for (int i = 0; num > 0;i++) {
                num -= (2 * i + 1);
            }
            return num == 0;
        }
    }

    private static class S4 extends Solution367 {
        @Override
        public boolean isPerfectSquare(int num) {
            int low = 1;
            int high = num;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                long pow = (long)mid * mid;
                if (pow == num) {
                    return true;
                } else if (pow > num) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return false;
        }
    }

    private static class S5 extends Solution367 {
        @Override
        public boolean isPerfectSquare(int num) {
            long x = num;
            while (x * x > num) {
                x = (x + num / x) >> 1;
            }
            return x * x == num;
        }
    }
}
