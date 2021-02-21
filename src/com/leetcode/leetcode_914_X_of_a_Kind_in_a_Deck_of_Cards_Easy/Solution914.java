package com.leetcode.leetcode_914_X_of_a_Kind_in_a_Deck_of_Cards_Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class Solution914 {
    public abstract boolean hasGroupsSizeX(int[] deck);

    static Solution914 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution914 {
        @Override
        public boolean hasGroupsSizeX(int[] deck) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int num : deck) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
            Set<Integer> nums = new HashSet<>();
            int min = Integer.MAX_VALUE;
            for (Integer cnt : counts.values()) {
                nums.add(cnt);
                min = Math.min(min, cnt);
            }
            return computeGreatestCommonDivisor(nums, min) >= 2;
        }

        private int computeGreatestCommonDivisor(Set<Integer> nums, int min) {
            for (int i = min; i > 1; i--) {
                if (isAllExactDivided(nums, i)) {
                    return i;
                }
            }
            return 1;
        }

        private boolean isAllExactDivided(Set<Integer> nums, int divisor) {
            for (int num : nums) {
                if (num % divisor != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class S2 extends Solution914 {
        @Override
        public boolean hasGroupsSizeX(int[] deck) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int num : deck) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
            int groupSize = 0;
            for (int cnt : counts.values()) {
                groupSize = computeGreatestCommonDivisor(cnt, groupSize);
            }
            return groupSize >= 2;
        }

        private int computeGreatestCommonDivisor(int a, int b) {
            return b == 0 ? a : computeGreatestCommonDivisor(b, a % b);
        }
    }

    private static class S3 extends Solution914 {
        @Override
        public boolean hasGroupsSizeX(int[] deck) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int num : deck) {
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
            int groupSize = 0;
            for (int cnt : counts.values()) {
                groupSize = computeGreatestCommonDivisor(cnt, groupSize);
            }
            return groupSize >= 2;
        }

        private int computeGreatestCommonDivisor(int a, int b) {
            int mod;
            while (b > 0) {
                mod = a % b;
                a = b;
                b = mod;
            }
            return a;
        }
    }

    private static class S4 extends Solution914 {
        @Override
        public boolean hasGroupsSizeX(int[] deck) {
            int[] counts = new int[10000];
            for (int num : deck) {
                counts[num]++;
            }
            int groupSize = 0;
            for (int cnt : counts) {
                if (cnt > 0) {
                    if (cnt == 1) {
                        return false;
                    }
                    groupSize = computeGreatestCommonDivisor(cnt, groupSize);
                    if (groupSize < 2) {
                        return false;
                    }
                }
            }
            return true;
        }

        private int computeGreatestCommonDivisor(int a, int b) {
            return b == 0 ? a : computeGreatestCommonDivisor(b, a % b);
        }
    }
}
