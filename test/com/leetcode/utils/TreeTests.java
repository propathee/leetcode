package com.leetcode.utils;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class TreeTests {

    public static TreeNode makeTree(Integer... values) {
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

    public static void assertTreeEquals(TreeNode expect, TreeNode actual) {
        if (expect == null) {
            assertNull(actual);
        } else {
            assertEquals(expect.val, actual.val);
            assertTreeEquals(expect.left, actual.left);
            assertTreeEquals(expect.right, actual.right);
        }
    }
}