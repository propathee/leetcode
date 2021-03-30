package com.leetcode.leetcode_89_Gray_Code_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Solution89 {
    public abstract List<Integer> grayCode(int n);

    static Solution89 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution89 {
        @Override
        public List<Integer> grayCode(int n) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            for (int i = 0; i < n; i++) {
                int increment = 1 << i;
                int size = res.size();
                for (int j = size - 1; j >= 0; j--) {
                    res.add(res.get(j) + increment);
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution89 {
        @Override
        public List<Integer> grayCode(int n) {
            if (n == 0) {
                return new ArrayList<>(Arrays.asList(0));
            }
            List<Integer> codes = grayCode(n - 1);
            int size = codes.size();
            int increment = 1 << (n - 1);
            for (int i = size - 1; i >= 0; i--) {
                codes.add(codes.get(i) + increment);
            }
            return codes;
        }
    }

    private static class S3 extends Solution89 {
        @Override
        public List<Integer> grayCode(int n) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            for (int i = 1; i < (1 << n); i++) {
                res.add(res.get(res.size() - 1) + (i & -i));
            }
            return res;
        }
    }

    private static class S4 extends Solution89 {
        @Override
        public List<Integer> grayCode(int n) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < (1 << n); i++) {
                res.add(i ^ (i >> 1));
            }
            return res;
        }
    }
}
