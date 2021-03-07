package com.leetcode.leetcode_938_Range_Sum_of_BST_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

import com.leetcode.leetcode_938_Range_Sum_of_BST_Easy.Solution938.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution938Tests {
    private Solution938 solution = Solution938.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(10,5,15,3,7,null,18);
        assertEquals(32, solution.rangeSumBST(root, 7, 15));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(10,5,15,3,7,13,18,1,null,6);
        assertEquals(23, solution.rangeSumBST(root, 6, 10));
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