package com.leetcode.leetcode_113_Path_Sum_II_Medium;

import com.leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.leetcode.utils.TreeTests.makeTree;
import static org.junit.Assert.*;

public class Solution113Tests {
    private Solution113 solution = Solution113.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(5,4,8,11,null,13,4,7,2,null,null,5,1);
        List<List<Integer>> expect = parseAllPath("[5,4,11,2],[5,8,4,5]");
        assertPass(expect, solution.pathSum(root, 22));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(1,2,3);
        List<List<Integer>> expect = new ArrayList<>();
        assertPass(expect, solution.pathSum(root, 5));
    }

    @Test
    public void should_pass_3() {
        TreeNode root = makeTree(1,2);
        List<List<Integer>> expect = new ArrayList<>();
        assertPass(expect, solution.pathSum(root, 0));
    }

    @Test
    public void should_pass_4() {
        TreeNode root = makeTree(-2,null,-3);
        List<List<Integer>> expect = parseAllPath("[-2,-3]");
        assertPass(expect, solution.pathSum(root, -5));
    }

    private List<List<Integer>> parseAllPath(String s) {
        s = s.substring(1, s.length() - 1).replace("[", "");
        return Arrays.stream(s.split("],"))
            .map(this::parsePath)
            .collect(Collectors.toList());
    }

    private List<Integer> parsePath(String s) {
        return Arrays.stream(s.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private void assertPass(List<List<Integer>> expect, List<List<Integer>> actual) {
        assertPassHelper(toStringList(expect), toStringList(actual));
    }

    private void assertPassHelper(List<String> expect, List<String> actual) {
        assertEquals(expect.size(), actual.size());
        for (String path : expect) {
            assertTrue(actual.contains(path));
        }
    }

    private List<String> toStringList(List<List<Integer>> paths) {
        return paths.stream()
            .map(this::toString)
            .collect(Collectors.toList());
    }

    private String toString(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int num : path) {
            sb.append(num).append(",");
        }
        return sb.toString();
    }
}