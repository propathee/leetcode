package com.leetcode.leetcode_98_Validate_Binary_Search_Tree_Medium;

import org.junit.Test;
import com.leetcode.leetcode_98_Validate_Binary_Search_Tree_Medium.Solution98.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution98Tests {
    private Solution98 solution = Solution98.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(2,1,3);
        assertTrue(solution.isValidBST(root));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(5,1,4,null,null,3,6);
        assertFalse(solution.isValidBST(root));
    }

    @Test
    public void should_pass_3() {
        TreeNode root = makeTree(2147483647);
        assertTrue(solution.isValidBST(root));
    }

    @Test
    public void should_pass_4() {
        TreeNode root = makeTree(1,1);
        assertFalse(solution.isValidBST(root));
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
}