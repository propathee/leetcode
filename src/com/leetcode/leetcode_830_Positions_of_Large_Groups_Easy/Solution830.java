package com.leetcode.leetcode_830_Positions_of_Large_Groups_Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Solution830 {
    public abstract List<List<Integer>> largeGroupPositions(String s);

    static Solution830 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution830 {
        @Override
        public List<List<Integer>> largeGroupPositions(String s) {
            List<List<Integer>> res = new ArrayList<>();
            int p = 0, q = 1;
            char[] chars = (s + ";").toCharArray();
            for (; q < chars.length; q++) {
                if (chars[q] != chars[q - 1]) {
                    if (q - p >= 3) {
                        res.add(Arrays.asList(p, q - 1));
                    }
                    p = q;
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution830 {
        @Override
        public List<List<Integer>> largeGroupPositions(String s) {
            List<List<Integer>> res = new ArrayList<>();
            for (int p = 0, q = 0; p < s.length(); p = q) {
                while (q < s.length() && s.charAt(q) == s.charAt(p)) {
                    q++;
                }
                if (q - p >= 3) {
                    res.add(Arrays.asList(p, q - 1));
                }
            }
            return res;
        }
    }
}
