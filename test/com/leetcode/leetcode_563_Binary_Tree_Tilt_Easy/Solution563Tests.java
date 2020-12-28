package com.leetcode.leetcode_563_Binary_Tree_Tilt_Easy;

import com.leetcode.leetcode_563_Binary_Tree_Tilt_Easy.Solution563.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution563Tests {
    private Solution563 solution = Solution563.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(1,2,3);
        assertEquals(1, solution.findTilt(root));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(4,2,9,3,5,null,7);
        assertEquals(15, solution.findTilt(root));
    }

    @Test
    public void should_pass_3() {
        TreeNode root = makeTree(21,7,14,1,1,2,2,3,3);
        assertEquals(9, solution.findTilt(root));
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