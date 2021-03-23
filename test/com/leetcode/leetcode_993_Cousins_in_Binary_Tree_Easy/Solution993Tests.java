package com.leetcode.leetcode_993_Cousins_in_Binary_Tree_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

import com.leetcode.leetcode_993_Cousins_in_Binary_Tree_Easy.Solution993.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution993Tests {
    private Solution993 solution = Solution993.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(1,2,3,4);
        assertFalse(solution.isCousins(root, 4, 3));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(1,2,3,null,4,null,5);
        assertTrue(solution.isCousins(root, 5, 4));
    }

    @Test
    public void should_pass_3() {
        TreeNode root = makeTree(1,2,3,null,4);
        assertFalse(solution.isCousins(root, 2, 3));
    }

    private TreeNode makeTree(Integer... values) {
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (i < values.length && values[i] != null) {
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
        return root;
    }
}