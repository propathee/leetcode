package com.leetcode.leetcode_128_Longest_Consecutive_Sequence_Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class Solution128 {
    public abstract int longestConsecutive(int[] nums);

    static Solution128 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution128 {
        @Override
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int maxLen = 0;
            for (int num : nums) {
                int len = 0;
                int left = num, right = num + 1;
                while (set.contains(left)) {
                    len++;
                    set.remove(left);
                    left--;
                }
                while (set.contains(right)) {
                    len++;
                    set.remove(right);
                    right++;
                }
                if (len > maxLen) {
                    maxLen = len;
                }
            }
            return maxLen;
        }
    }

    private static class S2 extends Solution128 {
        @Override
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int maxLen = 0;
            for (int num : nums) {
                if (set.size() <= maxLen) {
                    break;
                }
                int len = 0;
                int left = num, right = num + 1;
                while (set.remove(left)) {
                    len++;
                    left--;
                }
                while (set.remove(right)) {
                    len++;
                    right++;
                }
                if (len > maxLen) {
                    maxLen = len;
                }
            }
            return maxLen;
        }
    }

    private static class S3 extends Solution128 {
        @Override
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int maxLen = 0;
            for (int x : nums) {
                if (!set.contains(x - 1)) {
                    int y = x + 1;
                    while (set.contains(y)) {
                        y++;
                    }
                    maxLen = Math.max(y - x, maxLen);
                }
            }
            return maxLen;
        }
    }

    private static class S4 extends Solution128 {
        @Override
        public int longestConsecutive(int[] nums) {
            int maxLen = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    continue;
                } else {
                    int left = map.getOrDefault(num - 1, 0);
                    int right = map.getOrDefault(num + 1, 0);
                    int len = left + right + 1;
                    maxLen = Math.max(len , maxLen);
                    map.put(num, len);
                    map.put(num - left, len);
                    map.put(num + right, len);
                }
            }
            return maxLen;
        }
    }
}
