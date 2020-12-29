package com.leetcode.leetcode_572_Subtree_of_Another_Tree_Easy;

import com.leetcode.leetcode_572_Subtree_of_Another_Tree_Easy.Solution572.TreeNode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution572Tests {
    private Solution572 solution = Solution572.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode s = makeTree(3,4,5,1,2);
        TreeNode t = makeTree(4,1,2);
        assertTrue(solution.isSubtree(s, t));
    }

    @Test
    public void should_pass_2() {
        TreeNode s = makeTree(3,4,5,1,2,null,null,null,0);
        TreeNode t = makeTree(4,1,2);
        assertFalse(solution.isSubtree(s, t));
    }

    private TreeNode makeTree(Integer... values) {
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < values.length; i += 2) {
            TreeNode node = queue.poll();
            if (values[i] != null) {
                node.left = new TreeNode(values[i]);
                queue.offer(node.left);
            }
            if (i + 1 < values.length && values[i + 1] != null) {
                node.right = new TreeNode(values[i + 1]);
                queue.offer(node.right);
            }
        }
        return root;
    }
}