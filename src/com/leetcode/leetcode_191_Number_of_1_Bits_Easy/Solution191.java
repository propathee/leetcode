package com.leetcode.leetcode_191_Number_of_1_Bits_Easy;

public class Solution191 {
    // you need to treat n as an unsigned value
    public int hammingWeight_1(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                cnt++;
            }
            n >>= 1;
        }
        return cnt;
    }

    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += (n & 1);
            n >>>= 1;
        }
        return cnt;
    }
}
