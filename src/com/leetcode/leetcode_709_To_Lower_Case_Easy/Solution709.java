package com.leetcode.leetcode_709_To_Lower_Case_Easy;

abstract class Solution709 {
    public abstract String toLowerCase(String str);

    static Solution709 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution709 {
        @Override
        public String toLowerCase(String str) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 'A' && chars[i] <= 'Z') {
                    chars[i] += 32;
                }
            }
            return new String(chars);
        }
    }
}
