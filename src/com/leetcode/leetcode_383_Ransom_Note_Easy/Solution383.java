package com.leetcode.leetcode_383_Ransom_Note_Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class Solution383 {
    /**
     * You may assume that both strings contain only lowercase letters.
     */
    public abstract boolean canConstruct(String ransomNote, String magazine);

    static Solution383 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution383 {
        @Override
        public boolean canConstruct(String ransomNote, String magazine) {
            char[] target = ransomNote.toCharArray();
            char[] source = magazine.toCharArray();
            Arrays.sort(target);
            Arrays.sort(source);
            int i = 0;
            for (int j = 0; i < target.length && j < source.length;) {
                if (target[i] < source[j]) {
                    return false;
                } else if (target[i] > source[j]) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
            return i == target.length;
        }
    }

    private static class S2 extends Solution383 {
        @Override
        public boolean canConstruct(String ransomNote, String magazine) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : magazine.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (char c : ransomNote.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) - 1);
                if (map.get(c) < 0) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class S3 extends Solution383 {
        @Override
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] dict = new int[26];
            for (char c : magazine.toCharArray()) {
                dict[c - 'a']++;
            }
            for (char c : ransomNote.toCharArray()) {
                if (--dict[c - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
