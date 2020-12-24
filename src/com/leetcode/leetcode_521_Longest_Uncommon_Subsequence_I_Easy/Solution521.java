package com.leetcode.leetcode_521_Longest_Uncommon_Subsequence_I_Easy;

abstract class Solution521 {
    public abstract int findLUSlength(String a, String b);

    static Solution521 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution521 {
        @Override
        public int findLUSlength(String a, String b) {
            return a.equals(b) ? -1 : Math.max(a.length(), b.length());
        }
    }
}
