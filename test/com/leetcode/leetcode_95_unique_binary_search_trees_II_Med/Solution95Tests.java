package com.leetcode.leetcode_95_unique_binary_search_trees_II_Med;

import org.junit.Test;
import com.leetcode.leetcode_95_unique_binary_search_trees_II_Med.Solution95.TreeNode;

import java.util.List;

import static org.junit.Assert.*;

public class Solution95Tests {
    private Solution95 solution = Solution95.newSolution();

    @Test
    public void should_pass_1() {
        List<TreeNode> trees = solution.generateTrees(3);
    }
}