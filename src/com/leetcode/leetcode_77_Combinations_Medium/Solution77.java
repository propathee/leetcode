package com.leetcode.leetcode_77_Combinations_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Solution77 {
    public abstract List<List<Integer>> combine(int n, int k);

    static Solution77 newSolution() {
        return new S6();
    }

    private static class S1 extends Solution77 {
        @Override
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            res.addAll(doCombine(1, n, k));
            return res;
        }

        private List<List<Integer>> doCombine(int start, int end, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (k == 1) {
                for (int i = start; i <= end; i++) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    res.add(list);
                }
            } else {
                for (int i = start; i <= end - k + 1; i++) {
                    List<List<Integer>> combinations = doCombine(i + 1, end, k - 1);
                    for (List<Integer> cmb : combinations) {
                        cmb.add(i);
                        res.add(cmb);
                    }
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution77 {
        private List<List<Integer>> res = new ArrayList<>();

        @Override
        public List<List<Integer>> combine(int n, int k) {
            doCombine(new ArrayList<>(), 1, n, k);
            return res;
        }

        private void doCombine(List<Integer> combination, int start, int end, int k) {
            if (k == 0) {
                res.add(new ArrayList<>(combination));
                return;
            }
            for (int i = start; i <= end - k + 1; i++) {
                combination.add(i);
                doCombine(combination, i + 1, end, k - 1);
                combination.remove(combination.size() - 1);
            }
        }
    }

    private static class S3 extends Solution77 {
        @Override
        public List<List<Integer>> combine(int n, int k) {
            if (k == n || k == 0) {
                List<Integer> cmb = new ArrayList<>();
                for (int i = 1; i <= k; i++) {
                    cmb.add(i);
                }
                return new ArrayList<>(Arrays.asList(cmb));
            } else {
                List<List<Integer>> combinations = combine(n - 1, k - 1);
                combinations.forEach(cmb -> cmb.add(n));
                combinations.addAll(combine(n - 1, k));
                return combinations;
            }
        }
    }

    private static class S4 extends Solution77 {
        @Override
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (k == 0) {
                res.add(new ArrayList<>());
                return res;
            }
            for (int i = k; i <= n; i++) {
                List<List<Integer>> combinations = combine(i - 1, k - 1);
                for (List<Integer> cmb : combinations) {
                    cmb.add(i);
                    res.add(cmb);
                }
            }
            return res;
        }
    }

    private static class S5 extends Solution77 {
        @Override
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            for (int i = 0; i < k; i++) {
                List<List<Integer>> combinations = res;
                res = new ArrayList<>();
                for (List<Integer> cmb : combinations) {
                    int end = cmb.isEmpty() ? n + 1 : cmb.get(0);
                    for (int j = 1; j < end; j++) {
                        List<Integer> newCmb = new ArrayList<>(cmb);
                        newCmb.add(0, j);
                        res.add(newCmb);
                    }
                }
            }
            return res;
        }
    }

    private static class S6 extends Solution77 {
        @Override
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            Integer[] cur = new Integer[k];
            for (int i = 0; i < k; i++) {
                cur[i] = 0;
            }
            int i = 0;
            while (i >= 0) {
                cur[i]++;
                if (cur[i] > n) {
                    i--;
                } else if (i == k - 1) {
                    res.add(new ArrayList<>(Arrays.asList(cur)));
                } else {
                    i++;
                    cur[i] = cur[i - 1];
                }
            }
            return res;
        }
    }
}
