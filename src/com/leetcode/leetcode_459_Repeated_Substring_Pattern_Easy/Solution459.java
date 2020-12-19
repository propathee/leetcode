package com.leetcode.leetcode_459_Repeated_Substring_Pattern_Easy;

import java.util.Arrays;

abstract class Solution459 {
    /**
     * Given a non-empty string check if it can be constructed by taking a substring of it
     * and appending multiple copies of the substring together.
     * You may assume the given string consists of lowercase English letters only and
     * its length will not exceed 10000.
     */
    public abstract boolean repeatedSubstringPattern(String s);

    static Solution459 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution459 {
        @Override
        public boolean repeatedSubstringPattern(String s) {
            for (int n = s.length(); n > 1; n--) {
                if (s.length() % n != 0) {
                    continue;
                }
                int pLen = s.length() / n;
                String pattern = s.substring(0, pLen);
                int start;
                for (start = pLen; start < s.length(); start += pLen) {
                    String subStr = s.substring(start, start + pLen);
                    if (!pattern.equals(subStr)) {
                        break;
                    }
                }
                if (start == s.length()) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * S = Sa+Sb = Sb+Sa -> Sb starts with Sa and Sb ends with Sa
     * -> suppose Sb = Sa+Sc+Sa, we have Sa + Sa+Sc+Sa = Sa+Sc+Sa + Sa
     * -> Sa+Sc = Sc+Sa -> ... ... -> finally Sa+Sn = Sn+Sa and Sn = Sa
     * -> S = Sa+Sb is a multiple copies of Sa.
     */
    private static class S2 extends Solution459 {
        @Override
        public boolean repeatedSubstringPattern(String s) {
            return (s + s).substring(1, s.length() * 2 - 1).contains(s);
        }
    }

    // dp stores the previous index of this char: s.charAt(dp[x]) = s.charAt(x)
    // if i mismatch, try dp[i-1] + 1
    private static class S3 extends Solution459 {
        @Override
        public boolean repeatedSubstringPattern(String s) {
            int pIndex = 0;
            int sIndex = 1;
            int[] dp = new int[s.length()];
            Arrays.fill(dp, -1);
            while (sIndex < s.length()) {
                if (s.charAt(sIndex) == s.charAt(pIndex)) {
                    dp[sIndex++] = pIndex++;
                } else {
                    if (pIndex == 0) {
                        sIndex++;
                    } else {
                        pIndex = dp[pIndex - 1] + 1;
                    }
                }
            }
            int n = s.length();
            return dp[n - 1] >= 0 && n % (n - dp[n - 1] - 1) == 0;
        }
    }

    // if i mismatch, try dp[i-1]. s.charAt(dp[x]-1) = s.charAt(x)
    private static class S4 extends Solution459 {
        @Override
        public boolean repeatedSubstringPattern(String s) {
            int i = 0;
            int j = 1;
            int n = s.length();
            int[] dp = new int[n];
            while (j < n) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j++] = ++i;
                } else {
                    if (i == 0) {
                        j++;
                    } else {
                        i = dp[i - 1];
                    }
                }
            }
            return dp[n - 1] > 0 && n % (n - dp[n - 1]) == 0;
        }
    }

    // if i mismatch, try dp[i]. s.charAt(dp[x]-1) = s.charAt(x-1)
    private static class S5 extends Solution459 {
        @Override
        public boolean repeatedSubstringPattern(String s) {
            int i = 0;
            int j = 1;
            int n = s.length();
            int[] dp = new int[n + 1];
            while (j < n) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[++j] = ++i;
                } else {
                    if (i == 0) {
                        j++;
                    } else {
                        i = dp[i];
                    }
                }
            }
            return dp[n] > 0 && n % (n - dp[n]) == 0;
        }
    }
}
