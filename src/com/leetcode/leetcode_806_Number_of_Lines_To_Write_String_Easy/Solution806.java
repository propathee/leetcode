package com.leetcode.leetcode_806_Number_of_Lines_To_Write_String_Easy;

abstract class Solution806 {
    public abstract int[] numberOfLines(int[] widths, String s);

    static Solution806 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution806 {
        @Override
        public int[] numberOfLines(int[] widths, String s) {
            int[] res = {1, 0};
            for (int i = 0; i < s.length(); i++) {
                int width = widths[s.charAt(i) - 'a'];
                if (res[1] + width > 100) {
                    res[0]++;
                    res[1] = 0;
                }
                res[1] += width;
            }
            return res;
        }
    }
}
