package com.leetcode.leetcode_90_Subsets_II_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Solution90 {
    public abstract List<List<Integer>> subsetsWithDup(int[] nums);

    static Solution90 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution90 {
        @Override
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            int start = 0;
            for (int i = 0; i < nums.length; i++) {
                int size = res.size();
                if (i == 0 || nums[i] != nums[i - 1]) {
                    start = 0;
                }
                for (int j = start; j < size; j++) {
                    List<Integer> subset = new ArrayList<>(res.get(j));
                    subset.add(nums[i]);
                    res.add(subset);
                }
                start = size;
            }
            return res;
        }
    }

    private static class S2 extends Solution90 {
        @Override
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            for (int i = 0; i < nums.length;) {
                int size = res.size(), cnt = 0;
                while (i + cnt < nums.length && nums[i] == nums[i + cnt]) {
                    cnt++;
                }
                for (int j = 0; j < size; j++) {
                    List<Integer> newElements = new ArrayList<>();
                    for (int k = 0; k < cnt; k++) {
                        newElements.add(nums[i]);
                        List<Integer> subset = new ArrayList<>(res.get(j));
                        subset.addAll(newElements);
                        res.add(subset);
                    }
                }
                i += cnt;
            }
            return res;
        }
    }

    private static class S3 extends Solution90 {
        private List<List<Integer>> res = new ArrayList<>();

        @Override
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            helper(new ArrayList<>(), nums, 0);
            return res;
        }

        private void helper(List<Integer> subset, int[] nums, int start) {
            res.add(new ArrayList<>(subset));
            for (int i = start; i < nums.length; i++) {
                if (i == start || nums[i] != nums[i - 1]) {
                    subset.add(nums[i]);
                    helper(subset, nums, i + 1);
                    subset.remove(subset.size() - 1);
                }
            }
        }
    }
}
