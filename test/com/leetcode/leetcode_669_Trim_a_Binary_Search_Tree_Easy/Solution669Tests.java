package com.leetcode.leetcode_669_Trim_a_Binary_Search_Tree_Easy;

import com.leetcode.leetcode_669_Trim_a_Binary_Search_Tree_Easy.Solution669.TreeNode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution669Tests {
    private Solution669 solution = Solution669.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(1,0,2);
        TreeNode expect = makeTree(1,null,2);
        assertPass(expect, solution.trimBST(root, 1, 2));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(3,0,4,null,2,null,null,1);
        TreeNode expect = makeTree(3,2,null,1);
        assertPass(expect, solution.trimBST(root, 1, 3));
    }

    @Test
    public void should_pass_3() {
        TreeNode root = makeTree(1);
        TreeNode expect = makeTree(1);
        assertPass(expect, solution.trimBST(root, 1, 2));
    }

    @Test
    public void should_pass_4() {
        TreeNode root = makeTree(1,null,2);
        TreeNode expect = makeTree(1,null,2);
        assertPass(expect, solution.trimBST(root, 1, 3));
    }

    @Test
    public void should_pass_5() {
        TreeNode root = makeTree(1,null,2);
        TreeNode expect = makeTree(2);
        assertPass(expect, solution.trimBST(root, 2, 4));
    }

    @Test
    public void should_pass_6() {
        TreeNode root = makeTree(1);
        assertNull(solution.trimBST(root, 2, 4));
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

    private void assertPass(TreeNode expect, TreeNode actual) {
        assertTrue((expect == null && actual == null) || expect.val == actual.val);
        if (expect != null) {
            assertPass(expect.left, actual.left);
            assertPass(expect.right, actual.right);
        }
    }
}