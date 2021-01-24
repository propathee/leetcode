package com.leetcode.leetcode_821_Shortest_Distance_to_a_Character_Easy;

import java.util.ArrayList;
import java.util.List;

abstract class Solution821 {
    public abstract int[] shortestToChar(String S, char C);

    static Solution821 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution821 {
        @Override
        public int[] shortestToChar(String S, char C) {
            List<Integer> indices = new ArrayList<>();
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == C) {
                    indices.add(i);
                }
            }
            int[] res = new int[S.length()];
            for (int i = 1; i < indices.size(); i++) {
                int p = indices.get(i - 1), q = indices.get(i);
                for (int j = p + 1; j < q; j++) {
                    res[j] = Math.min(j - p, q - j);
                }
            }
            for (int i = 0; i < indices.get(0); i++) {
                res[i] = indices.get(0) - i;
            }
            for (int i = indices.get(indices.size() - 1); i < S.length(); i++) {
                res[i] = i - indices.get(indices.size() - 1);
            }
            return res;
        }
    }

    private static class S2 extends Solution821 {
        @Override
        public int[] shortestToChar(String S, char C) {
            int[] res = new int[S.length()];
            int idx = -res.length;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == C) {
                    idx = i;
                } else {
                    res[i] = i - idx;
                }
            }
            for (int i = S.length() - 1; i >= 0; i--) {
                if (S.charAt(i) == C) {
                    idx = i;
                } else {
                    res[i] = Math.min(res[i], idx - i);
                }
            }
            return res;
        }
    }

    private static class S3 extends Solution821 {
        @Override
        public int[] shortestToChar(String S, char C) {
            int[] res = new int[S.length()];
            for (int i = 0; i < res.length; i++) {
                if (S.charAt(i) != C) {
                    res[i] = Integer.MAX_VALUE;
                }
            }
            for (int i = 0; i < res.length - 1; i++) {
                if (res[i] != Integer.MAX_VALUE) {
                    res[i + 1] = Math.min(res[i + 1], res[i] + 1);
                }
            }
            for (int i = res.length - 1; i > 0; i--) {
                res[i - 1] = Math.min(res[i - 1], res[i] + 1);
            }
            return res;
        }
    }

    private static class S4 extends Solution821 {
        @Override
        public int[] shortestToChar(String S, char C) {
            int[] res = new int[S.length()];
            int p = -res.length;
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == C) {
                    for (int j = Math.max(p, 0); j < i; j++) {
                        res[j] = Math.min(j - p, i - j);
                    }
                    p = i;
                }
            }
            for (int i = p + 1; i < S.length(); i++) {
                res[i] = i - p;
            }
            return res;
        }
    }
}
