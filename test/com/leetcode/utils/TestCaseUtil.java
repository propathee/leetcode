package com.leetcode.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestCaseUtil {
    public static List<List<Integer>> parseTwoDimensionalIntList(String s) {
        if (s.isEmpty() || "[]".equals(s)) {
            return new ArrayList<>();
        }
        s = s.substring(1, s.length() - 1).replace("[", "");
        return Arrays.stream(s.split("],"))
            .map(TestCaseUtil::parseIntList)
            .collect(Collectors.toList());
    }

    private static List<Integer> parseIntList(String s) {
        if (s.isEmpty()) {
            return new ArrayList<>();
        }
        return Arrays.stream(s.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static int[][] parseTwoDimensionalIntArray(String s) {
        if (s.isEmpty() || "[]".equals(s)) {
            return new int[0][0];
        }
        s = s.substring(1, s.length() - 1).replace("[", "");
        return Arrays.stream(s.split("],"))
            .map(TestCaseUtil::parseIntArray)
            .toArray(int[][]::new);
    }

    private static int[] parseIntArray(String s) {
        if (s.isEmpty()) {
            return new int[0];
        }
        String[] sArr = s.split(",");
        int[] res = new int[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            res[i] = Integer.parseInt(sArr[i]);
        }
        return res;
    }
}
