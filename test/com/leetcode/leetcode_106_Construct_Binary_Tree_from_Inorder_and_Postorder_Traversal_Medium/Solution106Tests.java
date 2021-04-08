package com.leetcode.leetcode_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_Medium;

import com.leetcode.utils.TreeNode;
import org.junit.Test;

import static com.leetcode.utils.TreeTests.assertTreeEquals;
import static com.leetcode.utils.TreeTests.makeTree;
import static org.junit.Assert.*;

public class Solution106Tests {
    private Solution106 solution = Solution106.newSolution();

    @Test
    public void should_pass_1() {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode expect = makeTree(3,9,20,null,null,15,7);
        assertTreeEquals(expect, solution.buildTree(inorder, postorder));
    }

    @Test
    public void should_pass_2() {
        int[] inorder = {-1};
        int[] postorder = {-1};
        TreeNode expect = makeTree(-1);
        assertTreeEquals(expect, solution.buildTree(inorder, postorder));
    }
}