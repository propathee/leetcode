package com.leetcode.leetcode_290_Word_Pattern_Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution290 {
    public boolean wordPattern_1(String pattern, String s) {
        String[] items = s.split(" ");
        if (pattern.length() != items.length) {
            return false;
        }
        String[] dict = new String[26];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (dict[c - 'a'] == null) {
                if (!set.add(items[i])) {
                    return false;
                }
                dict[c - 'a'] = items[i];
            } else {
                if (!dict[c - 'a'].equals(items[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            if (map.put(pattern.charAt(i), i) != map.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }
}
