package com.leetcode.leetcode_965_Univalued_Binary_Tree_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

import com.leetcode.leetcode_965_Univalued_Binary_Tree_Easy.Solution965.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution965Tests {
    private Solution965 solution = Solution965.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(1,1,1,1,1,null,1);
        assertTrue(solution.isUnivalTree(root));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(2,2,2,5,2);
        assertFalse(solution.isUnivalTree(root));
    }

    private TreeNode makeTree(Integer... values) {
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.poll();
            if (values[i] != null) {
                node.left = new TreeNode(values[i]);
                queue.offer(node.left);
            }
            i++;
            if (values[i] != null) {
                node.right = new TreeNode(values[i]);
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}