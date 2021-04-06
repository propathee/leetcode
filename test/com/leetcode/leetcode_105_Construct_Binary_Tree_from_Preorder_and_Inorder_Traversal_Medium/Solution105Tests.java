package com.leetcode.leetcode_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_Medium;

import com.leetcode.utils.TreeNode;
import org.junit.Test;

import static com.leetcode.utils.TreeTests.assertTreeEquals;
import static com.leetcode.utils.TreeTests.makeTree;
import static org.junit.Assert.*;

public class Solution105Tests {
    private Solution105 solution = Solution105.newSolution();

    @Test
    public void should_pass_1() {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode expect = makeTree(3,9,20,null,null,15,7);
        assertTreeEquals(expect, solution.buildTree(preorder, inorder));
    }

    @Test
    public void should_pass_2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode expect = makeTree(-1);
        assertTreeEquals(expect, solution.buildTree(preorder, inorder));
    }
}