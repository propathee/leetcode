package com.leetcode.leetcode_349_Intersection_of_Two_Arrays_Easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution349 {
    public int[] intersection_1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            set2.add(n);
        }
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        Iterator<Integer> iterator = set1.iterator();
        for (int i = 0; i < set1.size(); i++) {
            res[i] = iterator.next();
        }
        return res;
    }

    public int[] intersection_2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int n : nums1) {
            set1.add(n);
        }
        for (int n : nums2) {
            if (set1.contains(n)) {
                intersect.add(n);
            }
        }
        int[] res = new int[intersect.size()];
        int i = 0;
        for (int n : intersect) {
            res[i++] = n;
        }
        return res;
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[set.size()];
        int k = 0;
        for (int n : set) {
            res[k++] = n;
        }
        return res;
    }
}
