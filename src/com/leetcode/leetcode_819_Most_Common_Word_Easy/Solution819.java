package com.leetcode.leetcode_819_Most_Common_Word_Easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

abstract class Solution819 {
    public abstract String mostCommonWord(String paragraph, String[] banned);

    static Solution819 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution819 {
        @Override
        public String mostCommonWord(String paragraph, String[] banned) {
            Map<String, Integer> counts = new HashMap<>();
            for (String word : banned) {
                counts.put(word, -1000);
            }
            int maxCnt = 0;
            String res = null;
            StringBuilder sb = new StringBuilder();
            for (char c : (paragraph + ".").toLowerCase().toCharArray()) {
                if (c == ' ' || c == '!' || c == '?' || c == '\'' || c == ',' || c == ';' || c == '.') {
                    if (sb.length() != 0) {
                        String word = sb.toString();
                        sb = new StringBuilder();

                        int cnt = counts.getOrDefault(word, 0) + 1;
                        counts.put(word, cnt);
                        if (cnt > maxCnt) {
                            maxCnt = cnt;
                            res = word;
                        }
                    }
                } else {
                    sb.append(c);
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution819 {
        @Override
        public String mostCommonWord(String paragraph, String[] banned) {
            Map<String, Integer> counts = new HashMap<>();
            for (String word : banned) {
                counts.put(word, -1000);
            }
            int maxCnt = 0;
            String res = null;
            for (String word : paragraph.toLowerCase().split("[ !?',;.]+")) {
                int cnt = counts.getOrDefault(word, 0) + 1;
                counts.put(word, cnt);
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    res = word;
                }
            }
            return res;
        }
    }

    private static class S3 extends Solution819 {
        @Override
        public String mostCommonWord(String paragraph, String[] banned) {
            Map<String, Integer> counts = new HashMap<>();
            for (String word : banned) {
                counts.put(word, -1000);
            }
            for (String word : paragraph.toLowerCase().replaceAll("\\W+", " ").split("\\s+")) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
            return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
        }
    }

    private static class S4 extends Solution819 {
        @Override
        public String mostCommonWord(String paragraph, String[] banned) {
            Map<String, Integer> counts = new HashMap<>();
            for (String word : paragraph.toLowerCase().split("[ ?!',;.]+")) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
            for (String word : banned) {
                counts.remove(word);
            }
            int maxCnt = 0;
            String res = null;
            for (Map.Entry<String, Integer> entry : counts.entrySet()) {
                if (entry.getValue() > maxCnt) {
                    maxCnt = entry.getValue();
                    res = entry.getKey();
                }
            }
            return res;
        }
    }
}
