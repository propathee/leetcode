package com.leetcode.leetcode_199_Binary_Tree_Right_Side_View_Medium;

import com.leetcode.utils.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.leetcode.utils.TreeTests.makeTree;
import static org.junit.Assert.*;

public class Solution199Tests {
    private Solution199 solution = Solution199.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(1,2,3,null,5,null,4);
        List<Integer> output = Arrays.asList(1,3,4);
        assertEquals(output, solution.rightSideView(root));
    }

    @Test
    public void should_pass_2() {
        TreeNode root = makeTree(1,null,3);
        List<Integer> output = Arrays.asList(1,3);
        assertEquals(output, solution.rightSideView(root));
    }

    @Test
    public void should_pass_3() {
        TreeNode root = null;
        List<Integer> output = new ArrayList<>();
        assertEquals(output, solution.rightSideView(root));
    }
}