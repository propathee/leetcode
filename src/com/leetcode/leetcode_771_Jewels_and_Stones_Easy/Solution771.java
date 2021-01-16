package com.leetcode.leetcode_771_Jewels_and_Stones_Easy;

abstract class Solution771 {
    public abstract int numJewelsInStones(String jewels, String stones);

    static Solution771 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution771 {
        @Override
        public int numJewelsInStones(String jewels, String stones) {
            boolean[] dict = new boolean[128];
            for (char c : jewels.toCharArray()) {
                dict[c] = true;
            }
            int cnt = 0;
            for (char c : stones.toCharArray()) {
                if (dict[c]) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
