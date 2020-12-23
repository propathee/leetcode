package com.leetcode.leetcode_507_Perfect_Number_Easy;

abstract class Solution507 {
    /**
     * A perfect number is a positive integer that is equal to the sum of its positive divisors,
     * excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.
     * @param num 1 <= num <= 10^8
     * @return true if n is a perfect number, otherwise false.
     */
    public abstract boolean checkPerfectNumber(int num);

    static Solution507 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution507 {
        @Override
        public boolean checkPerfectNumber(int num) {
            if (num == 1) {
                return false;
            }
            int sum = 1;
            for (int i = 2; i < Math.sqrt(num); i++) {
                if (num % i == 0) {
                    sum = sum + i + num / i;
                    if (sum > num) {
                        return false;
                    }
                }
            }
            return sum == num;
        }
    }
}
