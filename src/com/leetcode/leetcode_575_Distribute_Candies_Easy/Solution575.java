package com.leetcode.leetcode_575_Distribute_Candies_Easy;

import java.util.HashSet;
import java.util.Set;

abstract class Solution575 {
    public abstract int distributeCandies(int[] candyType);

    static Solution575 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution575 {
        @Override
        public int distributeCandies(int[] candyType) {
            int maxTypes = candyType.length / 2;
            Set<Integer> set = new HashSet<>();
            for (int type : candyType) {
                if (set.add(type)) {
                    if (set.size() >= maxTypes) {
                        break;
                    }
                }
            }
            return set.size();
        }
    }

    private static class S2 extends Solution575 {
        @Override
        public int distributeCandies(int[] candyType) {
            Set<Integer> set = new HashSet<>();
            for (int type : candyType) {
                set.add(type);
            }
            return Math.min(set.size(), candyType.length / 2);
        }
    }

    private static class S3 extends Solution575 {
        @Override
        public int distributeCandies(int[] candyType) {
            int[] dict = new int[200001];
            int types = 0;
            for (int type : candyType) {
                if (dict[type + 100000]++ == 0) {
                    types++;
                    if (types >= candyType.length / 2) {
                        break;
                    }
                }
            }
            return types;
        }
    }

    private static class S4 extends Solution575 {
        @Override
        public int distributeCandies(int[] candyType) {
            int[] dict = new int[200001];
            int types = 0;
            for (int type : candyType) {
                if (dict[type + 100000]++ == 0) {
                    types++;
                }
            }
            return Math.min(types, candyType.length / 2);
        }
    }

    private static class S5 extends Solution575 {
        @Override
        public int distributeCandies(int[] candyType) {
            boolean[] dict = new boolean[200001];
            int types = 0;
            for (int type : candyType) {
                if (!dict[type + 100000]) {
                    types++;
                    dict[type + 100000] = true;
                }
            }
            return Math.min(types, candyType.length / 2);
        }
    }
}
