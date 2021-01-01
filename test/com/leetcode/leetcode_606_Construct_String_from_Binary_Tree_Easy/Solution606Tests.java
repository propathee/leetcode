package com.leetcode.leetcode_606_Construct_String_from_Binary_Tree_Easy;

import com.leetcode.leetcode_606_Construct_String_from_Binary_Tree_Easy.Solution606.TreeNode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution606Tests {
    private Solution606 solution = Solution606.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(1,2,3,4);
        String expect = "1(2(4))(3)";
        assertEquals(expect, solution.tree2str(root));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(1,2,3,null,4);
        String expect = "1(2()(4))(3)";
        assertEquals(expect, solution.tree2str(root));
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
            if (i < values.length && values[i] != null) {
                node.right = new TreeNode(values[i]);
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}