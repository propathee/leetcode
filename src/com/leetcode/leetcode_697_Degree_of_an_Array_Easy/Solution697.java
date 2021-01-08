package com.leetcode.leetcode_697_Degree_of_an_Array_Easy;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

abstract class Solution697 {
    /**
     * nums.length will be between 1 and 50,000.
     * nums[i] will be an integer between 0 and 49,999.
     */
    public abstract int findShortestSubArray(int[] nums);

    static Solution697 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution697 {
        private static final Comparator<NumInfo> COMPARATOR =
            Comparator.comparingInt((NumInfo numInfo) -> numInfo.freq)
                .thenComparingInt(numInfo -> -numInfo.getLen());

        @Override
        public int findShortestSubArray(int[] nums) {
            Map<Integer, NumInfo> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int idx = i; // shit
                NumInfo numInfo = map.computeIfAbsent(nums[i], n -> new NumInfo(idx));
                numInfo.freq++;
                numInfo.end = i;
            }
            return Collections.max(map.values(), COMPARATOR).getLen();
        }

        private static class NumInfo {
            private int freq;
            private int start;
            private int end;

            private NumInfo(int start) {
                this.start = start;
            }

            private int getLen() {
                return end - start + 1;
            }
        }
    }

    private static class S2 extends Solution697 {
        @Override
        public int findShortestSubArray(int[] nums) {
            Map<Integer, Integer> cntMap = new HashMap<>();
            Map<Integer, Integer> headMap = new HashMap<>();
            int res = 0, maxCnt = 0;
            for (int i = 0; i < nums.length; i++) {
                int idx = i; // shit
                int cnt = cntMap.compute(nums[i], (k, v) -> v == null ? 1 : v + 1);
                int head = headMap.computeIfAbsent(nums[i], k -> idx);
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                    res = i - head + 1;
                } else if (cnt == maxCnt){
                    res = Math.min(res, i - head + 1);
                }
            }
            return res;
        }
    }

    private static class S3 extends Solution697 {
        @Override
        public int findShortestSubArray(int[] nums) {
            Map<Integer, Integer> cntMap = new HashMap<>();
            Map<Integer, Integer> headMap = new HashMap<>();
            int res = 0, maxCnt = 0;
            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];
                cntMap.put(n, cntMap.getOrDefault(n, 0) + 1);
                headMap.putIfAbsent(n, i);
                if (cntMap.get(n) > maxCnt) {
                    maxCnt = cntMap.get(n);
                    res = i - headMap.get(n) + 1;
                } else if (cntMap.get(n) == maxCnt) {
                    res = Math.min(res, i - headMap.get(n) + 1);
                }
            }
            return res;
        }
    }

    private static class S4 extends Solution697 {
        @Override
        public int findShortestSubArray(int[] nums) {
            int res = 0, maxCnt = 0;
            int[] counts = new int[50000];
            int[] heads = new int[50000];
            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];
                counts[n]++;
                if (counts[n] == 1) {
                    heads[n] = i;
                }
                if (counts[n] > maxCnt) {
                    maxCnt = counts[n];
                    res = i - heads[n] + 1;
                } else if (counts[n] == maxCnt) {
                    res = Math.min(res, i - heads[n] + 1);
                }
            }
            return res;
        }
    }
}
