package com.leetcode.leetcode_242_Valid_Anagram_Easy;

import java.util.HashMap;
import java.util.Map;

public class Solution242 {
    public boolean isAnagram_1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (char c : s.toCharArray()) {
            table[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            table[c - 'a']--;
        }
        for (int cnt : table) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (Integer cnt : map.values()) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}
