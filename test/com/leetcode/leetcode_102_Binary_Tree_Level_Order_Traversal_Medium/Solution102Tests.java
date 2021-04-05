package com.leetcode.leetcode_102_Binary_Tree_Level_Order_Traversal_Medium;

import com.leetcode.leetcode_102_Binary_Tree_Level_Order_Traversal_Medium.Solution102.TreeNode;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Solution102Tests {
    private Solution102 solution = Solution102.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(3,9,20,null,null,15,7);
        List<List<Integer>> levels = makeLevels("[3],[9,20],[15,7]");
        assertPass(levels, solution.levelOrder(root));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(1);
        List<List<Integer>> levels = makeLevels("[1]");
        assertPass(levels, solution.levelOrder(root));
    }

    @Test
    public void should_pass_3() {
        TreeNode root = null;
        List<List<Integer>> levels = new ArrayList<>();
        assertPass(levels, solution.levelOrder(root));
    }

    private TreeNode makeTree(Integer... values) {
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int i = 1; i < values.length; i += 2) {
            TreeNode node = q.poll();
            if (values[i] != null) {
                node.left = new TreeNode(values[i]);
                q.offer(node.left);
            }
            if (i + 1 < values.length && values[i + 1] != null) {
                node.right = new TreeNode(values[i + 1]);
                q.offer(node.right);
            }
        }
        return root;
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