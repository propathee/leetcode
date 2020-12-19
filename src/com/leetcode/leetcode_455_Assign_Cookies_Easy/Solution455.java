package com.leetcode.leetcode_455_Assign_Cookies_Easy;

import java.util.Arrays;

public abstract class Solution455 {
    /**
     * 1 <= g[i], s[j] <= 2^31 - 1
     */
    public abstract int findContentChildren(int[] g, int[] s);

    static Solution455 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution455 {
        @Override
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int cnt = 0;
            for (int i = 0, j = 0; i < g.length && j < s.length; j++) {
                if (g[i] <= s[j]) {
                    i++;
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
