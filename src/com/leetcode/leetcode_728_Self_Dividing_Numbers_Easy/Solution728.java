package com.leetcode.leetcode_728_Self_Dividing_Numbers_Easy;

import java.util.ArrayList;
import java.util.List;

abstract class Solution728 {
    /**
     * 1 <= left <= right <= 10000
     */
    public abstract List<Integer> selfDividingNumbers(int left, int right);

    static Solution728 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution728 {
        @Override
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> res = new ArrayList<>();
            for (int num = left; num <= right; num++) {
                int n = num;
                while (n > 0) {
                    int digit = n % 10;
                    if (digit == 0 || num % digit != 0) {
                        break;
                    }
                    n /= 10;
                }
                if (n == 0) {
                    res.add(num);
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution728 {
        @Override
        public List<Integer> selfDividingNumbers(int left, int right) {
            List<Integer> res = new ArrayList<>();
            for (int num = left; num <= right; num++) {
                int n = num;
                for (; n > 0; n /= 10) {
                    int digit = n % 10;
                    if (digit == 0 || num % digit != 0) {
                        break;
                    }
                }
                if (n == 0) {
                    res.add(num);
                }
            }
            return res;
        }
    }
}
