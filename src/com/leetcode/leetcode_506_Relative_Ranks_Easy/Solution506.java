package com.leetcode.leetcode_506_Relative_Ranks_Easy;

import java.util.*;

abstract class Solution506 {
    /**
     * Given scores of N athletes, find their relative ranks and
     * the people with the top three highest scores,
     * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
     * <p>N is a positive integer and won't exceed 10,000.
     * <p>All the scores of athletes are guaranteed to be unique.
     * @param nums eg. [5,4,3,2,1]
     * @return eg. ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
     */
    public abstract String[] findRelativeRanks(int[] nums);

    static Solution506 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution506 {
        @Override
        public String[] findRelativeRanks(int[] nums) {
            String[] top3 = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
            int[] sorted = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sorted);
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < sorted.length; i++) {
                map.put(sorted[i], sorted.length - i);
            }
            String[] res = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int rank = map.get(nums[i]);
                if (rank > 3) {
                    res[i] = String.valueOf(rank);
                } else {
                    res[i] = top3[rank - 1];
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution506 {
        @Override
        public String[] findRelativeRanks(int[] nums) {
            String[] top3 = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            int rank = nums.length;
            String[] res = new String[nums.length];
            for (int v : map.values()) {
                String r = rank > 3 ? String.valueOf(rank) : top3[rank - 1];
                res[v] = r;
                rank--;
            }
            return res;
        }
    }

    private static class S3 extends Solution506 {
        @Override
        public String[] findRelativeRanks(int[] nums) {
            String[] top3 = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
            Integer[] index = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                index[i] = i;
            }
            Arrays.sort(index, (x, y) -> nums[y] - nums[x]);
            String[] res = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                String rank = i > 2 ? String.valueOf(i + 1) : top3[i];
                res[index[i]] = rank;
            }
            return res;
        }
    }

    private static class S4 extends Solution506 {
        @Override
        public String[] findRelativeRanks(int[] nums) {
            String[] top3 = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            Arrays.sort(nums);
            String[] res = new String[nums.length];
            for (int r = nums.length; r > 0; r--) {
                String rank = r > 3 ? String.valueOf(r) : top3[r - 1];
                int index = map.get(nums[nums.length - r]);
                res[index] = rank;
            }
            return res;
        }
    }
}
