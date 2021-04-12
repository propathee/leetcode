package com.leetcode.leetcode_114_Flatten_Binary_Tree_to_Linked_List_Medium;

import com.leetcode.utils.TreeNode;
import org.junit.Test;

import static com.leetcode.utils.TreeTests.assertTreeEquals;
import static com.leetcode.utils.TreeTests.makeTree;
import static org.junit.Assert.*;

public class Solution114Tests {
    private Solution114 solution = Solution114.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(1,2,5,3,4,null,6);
        TreeNode expect = makeTree(1,null,2,null,3,null,4,null,5,null,6);
        solution.flatten(root);
        assertTreeEquals(expect, root);
    }

    @Test
    public void should_pass_2() {
        TreeNode root = null;
        solution.flatten(root);
        assertNull(root);
    }

    @Test
    public void should_pass_3() {
        TreeNode root = makeTree(0);
        TreeNode expect = makeTree(0);
        solution.flatten(root);
        assertTreeEquals(expect, root);
    }
}