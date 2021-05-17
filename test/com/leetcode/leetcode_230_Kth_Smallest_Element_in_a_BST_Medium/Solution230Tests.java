package com.leetcode.leetcode_230_Kth_Smallest_Element_in_a_BST_Medium;

import com.leetcode.utils.TreeNode;
import org.junit.Test;

import static com.leetcode.utils.TreeTests.makeTree;
import static org.junit.Assert.*;

public class Solution230Tests {
    private Solution230 solution = Solution230.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(3,1,4,null,2);
        assertEquals(1, solution.kthSmallest(root, 1));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(5,3,6,2,4,null,null,1);
        assertEquals(3, solution.kthSmallest(root, 3));
    }
}