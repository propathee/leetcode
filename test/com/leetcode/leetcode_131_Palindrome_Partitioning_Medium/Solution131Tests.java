package com.leetcode.leetcode_131_Palindrome_Partitioning_Medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Solution131Tests {
    private Solution131 solution = Solution131.newSolution();

    @Test
    public void should_pass_1() {
        List<List<String>> expect = parse("[\"a\",\"a\",\"b\"],[\"aa\",\"b\"]");
        List<List<String>> actual = solution.partition("aab");
        assertPass(expect, actual);
    }

    @Test
    public void should_pass_2() {
        List<List<String>> expect = parse("[\"a\"]");
        List<List<String>> actual = solution.partition("a");
        assertPass(expect, actual);
    }

    @Test
    public void should_pass_3() {
        List<List<String>> expect = parse("[\"b\",\"b\"],[\"bb\"]");
        List<List<String>> actual = solution.partition("bb");
        assertPass(expect, actual);
    }

    private List<List<String>> parse(String s) {
        s = s.substring(1, s.length() - 1).replace("\"", "").replace("[", "");
        return Arrays.stream(s.split("],"))
            .map(this::parseOne)
            .collect(Collectors.toList());
    }

    private List<String> parseOne(String s) {
        return Arrays.stream(s.split(",")).collect(Collectors.toList());
    }

    private void assertPass(List<List<String>> expect, List<List<String>> actual) {
        assertEquals(expect.size(), actual.size());
        List<String> expect1 = transform(expect);
        List<String> actual1 = transform(actual);
        Collections.sort(expect1);
        Collections.sort(actual1);
        assertEquals(expect1, actual1);
    }

    private List<String> transform(List<List<String>> origin) {
        return origin.stream()
            .map(this::join)
            .collect(Collectors.toList());
    }

    private String join(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append(",");
        }
        return sb.toString();
    }
}