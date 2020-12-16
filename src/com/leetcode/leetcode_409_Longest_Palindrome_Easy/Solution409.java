package com.leetcode.leetcode_409_Longest_Palindrome_Easy;

import java.util.HashSet;
import java.util.Set;

public abstract class Solution409 {
    /**
     * Given a string s which consists of lowercase or uppercase letters,
     * return the length of the longest palindrome that can be built with those letters.
     * <p>
     * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
     */
    public abstract int longestPalindrome(String s);

    static Solution409 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution409 {
        @Override
        public int longestPalindrome(String s) {
            int res = 0;
            boolean[] dict = new boolean[128];
            for (char c : s.toCharArray()) {
                if (dict[c]) {
                    res += 2;
                    dict[c] = false;
                } else {
                    dict[c] = true;
                }
            }
            for (boolean bool : dict) {
                if (bool) {
                    res++;
                    break;
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution409 {
        @Override
        public int longestPalindrome(String s) {
            int res = 0;
            boolean[] dict = new boolean[128];
            for (char c : s.toCharArray()) {
                dict[c] = !dict[c];
                if (!dict[c]) {
                    res += 2;
                }
            }
            return res == s.length() ? res : res + 1;
        }
    }

    private static class S3 extends Solution409 {
        @Override
        public int longestPalindrome(String s) {
            int res = 0;
            Set<Character> set = new HashSet<>();
            for (char c : s.toCharArray()) {
                if (set.contains(c)) {
                    set.remove(c);
                    res += 2;
                } else {
                    set.add(c);
                }
            }
            return set.isEmpty() ? res : res + 1;
        }
    }
}
