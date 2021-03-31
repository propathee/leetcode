package com.leetcode.leetcode_94_Binary_Tree_Inorder_Traversal_Medium;

import org.junit.Test;
import com.leetcode.leetcode_94_Binary_Tree_Inorder_Traversal_Medium.Solution94.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution94Tests {
    private Solution94 solution = Solution94.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(1,null,2,3);
        List<Integer> expect = Arrays.asList(1,3,2);
        assertEquals(expect, solution.inorderTraversal(root));
    }

    @Test
    public void should_pass_2() {
        assertTrue(solution.inorderTraversal(null).isEmpty());
    }

    @Test
    public void should_pass_3() {
        TreeNode root = makeTree(1);
        List<Integer> expect = Arrays.asList(1);
        assertEquals(expect, solution.inorderTraversal(root));
    }

    @Test
    public void should_pass_4() {
        TreeNode root = makeTree(1,2);
        List<Integer> expect = Arrays.asList(2,1);
        assertEquals(expect, solution.inorderTraversal(root));
    }

    @Test
    public void should_pass_5() {
        TreeNode root = makeTree(1,null,2);
        List<Integer> expect = Arrays.asList(1,2);
        assertEquals(expect, solution.inorderTraversal(root));
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