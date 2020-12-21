package com.leetcode.leetcode_501_Find_Mode_in_Binary_Search_Tree_Easy;

import com.leetcode.leetcode_501_Find_Mode_in_Binary_Search_Tree_Easy.Solution501.TreeNode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution501Tests {
    private Solution501 solution = Solution501.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(1,null,2,2);
        int[] expect = new int[] {2};
        assertPass(expect, solution.findMode(root));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(2,1,2);
        int[] expect = new int[] {2};
        assertPass(expect, solution.findMode(root));
    }

    @Test
    public void should_pass_3() {
        int[] expect = new int[0];
        assertPass(expect, solution.findMode(null));
    }

    @Test
    public void should_pass_4() {
        TreeNode root = makeTree(1);
        int[] expect = new int[] {1};
        assertPass(expect, solution.findMode(root));
    }

    @Test
    public void should_pass_5() {
        TreeNode root = makeTree(1,1,2,1,null,null,2);
        int[] expect = new int[] {1};
        assertPass(expect, solution.findMode(root));
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

    private void assertPass(int[] expect, int[] actual) {
        Arrays.sort(expect);
        Arrays.sort(actual);
        assertArrayEquals(expect, actual);
    }
}