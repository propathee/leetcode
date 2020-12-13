package com.leetcode.leetcode_392_Is_Subsequence_Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Solution392 {
    public abstract boolean isSubsequence(String s, String t);

    static Solution392 newSolution() {
        return new S4();
    }

    static class S1 extends Solution392 {
        @Override
        public boolean isSubsequence(String s, String t) {
            int i = 0;
            for (int j = 0; i < s.length() && j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++;
                }
            }
            return i == s.length();
        }
    }

    static class S2 extends Solution392 {
        @Override
        public boolean isSubsequence(String s, String t) {
            int prev = 0;
            for (char c : s.toCharArray()) {
                prev = t.indexOf(c, prev);
                if (prev < 0) {
                    return false;
                }
                prev++;
            }
            return true;
        }
    }

    static class S3 extends Solution392 {
        @Override
        public boolean isSubsequence(String s, String t) {
            List<Integer>[] dict = new List[26];
            for (int i = 0; i < t.length(); i++) {
                int idx = t.charAt(i) - 'a';
                if (dict[idx] == null) {
                    dict[idx] = new ArrayList<>();
                }
                dict[idx].add(i);
            }
            int prev = 0;
            for (char c : s.toCharArray()) {
                List<Integer> indices = dict[c - 'a'];
                if (indices == null || indices.get(indices.size() - 1) < prev) {
                    return false;
                }
                for (int idx : indices) {
                    if (idx >= prev) {
                        prev = idx + 1;
                        break;
                    }
                }
            }
            return true;
        }
    }

    static class S4 extends Solution392 {
        @Override
        public boolean isSubsequence(String s, String t) {
            List<Integer>[] dict = new List[26];
            for (int i = 0; i < t.length(); i++) {
                int idx = t.charAt(i) - 'a';
                if (dict[idx] == null) {
                    dict[idx] = new ArrayList<>();
                }
                dict[idx].add(i);
            }
            int prev = 0;
            for (char c : s.toCharArray()) {
                List<Integer> indices = dict[c - 'a'];
                if (indices == null || indices.get(indices.size() - 1) < prev) {
                    return false;
                }
                int j = Collections.binarySearch(indices, prev);
                if (j < 0) {
                    j = -j - 1;
                }
                prev = indices.get(j) + 1;
            }
            return true;
        }
    }
}
