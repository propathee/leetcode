package com.leetcode.leetcode_700_Search_in_a_Binary_Search_Tree_Easy;

import com.leetcode.leetcode_700_Search_in_a_Binary_Search_Tree_Easy.Solution700.TreeNode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution700Tests {
    private Solution700 solution = Solution700.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(4,2,7,1,3);
        TreeNode expect = makeTree(2,1,3);
        assertPass(expect, solution.searchBST(root, 2));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(4,2,7,1,3);
        TreeNode expect = null;
        assertPass(expect, solution.searchBST(root, 5));
    }

    @Test
    public void should_pass_3() {
        TreeNode root = null;
        TreeNode expect = null;
        assertPass(expect, solution.searchBST(root, 2));
    }

    private TreeNode makeTree(Integer... values) {
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (values[i] != null) {
                    node.left = new TreeNode(values[i]);
                    queue.offer(node.left);
                }
                i++;
                if (i < values.length && values[i] != null) {
                    node.right = new TreeNode(values[i]);
                    queue.offer(node.right);
                }
                i++;
            }
        }
        return root;
    }

    private void assertPass(TreeNode expect, TreeNode actual) {
        if (expect == null) {
            assertNull(actual);
        } else {
            assertEquals(expect.val, actual.val);
            assertPass(expect.left, actual.left);
            assertPass(expect.right, actual.right);
        }
    }
}