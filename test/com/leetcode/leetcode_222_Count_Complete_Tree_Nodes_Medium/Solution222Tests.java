package com.leetcode.leetcode_222_Count_Complete_Tree_Nodes_Medium;

import com.leetcode.utils.TreeNode;
import org.junit.Test;

import static com.leetcode.utils.TreeTests.makeTree;
import static org.junit.Assert.*;

public class Solution222Tests {
    private Solution222 solution = Solution222.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(1,2,3,4,5,6);
        assertEquals(6, solution.countNodes(root));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = null;
        assertEquals(0, solution.countNodes(root));
    }

    @Test
    public void should_pass_3() {
        TreeNode root = makeTree(1);
        assertEquals(1, solution.countNodes(root));
    }

    @Test
    public void should_pass_4() {
        TreeNode root = makeTree(1,2,3,4,5,6,7);
        assertEquals(7, solution.countNodes(root));
    }

    @Test
    public void should_pass_5() {
        TreeNode root = makeTree(1,2,3,4,5);
        assertEquals(5, solution.countNodes(root));
    }

    @Test
    public void should_pass_6() {
        TreeNode root = makeTree(1,2,3,4);
        assertEquals(4, solution.countNodes(root));
    }
}