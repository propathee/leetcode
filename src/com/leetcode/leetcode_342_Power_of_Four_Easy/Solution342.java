package com.leetcode.leetcode_342_Power_of_Four_Easy;

public class Solution342 {
    public boolean isPowerOfFour_1(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    /**
     * (n & (n-1)) == 0 -> n is 2^i;
     * (n - 1) % 3 == 0 -> n is 2^i and i is even;
     * (4^i - 1) % 3 = (3 * 4^(i-1) + 4^(i-1) - 1) % 3 = (4^(i-1) - 1) % 3 = (4 - 1) % 3 = 0;
     * (2^(2i+1) -1) % 3 = (2 * 4^i - 1) % 3 = (4^i - 1 + 4^i) % 3 = 4^i % 3 != 0;
     */
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n - 1) % 3 == 0;
    }
}
