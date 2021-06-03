package com.leetcode.leetcode_99_Recover_Binary_Search_Tree_Medium;

import com.leetcode.utils.TreeNode;
import org.junit.Test;

import static com.leetcode.utils.TreeTests.assertTreeEquals;
import static com.leetcode.utils.TreeTests.makeTree;
import static org.junit.Assert.*;

public class Solution99Tests {
    private Solution99 solution = Solution99.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(1,3,null,null,2);
        TreeNode expect = makeTree(3,1,null,null,2);
        solution.recoverTree(root);
        assertTreeEquals(expect, root);
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(3,1,4,null,null,2);
        TreeNode expect = makeTree(2,1,4,null,null,3);
        solution.recoverTree(root);
        assertTreeEquals(expect, root);
    }
}