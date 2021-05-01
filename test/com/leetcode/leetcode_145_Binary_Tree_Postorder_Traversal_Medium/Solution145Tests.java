package com.leetcode.leetcode_145_Binary_Tree_Postorder_Traversal_Medium;

import com.leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.leetcode.utils.TreeTests.makeTree;
import static org.junit.Assert.*;

public class Solution145Tests {
    private Solution145 solution = Solution145.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(1,null,2,3);
        List<Integer> values = Arrays.asList(3,2,1);
        assertEquals(values, solution.postorderTraversal(root));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = null;
        List<Integer> values = new ArrayList<>();
        assertEquals(values, solution.postorderTraversal(root));
    }

    @Test
    public void should_pass_3() {
        TreeNode root = makeTree(1);
        List<Integer> values = Arrays.asList(1);
        assertEquals(values, solution.postorderTraversal(root));
    }

    @Test
    public void should_pass_4() {
        TreeNode root = makeTree(1,2);
        List<Integer> values = Arrays.asList(2,1);
        assertEquals(values, solution.postorderTraversal(root));
    }

    @Test
    public void should_pass_5() {
        TreeNode root = makeTree(1,null,2);
        List<Integer> values = Arrays.asList(2,1);
        assertEquals(values, solution.postorderTraversal(root));
    }

    @Test
    public void should_pass_6() {
        TreeNode root = makeTree(3,2,4,null,null,1);
        List<Integer> values = Arrays.asList(2,1,4,3);
        assertEquals(values, solution.postorderTraversal(root));
    }
}