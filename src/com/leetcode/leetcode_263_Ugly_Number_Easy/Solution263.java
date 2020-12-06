package com.leetcode.leetcode_263_Ugly_Number_Easy;

public class Solution263 {
    public boolean isUgly_1(int num) {
        while (num > 1) {
            num = deal(num);
        }
        return num == 1;
    }

    private int deal(int num) {
        if (num % 2 == 0) {
            return num / 2;
        } else if (num % 3 == 0) {
            return num / 3;
        } else if (num % 5 == 0) {
            return num / 5;
        } else {
            return -1;
        }
    }

    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
