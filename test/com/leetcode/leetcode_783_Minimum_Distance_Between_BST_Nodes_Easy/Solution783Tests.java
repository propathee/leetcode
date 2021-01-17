package com.leetcode.leetcode_783_Minimum_Distance_Between_BST_Nodes_Easy;

import com.leetcode.leetcode_783_Minimum_Distance_Between_BST_Nodes_Easy.Solution783.TreeNode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution783Tests {
    private Solution783 solution = Solution783.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(4,2,6,1,3);
        assertEquals(1, solution.minDiffInBST(root));
    }

    private TreeNode makeTree(Integer... values) {
        TreeNode root = new TreeNode();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (Integer v : values) {
            q2.offer(v);
        }
        root.val = q2.poll();
        q1.offer(root);
        while (!q1.isEmpty()) {
            TreeNode node = q1.poll();
            if (!q2.isEmpty()) {
                Integer val = q2.poll();
                if (val != null) {
                    node.left = new TreeNode(val);
                    q1.offer(node.left);
                }
            }
            if (!q2.isEmpty()) {
                Integer val = q2.poll();
                if (val != null) {
                    node.right = new TreeNode(val);
                    q1.offer(node.right);
                }
            }
        }
        return root;
    }
}