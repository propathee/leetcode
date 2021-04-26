package com.leetcode.leetcode_139_Word_Break_Medium;

import java.util.*;

abstract class Solution139 {
    public abstract boolean wordBreak(String s, List<String> wordDict);

    static Solution139 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution139 {
        @Override
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict);
            List<Integer> segPoints = new ArrayList<>();
            segPoints.add(0);
            for (int i = 1; i <= s.length(); i++) {
                for (int j = segPoints.size() - 1; j >= 0; j--) {
                    String word = s.substring(segPoints.get(j), i);
                    if (dict.contains(word)) {
                        segPoints.add(i);
                        break;
                    }
                }
            }
            return segPoints.get(segPoints.size() - 1) == s.length();
        }
    }

    private static class S2 extends Solution139 {
        private Map<String, Boolean> memo = new HashMap<>();

        @Override
        public boolean wordBreak(String s, List<String> wordDict) {
            return helper(s, new HashSet<>(wordDict));
        }

        private boolean helper(String s, Set<String> dict) {
            if (s.length() == 0) {
                return true;
            } else if (memo.containsKey(s)) {
                return memo.get(s);
            }
            for (int i = 1; i <= s.length(); i++) {
                if (dict.contains(s.substring(0, i)) && helper(s.substring(i), dict)) {
                    memo.put(s, true);
                    return true;
                }
            }
            memo.put(s, false);
            return false;
        }
    }

    private static class S3 extends Solution139 {
        @Override
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (dp[j] && dict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }

    private static class S4 extends Solution139 {
        @Override
        public boolean wordBreak(String s, List<String> wordDict) {
            int len = s.length();
            boolean[] dp = new boolean[len + 1];
            dp[0] = true;
            for (int i = 0; i < len; i++) {
                if (dp[i]) {
                    for (String word : wordDict) {
                        if (len - i >= word.length() && s.substring(i).startsWith(word)) {
                            dp[i + word.length()] = true;
                        }
                    }
                }
            }
            return dp[len];
        }
    }
}
