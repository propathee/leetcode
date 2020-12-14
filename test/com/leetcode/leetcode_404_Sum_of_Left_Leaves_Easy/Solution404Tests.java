package com.leetcode.leetcode_404_Sum_of_Left_Leaves_Easy;

import org.junit.Test;

import com.leetcode.leetcode_404_Sum_of_Left_Leaves_Easy.Solution404.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution404Tests {
    private Solution404 solution = Solution404.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode tree = makeTree(3,9,20,null,null,15,7);
        assertEquals(24, solution.sumOfLeftLeaves(tree));
    }

    @Test
    public void should_pass_2() {
        TreeNode tree = makeTree(1);
        assertEquals(0, solution.sumOfLeftLeaves(tree));
    }

    @Test
    public void should_pass_3() {
        TreeNode tree = makeTree(1, 2, 3);
        assertEquals(2, solution.sumOfLeftLeaves(tree));
    }

    @Test
    public void should_pass_4() {
        TreeNode tree = makeTree(1, null, 3);
        assertEquals(0, solution.sumOfLeftLeaves(tree));
    }

    @Test
    public void should_pass_5() {
        assertEquals(0, solution.sumOfLeftLeaves(null));
    }

    @Test
    public void should_pass_6() {
        TreeNode tree = makeTree(1,2,3,4,5);
        assertEquals(4, solution.sumOfLeftLeaves(tree));
    }

    @Test
    public void should_pass_7() {
        TreeNode tree = makeTree(-9,-3,2,null,4,4,0,-6,null,-5);
        assertEquals(-11, solution.sumOfLeftLeaves(tree));
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