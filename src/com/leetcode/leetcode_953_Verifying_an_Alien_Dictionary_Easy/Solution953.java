package com.leetcode.leetcode_953_Verifying_an_Alien_Dictionary_Easy;

abstract  class Solution953 {
    public abstract boolean isAlienSorted(String[] words, String order);

    static Solution953 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution953 {
        @Override
        public boolean isAlienSorted(String[] words, String order) {
            int[] dict = new int[26];
            for (int i = 0; i < order.length(); i++) {
                dict[order.charAt(i) - 'a'] = i;
            }
            for (int i = 1; i < words.length; i++) {
                if (compare(words[i], words[i - 1], dict) < 0) {
                    return false;
                }
            }
            return true;
        }

        private int compare(String s1, String s2, int[] dict) {
            int commonLen = Math.min(s1.length(), s2.length());
            for (int j = 0; j < commonLen; j++) {
                int diff = dict[s1.charAt(j) - 'a'] - dict[s2.charAt(j) - 'a'];
                if (diff != 0) {
                    return diff;
                }
            }
            return s1.length() - s2.length();
        }
    }
}
