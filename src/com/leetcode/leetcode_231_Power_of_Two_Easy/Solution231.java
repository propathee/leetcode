package com.leetcode.leetcode_231_Power_of_Two_Easy;

public class Solution231 {
    public boolean isPowerOfTwo_1(int n) {
        if (n < 1) {
            return false;
        }
        while (n > 2) {
            if (n % 2 > 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }

    public boolean isPowerOfTwo_2(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }

    public boolean isPowerOfTwo_3(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwo_4(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n == 1 || (n % 2 == 0 && isPowerOfTwo(n / 2)));
    }
}
