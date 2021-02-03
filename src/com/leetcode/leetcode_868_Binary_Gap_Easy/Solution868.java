package com.leetcode.leetcode_868_Binary_Gap_Easy;

abstract class Solution868 {
    public abstract int binaryGap(int n);

    static Solution868 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution868 {
        @Override
        public int binaryGap(int n) {
            int gap = 0, pre = -1, cur = 0;
            while (n != 0) {
                cur++;
                if ((n & 1) == 1) {
                    if (pre != -1) {
                        gap = Math.max(gap, cur - pre);
                    }
                    pre = cur;
                }
                n >>>= 1;
            }
            return gap;
        }
    }

    private static class S2 extends Solution868 {
        @Override
        public int binaryGap(int n) {
            int gap = 0, pre = -1;
            for (int i = 0; n > 0; n >>= 1, i++) {
                if ((n & 1) == 1) {
                    if (pre != -1) {
                        gap = Math.max(gap, i - pre);
                    }
                    pre = i;
                }
            }
            return gap;
        }
    }

    private static class S3 extends Solution868 {
        @Override
        public int binaryGap(int n) {
            int gap = 0;
            for (int d = -32; n > 0; n >>= 1, d++) {
                if ((n & 1) == 1) {
                    gap = Math.max(gap, d);
                    d = 0;
                }
            }
            return gap;
        }
    }
}
