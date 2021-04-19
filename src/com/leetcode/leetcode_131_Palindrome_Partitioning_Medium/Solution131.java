package com.leetcode.leetcode_131_Palindrome_Partitioning_Medium;

import java.util.ArrayList;
import java.util.List;

abstract class Solution131 {
    public abstract List<List<String>> partition(String s);

    static Solution131 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution131 {
        @Override
        public List<List<String>> partition(String s) {
            List<List<String>> results = new ArrayList<>();
            if (s.isEmpty()) {
                results.add(new ArrayList<>());
            } else if (s.length() == 1) {
                List<String> res = new ArrayList<>();
                res.add(s);
                results.add(res);
            } else {
                for (int i = 1; i <= s.length(); i++) {
                    String prefix = s.substring(0, i);
                    if (isPalindrome(prefix)) {
                        List<List<String>> subResults = partition(s.substring(i));
                        for (List<String> subRes : subResults) {
                            subRes = new ArrayList<>(subRes);
                            subRes.add(0, prefix);
                            results.add(subRes);
                        }
                    }
                }
            }
            return results;
        }

        private boolean isPalindrome(String s) {
            if (s.length() == 1) {
                return true;
            }
            for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
                if (s.charAt(l) != s.charAt(r)) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class S2 extends Solution131 {
        private List<List<String>> results = new ArrayList<>();

        @Override
        public List<List<String>> partition(String s) {
            backtrack(s, 0, new ArrayList<>());
            return results;
        }

        public void backtrack(String s, int idx, List<String> subResult) {
            if (idx == s.length()) {
                results.add(new ArrayList<>(subResult));
            } else {
                for (int i = idx; i < s.length(); i++) {
                    if (isPalindrome(s, idx, i)) {
                        subResult.add(s.substring(idx, i + 1));
                        backtrack(s, i + 1, subResult);
                        subResult.remove(subResult.size() - 1);
                    }
                }
            }
        }

        private boolean isPalindrome(String s, int l, int r) {
            while (l < r) {
                if (s.charAt(l++) != s.charAt(r--)) {
                    return false;
                }
            }
            return true;
        }
    }
}
