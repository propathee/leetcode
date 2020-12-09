package com.leetcode.leetcode_326_Power_of_Three_Easy;

public class Solution326 {
    public boolean isPowerOfThree_1(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }

    public boolean isPowerOfThree_2(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree(int n) {
        return n > 0 && (n == 1 || n % 3 == 0 && isPowerOfThree(n / 3));
    }
}
