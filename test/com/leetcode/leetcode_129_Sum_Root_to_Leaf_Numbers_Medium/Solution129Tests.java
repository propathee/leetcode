package com.leetcode.leetcode_129_Sum_Root_to_Leaf_Numbers_Medium;

import com.leetcode.utils.TreeNode;
import org.junit.Test;

import static com.leetcode.utils.TreeTests.makeTree;
import static org.junit.Assert.*;

public class Solution129Tests {
    private Solution129 solution = Solution129.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(1,2,3);
        assertEquals(25, solution.sumNumbers(root));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(4,9,0,5,1);
        assertEquals(1026, solution.sumNumbers(root));
    }
}