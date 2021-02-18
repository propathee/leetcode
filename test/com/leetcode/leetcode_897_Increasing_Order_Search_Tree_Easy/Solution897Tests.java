package com.leetcode.leetcode_897_Increasing_Order_Search_Tree_Easy;

import static org.junit.Assert.*;

import com.leetcode.leetcode_897_Increasing_Order_Search_Tree_Easy.Solution897.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution897Tests {
    private Solution897 solution = Solution897.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(5,3,6,2,4,null,8,1,null,null,null,7,9);
        assertPass(solution.increasingBST(root), 1,2,3,4,5,6,7,8,9);
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(5,1,7);
        assertPass(solution.increasingBST(root), 1,5,7);
    }

    private TreeNode makeTree(Integer... values) {
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.poll();
            Integer valL = values[i++];
            if (valL != null) {
                node.left = new TreeNode(valL);
                queue.offer(node.left);
            }
            Integer valR = i < values.length ? values[i++] : null;
            if (valR != null) {
                node.right = new TreeNode(valR);
                queue.offer(node.right);
            }
        }
        return root;
    }

    private void assertPass(TreeNode root, int... values) {
        for (int val : values) {
            assertNotNull(root);
            assertEquals(val, root.val);
            assertNull(root.left);
            root = root.right;
        }
        assertNull(root);
    }
}