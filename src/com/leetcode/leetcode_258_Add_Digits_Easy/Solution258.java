package com.leetcode.leetcode_258_Add_Digits_Easy;

public class Solution258 {
    public int addDigits_1(int num) {
        int n = num;
        while (n >= 10) {
            int n2 = 0;
            while (n >= 10) {
                n2 += (n % 10);
                n /= 10;
            }
            n += n2;
        }
        return n;
    }

    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        if (num % 9 == 0) {
            return 9;
        }
        return num % 9;
    }
}
