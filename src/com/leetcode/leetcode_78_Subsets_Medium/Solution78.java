package com.leetcode.leetcode_78_Subsets_Medium;

import java.util.ArrayList;
import java.util.List;

abstract class Solution78 {
    public abstract List<List<Integer>> subsets(int[] nums);

    static Solution78 newSolution() {
        return new S6();
    }

    private static class S1 extends Solution78 {
        @Override
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int n = nums.length;
            for (int i = 0; i < (1 << n); i++) {
                List<Integer> subSet = new ArrayList<>();
                for (int j = 0, mask = 1; j < n; j++, mask <<= 1) {
                    if ((i & mask) != 0) {
                        subSet.add(nums[j]);
                    }
                }
                res.add(subSet);
            }
            return res;
        }
    }

    private static class S2 extends Solution78 {
        private List<List<Integer>> res = new ArrayList<>();

        @Override
        public List<List<Integer>> subsets(int[] nums) {
            subset(new ArrayList<>(), nums, 0);
            return res;
        }

        private void subset(List<Integer> subSet, int[] nums, int start) {
            if (start == nums.length) {
                res.add(subSet);
                return;
            }
            subset(new ArrayList<>(subSet), nums, start + 1);
            subSet.add(nums[start]);
            subset(subSet, nums, start + 1);
        }
    }

    private static class S3 extends Solution78 {
        private List<List<Integer>> res = new ArrayList<>();

        @Override
        public List<List<Integer>> subsets(int[] nums) {
            backtrack(new ArrayList<>(), nums, 0);
            return res;
        }

        private void backtrack(List<Integer> subSet, int[] nums, int start) {
            if (start == nums.length) {
                res.add(new ArrayList<>(subSet));
                return;
            }
            subSet.add(nums[start]);
            backtrack(subSet, nums, start + 1);
            subSet.remove(subSet.size() - 1);
            backtrack(subSet, nums, start + 1);
        }
    }

    private static class S4 extends Solution78 {
        private List<List<Integer>> res = new ArrayList<>();

        @Override
        public List<List<Integer>> subsets(int[] nums) {
            backtrack(new ArrayList<>(), nums, 0);
            return res;
        }

        private void backtrack(List<Integer> subSet, int[] nums, int start) {
            res.add(new ArrayList<>(subSet));
            for (int i = start; i < nums.length; i++) {
                subSet.add(nums[i]);
                backtrack(subSet, nums, i + 1);
                subSet.remove(subSet.size() - 1);
            }
        }
    }

    private static class S5 extends Solution78 {
        @Override
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            for (int n : nums) {
                int size = res.size();
                for (int j = 0; j < size; j++) {
                    List<Integer> subSet = new ArrayList<>(res.get(j));
                    subSet.add(n);
                    res.add(subSet);
                }
            }
            return res;
        }
    }

    private static class S6 extends Solution78 {
        @Override
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            helper(res, nums, 0);
            return res;
        }

        private void helper(List<List<Integer>> subSets, int[] nums, int start) {
            if (start == nums.length) {
                return;
            }
            int size = subSets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subSet = new ArrayList<>(subSets.get(i));
                subSet.add(nums[start]);
                subSets.add(subSet);
            }
            helper(subSets, nums, start + 1);
        }
    }
}
