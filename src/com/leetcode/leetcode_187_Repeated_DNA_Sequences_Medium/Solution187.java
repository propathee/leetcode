package com.leetcode.leetcode_187_Repeated_DNA_Sequences_Medium;

import java.util.*;

abstract class Solution187 {
    public abstract List<String> findRepeatedDnaSequences(String s);

    static Solution187 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution187 {
        @Override
        public List<String> findRepeatedDnaSequences(String s) {
            Set<String> set = new HashSet<>();
            Set<String> res = new HashSet<>();
            for (int i = 0; i <= s.length() - 10; i++) {
                String seq = s.substring(i, i + 10);
                if (!set.add(seq)) {
                    res.add(seq);
                }
            }
            return new ArrayList<>(res);
        }
    }

    private static class S2 extends Solution187 {
        @Override
        public List<String> findRepeatedDnaSequences(String s) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i <= s.length() - 10; i++) {
                String seq = s.substring(i, i + 10);
                map.put(seq, map.getOrDefault(seq, 0) + 1);
            }
            List<String> res = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() > 1) {
                    res.add(entry.getKey());
                }
            }
            return res;
        }
    }

    private static class S3 extends Solution187 {
        @Override
        public List<String> findRepeatedDnaSequences(String s) {
            List<String> res = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            int[] dict = new int[26];
            dict['C' - 'A'] = 1;
            dict['G' - 'A'] = 2;
            dict['T' - 'A'] = 3;
            for (int i = 0; i <= s.length() - 10; i++) {
                int word = 0;
                for (int j = i; j < i + 10; j++) {
                    word <<= 2;
                    word |= dict[s.charAt(j) - 'A'];
                }
                int cnt = map.getOrDefault(word, 0);
                map.put(word, cnt + 1);
                if (cnt == 1) {
                    res.add(s.substring(i, i + 10));
                }
            }
            return res;
        }
    }

    private static class S4 extends Solution187 {
        @Override
        public List<String> findRepeatedDnaSequences(String s) {
            if (s.length() <= 10) {
                return new ArrayList<>();
            }
            List<String> res = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            int[] dict = new int[26];
            dict['C' - 'A'] = 1;
            dict['G' - 'A'] = 2;
            dict['T' - 'A'] = 3;
            int word = 0;
            int mask = (1 << 20) - 1;
            for (int i = 0; i < 9; i++) {
                word <<= 2;
                word |= dict[s.charAt(i) - 'A'];
            }
            for (int i = 9; i < s.length(); i++) {
                word <<= 2;
                word &= mask;
                word |= dict[s.charAt(i) - 'A'];
                int cnt = map.getOrDefault(word, 0);
                map.put(word, cnt + 1);
                if (cnt == 1) {
                    res.add(s.substring(i - 9, i + 1));
                }
            }
            return res;
        }
    }
}
