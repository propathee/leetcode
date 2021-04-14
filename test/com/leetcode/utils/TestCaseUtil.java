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
}
