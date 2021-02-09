package com.leetcode.leetcode_893_Groups_of_Special_Equivalent_Strings_Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

abstract class Solution893 {
    public abstract int numSpecialEquivGroups(String[] A);

    static Solution893 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution893 {
        @Override
        public int numSpecialEquivGroups(String[] A) {
            Set<String> set = new HashSet<>();
            for (String s : A) {
                int[] counts = new int[52];
                for (int i = 0; i < s.length(); i += 2) {
                    counts[s.charAt(i) - 'a']++;
                }
                for (int i = 1; i < s.length(); i += 2) {
                    counts[s.charAt(i) - 'a' + 26]++;
                }
                StringBuilder sb = new StringBuilder(counts.length);
                for (int cnt : counts) {
                    sb.append(cnt);
                }
                set.add(sb.toString());
            }
            return set.size();
        }
    }

    private static class S2 extends Solution893 {
        @Override
        public int numSpecialEquivGroups(String[] A) {
            Set<String> set = new HashSet<>();
            for (String s : A) {
                int[] odd = new int[26];
                int[] even = new int[26];
                for (int i = 0; i < s.length(); i++) {
                    if (i % 2 == 0) {
                        even[s.charAt(i) - 'a']++;
                    } else {
                        odd[s.charAt(i) - 'a']++;
                    }
                }
                set.add(Arrays.toString(odd) + Arrays.toString(even));
            }
            return set.size();
        }
    }
}
