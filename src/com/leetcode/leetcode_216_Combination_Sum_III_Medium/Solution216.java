package com.leetcode.leetcode_216_Combination_Sum_III_Medium;

import java.util.ArrayList;
import java.util.List;

abstract class Solution216 {
    public abstract List<List<Integer>> combinationSum3(int k, int n);

    static Solution216 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution216 {
        private List<List<Integer>> res = new ArrayList<>();

        @Override
        public List<List<Integer>> combinationSum3(int k, int n) {
            combinationSum(k, n, 1, new ArrayList<>());
            return res;
        }

        private void combinationSum(int k, int sum, int min, List<Integer> combination) {
            if (k == 1) {
                if (sum >= min && sum < 10) {
                    List<Integer> subCombination = new ArrayList<>(combination);
                    subCombination.add(sum);
                    res.add(new ArrayList<>(subCombination));
                }
            } else {
                if (sum <= min * k) {
                    return;
                }
                for (int i = min; i < 10; i++) {
                    combination.add(i);
                    combinationSum(k-1, sum-i, i+1, combination);
                    combination.remove(combination.size() - 1);
                }
            }
        }
    }

    private static class S2 extends Solution216 {
        private List<List<Integer>> res = new ArrayList<>();

        @Override
        public List<List<Integer>> combinationSum3(int k, int n) {
            combinationSum(k, n, 1, new ArrayList<>());
            return res;
        }

        private void combinationSum(int k, int sum, int min, List<Integer> combination) {
            if (combination.size() > k) {
                return;
            }
            if (combination.size() == k && sum == 0) {
                res.add(new ArrayList<>(combination));
                return;
            }
            for (int i = min; i < 10; i++) {
                if (sum < i) {
                    break;
                } else {
                    combination.add(i);
                    combinationSum(k, sum-i, i+1, combination);
                    combination.remove(combination.size() - 1);
                }
            }
        }
    }
}
