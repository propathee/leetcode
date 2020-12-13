package com.leetcode.leetcode_387_First_Unique_Character_in_a_String_Easy;

import java.util.HashMap;
import java.util.Map;

public abstract class Solution387 {
    /**
     * Given a string, find the first non-repeating character in it and return its index.
     * <p>If it doesn't exist, return -1.
     * @param s You may assume the string contains only lowercase English letters.
     */
    public abstract int firstUniqChar(String s);

    static Solution387 newSolution() {
        return new S3();
    }

    static class S1 extends Solution387 {
        @Override
        public int firstUniqChar(String s) {
            int[] dict = new int[26];
            for (char c : s.toCharArray()) {
                dict[c - 'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (dict[s.charAt(i) - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    static class S2 extends Solution387 {
        @Override
        public int firstUniqChar(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    static class S3 extends Solution387 {
        @Override
        public int firstUniqChar(String s) {
            for (int i = 0; i < s.length(); i++) {
                if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                    return i;
                }
            }
            return -1;
        }
    }
}
