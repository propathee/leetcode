package com.leetcode.leetcode_144_Binary_Tree_Preorder_Traversal_Medium;

import com.leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.leetcode.utils.TreeTests.makeTree;
import static org.junit.Assert.*;

public class Solution144Tests {
    private Solution144 solution = Solution144.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(1,null,2,3);
        List<Integer> preorder = Arrays.asList(1,2,3);
        assertEquals(preorder, solution.preorderTraversal(root));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = null;
        List<Integer> preorder = new ArrayList<>();
        assertEquals(preorder, solution.preorderTraversal(root));
    }

    @Test
    public void should_pass_3() {
        TreeNode root = makeTree(1);
        List<Integer> preorder = Arrays.asList(1);
        assertEquals(preorder, solution.preorderTraversal(root));
    }

    @Test
    public void should_pass_4() {
        TreeNode root = makeTree(1,2);
        List<Integer> preorder = Arrays.asList(1,2);
        assertEquals(preorder, solution.preorderTraversal(root));
    }

    @Test
    public void should_pass_5() {
        TreeNode root = makeTree(1,null,2);
        List<Integer> preorder = Arrays.asList(1,2);
        assertEquals(preorder, solution.preorderTraversal(root));
    }
}