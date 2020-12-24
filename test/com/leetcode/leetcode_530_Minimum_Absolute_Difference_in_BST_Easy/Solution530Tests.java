package com.leetcode.leetcode_530_Minimum_Absolute_Difference_in_BST_Easy;

import com.leetcode.leetcode_530_Minimum_Absolute_Difference_in_BST_Easy.Solution530.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution530Tests {
    private Solution530 solution = Solution530.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(1,null,3,2);
        assertEquals(1, solution.getMinimumDifference(root));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(4,2,6,1,3,null,null);
        assertEquals(1, solution.getMinimumDifference(root));
    }

    @Test
    public void should_pass_3() {
        TreeNode root = makeTree(1,null,5,2);
        assertEquals(1, solution.getMinimumDifference(root));
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