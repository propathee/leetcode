package com.leetcode.leetcode_671_Second_Minimum_Node_In_a_Binary_Tree_Easy;

import com.leetcode.leetcode_671_Second_Minimum_Node_In_a_Binary_Tree_Easy.Solution671.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution671Tests {
    private Solution671 solution = Solution671.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(2,2,5,null,null,5,7);
        assertEquals(5, solution.findSecondMinimumValue(root));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(2,2,2);
        assertEquals(-1, solution.findSecondMinimumValue(root));
    }

    @Test
    public void should_pass_3() {
        TreeNode root = makeTree(2,2,2147483647);
        assertEquals(2147483647, solution.findSecondMinimumValue(root));
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