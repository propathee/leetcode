package com.leetcode.leetcode_543_Diameter_of_Binary_Tree_Easy;

import static org.junit.Assert.*;

import com.leetcode.leetcode_543_Diameter_of_Binary_Tree_Easy.Solution543.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution543Tests {
    private Solution543 solution = Solution543.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(1,2,3,4,5);
        assertEquals(3, solution.diameterOfBinaryTree(root));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(1,2,3,4,5,null,null,6,null,null,7,8,null,9);
        assertEquals(6, solution.diameterOfBinaryTree(root));
    }

    @Test
    public void should_pass_3() {
        TreeNode root = makeTree(1);
        assertEquals(0, solution.diameterOfBinaryTree(root));
    }

    @Test
    public void should_pass_4() {
        TreeNode root = makeTree(1,2);
        assertEquals(1, solution.diameterOfBinaryTree(root));
    }

    @Test
    public void should_pass_5() {
        TreeNode root = makeTree(1,2,3);
        assertEquals(2, solution.diameterOfBinaryTree(root));
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