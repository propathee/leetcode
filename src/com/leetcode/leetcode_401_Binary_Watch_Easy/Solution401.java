package com.leetcode.leetcode_401_Binary_Watch_Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Solution401 {
    /**
     * Given a non-negative integer n which represents the number of LEDs that are currently on,
     * return all possible times the watch could represent.
     * <p>The order of output does not matter.
     * <p>The hour must not contain a leading zero,
     * for example "01:00" is not valid, it should be "1:00".
     * <p>The minute must be consist of two digits and may contain a leading zero,
     * for example "10:2" is not valid, it should be "10:02".
     */
    public abstract List<String> readBinaryWatch(int num);

    static Solution401 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution401 {
        private static final int[] HOURS = new int[] {8, 4, 2, 1};
        private static final int[] MINUTES = new int[] {32, 16, 8, 4, 2, 1};

        @Override
        public List<String> readBinaryWatch(int num) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                int j = num - i;
                if (j < 0 || j > 6) {
                    continue;
                }
                List<String> hours = genHours(i);
                List<String> minutes = genMinutes(j);
                for (String h : hours) {
                    for (String m : minutes) {
                        if (m.length() < 2) {
                            m = "0" + m;
                        }
                        res.add(h + ":" + m);
                    }
                }
            }
            return res;
        }

        private List<String> genHours(int n) {
            if (n == 0) {
                return Collections.singletonList("0");
            }
            List<String> res = new ArrayList<>();
            List<List<Integer>> combinations = genCombination(4, n);
            for (List<Integer> indices : combinations) {
                int sum = 0;
                for (int idx : indices) {
                    sum += HOURS[idx];
                }
                if (sum < 12) {
                    res.add(String.valueOf(sum));
                }
            }
            return res;
        }

        private List<String> genMinutes(int n) {
            if (n == 0) {
                return Collections.singletonList("00");
            }
            List<String> res = new ArrayList<>();
            List<List<Integer>> combinations = genCombination(6, n);
            for (List<Integer> indices : combinations) {
                int sum = 0;
                for (int idx : indices) {
                    sum += MINUTES[idx];
                }
                if (sum < 60) {
                    res.add(String.valueOf(sum));
                }
            }
            return res;
        }

        private List<List<Integer>> genCombination(int total, int n) {
            List<List<Integer>> res = new ArrayList<>();
            combinationHelper(res, new ArrayList<>(), total, 0, n);
            return res;
        }

        private void combinationHelper(List<List<Integer>> res, List<Integer> cur, int total, int start, int remained) {
            if (remained == 0) {
                res.add(cur);
                return;
            }
            for (int i = start; i <= total - remained; i++) {
                List<Integer> copy = new ArrayList<>(cur);
                copy.add(i);
                combinationHelper(res, copy, total, i + 1, remained - 1);
            }
        }
    }

    private static class S2 extends Solution401 {
        @Override
        public List<String> readBinaryWatch(int num) {
            List<String> res = new ArrayList<>();
            for (int h = 0; h < 12; h++) {
                for (int m = 0; m < 60; m++) {
                    if (Integer.bitCount(h) + Integer.bitCount(m) == num) {
                        res.add(String.format("%d:%02d", h, m));
                    }
                }
            }
            return res;
        }
    }

    private static class S3 extends Solution401 {
        @Override
        public List<String> readBinaryWatch(int num) {
            List<String> res = new ArrayList<>();
            for (int h = 0; h < 12; h++) {
                for (int m = 0; m < 60; m++) {
                    if (Integer.bitCount((h << 6) + m) == num) {
                        res.add(String.format("%d:%02d", h, m));
                    }
                }
            }
            return res;
        }
    }
}
