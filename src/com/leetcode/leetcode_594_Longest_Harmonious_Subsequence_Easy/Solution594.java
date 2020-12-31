package com.leetcode.leetcode_594_Longest_Harmonious_Subsequence_Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

abstract class Solution594 {
    public abstract int findLHS(int[] nums);

    static Solution594 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution594 {
        @Override
        public int findLHS(int[] nums) {
            int max = 0;
            Arrays.sort(nums);
            int p = 0, q = 0;
            while (q < nums.length) {
                while (q < nums.length && nums[q] == nums[p]) {
                    q++;
                }
                if (q < nums.length) {
                    if (nums[q] == nums[p] + 1) {
                        int r = q;
                        while (r < nums.length && nums[r] == nums[q]) {
                            r++;
                        }
                        max = Math.max(r - p, max);
                    }
                    p = q;
                }
            }
            return max;
        }
    }

    private static class S2 extends Solution594 {
        @Override
        public int findLHS(int[] nums) {
            int max = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            for (int n : nums) {
                if (map.containsKey(n + 1)) {
                    max = Math.max(map.get(n) + map.get(n + 1), max);
                }
            }
            return max;
        }
    }

    private static class S3 extends Solution594 {
        @Override
        public int findLHS(int[] nums) {
            int max = 0;
            Arrays.sort(nums);
            for (int p = 0, q = 0; q < nums.length; q++) {
                if (nums[q] - nums[p] == 1) {
                    int r = q;
                    while (r < nums.length && nums[r] == nums[q]) {
                        r++;
                    }
                    max = Math.max(r - p, max);
                    p = q;
                } else if (nums[q] - nums[p] > 1) {
                    p = q;
                }
            }
            return max;
        }
    }
}
