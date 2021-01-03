package com.leetcode.leetcode_653_Two_Sum_IV_Input_is_a_BST_Easy;

import com.leetcode.leetcode_653_Two_Sum_IV_Input_is_a_BST_Easy.Solution653.TreeNode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution653Tests {
    private Solution653 solution = Solution653.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(5,3,6,2,4,null,7);
        int k = 9;
        assertTrue(solution.findTarget(root, k));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(5,3,6,2,4,null,7);
        int k = 28;
        assertFalse(solution.findTarget(root, k));
    }

    @Test
    public void should_pass_3() {
        TreeNode root = makeTree(2,1,3);
        int k = 4;
        assertTrue(solution.findTarget(root, k));
    }

    @Test
    public void should_pass_4() {
        TreeNode root = makeTree(2,1,3);
        int k = 1;
        assertFalse(solution.findTarget(root, k));
    }

    @Test
    public void should_pass_5() {
        TreeNode root = makeTree(2,1,3);
        int k = 3;
        assertTrue(solution.findTarget(root, k));
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