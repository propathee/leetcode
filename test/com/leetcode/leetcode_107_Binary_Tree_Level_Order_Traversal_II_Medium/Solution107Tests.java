package com.leetcode.leetcode_107_Binary_Tree_Level_Order_Traversal_II_Medium;

import com.leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.leetcode.utils.TreeTests.makeTree;
import static org.junit.Assert.*;

public class Solution107Tests {
    private Solution107 solution = Solution107.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(3,9,20,null,null,15,7);
        List<List<Integer>> levels = makeLevels("[15,7],[9,20],[3]");
        assertPass(levels, solution.levelOrderBottom(root));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(1);
        List<List<Integer>> levels = makeLevels("[1]");
        assertPass(levels, solution.levelOrderBottom(root));
    }

    @Test
    public void should_pass_3() {
        TreeNode root = null;
        List<List<Integer>> levels = new ArrayList<>();
        assertPass(levels, solution.levelOrderBottom(root));
    }

    private List<List<Integer>> makeLevels(String s) {
        s = s.substring(1, s.length() - 1).replace("[", "");
        return Arrays.stream(s.split("],"))
            .map(this::makeLevel)
            .collect(Collectors.toList());
    }

    private List<Integer> makeLevel(String s) {
        return Arrays.stream(s.split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private void assertPass(List<List<Integer>> expect, List<List<Integer>> actual) {
        assertEquals(expect.size(), actual.size());
        for (int i = 0; i < expect.size(); i++) {
            assertEquals(expect.get(i), actual.get(i));
        }
    }
}