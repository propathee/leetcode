package com.leetcode.leetcode_884_Uncommon_Words_from_Two_Sentences_Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Solution884 {
    public abstract String[] uncommonFromSentences(String A, String B);

    static Solution884 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution884 {
        @Override
        public String[] uncommonFromSentences(String A, String B) {
            Map<String, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
            for (String w : A.split(" ")) {
                map1.put(w, map1.getOrDefault(w, 0) + 1);
            }
            for (String w : B.split(" ")) {
                map2.put(w, map2.getOrDefault(w, 0) + 1);
            }
            List<String> words = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map1.entrySet()) {
                if (entry.getValue() == 1 && !map2.containsKey(entry.getKey())) {
                    words.add(entry.getKey());
                }
            }
            for (Map.Entry<String, Integer> entry : map2.entrySet()) {
                if (entry.getValue() == 1 && !map1.containsKey(entry.getKey())) {
                    words.add(entry.getKey());
                }
            }
            String[] res = new String[words.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = words.get(i);
            }
            return res;
        }
    }

    private static class S2 extends Solution884 {
        @Override
        public String[] uncommonFromSentences(String A, String B) {
            Map<String, Integer> map = new HashMap<>();
            for (String w : A.split(" ")) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
            for (String w : B.split(" ")) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
            List<String> words = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    words.add(entry.getKey());
                }
            }
            return words.toArray(new String[0]);
        }
    }

    private static class S3 extends Solution884 {
        @Override
        public String[] uncommonFromSentences(String A, String B) {
            Map<String, Integer> map = new HashMap<>();
            for (String w : (A + " " + B).split(" ")) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
            List<String> words = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    words.add(entry.getKey());
                }
            }
            return words.toArray(new String[0]);
        }
    }
}
