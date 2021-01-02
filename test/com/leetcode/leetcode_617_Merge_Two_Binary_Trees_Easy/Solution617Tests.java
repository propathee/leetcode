package com.leetcode.leetcode_617_Merge_Two_Binary_Trees_Easy;

import com.leetcode.leetcode_617_Merge_Two_Binary_Trees_Easy.Solution617.TreeNode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution617Tests {
    private Solution617 solution = Solution617.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode t1 = makeTree(1,3,2,5);
        TreeNode t2 = makeTree(2,1,3,null,4,null,7);
        TreeNode expect = makeTree(3,4,5,5,4,null,7);
        assertPass(expect, solution.mergeTrees(t1, t2));
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

    private void assertPass(TreeNode expect, TreeNode actual) {
        assertTrue((expect == null && actual == null) || expect.val == actual.val);
        if (expect != null) {
            assertPass(expect.left, actual.left);
            assertPass(expect.right, actual.right);
        }
    }
}