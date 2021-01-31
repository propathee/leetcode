package com.leetcode.leetcode_859_Buddy_Strings_Easy;

import java.util.ArrayList;
import java.util.List;

abstract class Solution859 {
    public abstract boolean buddyStrings(String A, String B);

    static Solution859 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution859 {
        @Override
        public boolean buddyStrings(String A, String B) {
            if (A.length() != B.length()) {
                return false;
            }
            int i = -1;
            int cnt = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(j)) {
                    if (++cnt > 2) {
                        return false;
                    }
                    if (cnt == 1) {
                        i = j;
                    } else {
                        if (A.charAt(i) != B.charAt(j) || A.charAt(j) != B.charAt(i)) {
                            return false;
                        }
                    }
                }
            }
            return cnt == 2 || (cnt == 0 && hasDuplicateChar(A));
        }

        private boolean hasDuplicateChar(String s) {
            int[] counts = new int[26];
            for (char c : s.toCharArray()) {
                if (++counts[c - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }
    }

    private static class S2 extends Solution859 {
        @Override
        public boolean buddyStrings(String A, String B) {
            if (A.length() != B.length()) {
                return false;
            }
            List<Integer> diffs = new ArrayList<>();
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    diffs.add(i);
                }
            }
            return (diffs.size() == 0 && hasDuplicateChar(A))
                || (diffs.size() == 2 && A.charAt(diffs.get(0)) == B.charAt(diffs.get(1))
                    && B.charAt(diffs.get(0)) == A.charAt(diffs.get(1)));
        }

        private boolean hasDuplicateChar(String s) {
            int[] counts = new int[26];
            for (char c : s.toCharArray()) {
                if (++counts[c - 'a'] > 1) {
                    return true;
                }
            }
            return false;
        }
    }
}
