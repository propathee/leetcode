package com.leetcode.leetcode_599_Minimum_Index_Sum_of_Two_Lists_Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Solution599 {
    public abstract String[] findRestaurant(String[] list1, String[] list2);

    static Solution599 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution599 {
        @Override
        public String[] findRestaurant(String[] list1, String[] list2) {
            if (list1.length > list2.length) {
                String[] tmp = list1;
                list1 = list2;
                list2 = tmp;
            }
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < list1.length; i++) {
                map.put(list1[i], i);
            }
            int min = Integer.MAX_VALUE;
            List<String> list = new ArrayList<>();
            for (int i = 0; i < list2.length; i++) {
                if (map.containsKey(list2[i])) {
                    int sum = i + map.get(list2[i]);
                    if (sum == min) {
                        list.add(list2[i]);
                    } else if (sum < min) {
                        list.clear();
                        list.add(list2[i]);
                        min = sum;
                    }
                }
            }
            String[] res = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

    private static class S2 extends Solution599 {
        @Override
        public String[] findRestaurant(String[] list1, String[] list2) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < list1.length; i++) {
                map.put(list1[i], i);
            }
            int min = Integer.MAX_VALUE;
            List<String> res = new ArrayList<>();
            for (int j = 0; j < list2.length; j++) {
                Integer i = map.get(list2[j]);
                if (i != null && i + j <= min) {
                    if (i + j < min) {
                        res.clear();
                        min = i + j;
                    }
                    res.add(list2[j]);
                }
            }
            return res.toArray(new String[0]);
        }
    }

    private static class S3 extends Solution599 {
        @Override
        public String[] findRestaurant(String[] list1, String[] list2) {
            if (list1.length > list2.length) {
                return findRestaurant(list2, list1);
            }
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < list1.length; i++) {
                map.put(list1[i], i);
            }
            int min = Integer.MAX_VALUE;
            List<String> res = new ArrayList<>();
            for (int j = 0; j < list2.length; j++) {
                Integer i = map.get(list2[j]);
                if (i != null && i + j <= min) {
                    if (i + j < min) {
                        res.clear();
                        min = i + j;
                    }
                    res.add(list2[j]);
                }
            }
            return res.toArray(new String[0]);
        }
    }
}
