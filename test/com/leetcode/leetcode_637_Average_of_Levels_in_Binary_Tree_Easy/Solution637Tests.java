package com.leetcode.leetcode_637_Average_of_Levels_in_Binary_Tree_Easy;

import com.leetcode.leetcode_637_Average_of_Levels_in_Binary_Tree_Easy.Solution637.TreeNode;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class Solution637Tests {
    private Solution637 solution = Solution637.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(3,9,20,null,null,15,7);
        List<Double> expect = makeResult(3, 14.5, 11);
        assertEquals(expect, solution.averageOfLevels(root));
    }

    private TreeNode makeTree(Integer... values) {
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int i = 1; i < values.length; i += 2) {
            TreeNode node = q.poll();
            if (values[i] != null) {
                node.left = new TreeNode(values[i]);
                q.offer(node.left);
            }
            if (i + 1 < values.length && values[i + 1] != null) {
                node.right = new TreeNode(values[i + 1]);
                q.offer(node.right);
            }
        }
        return root;
    }

    private List<Double> makeResult(double... nums) {
        List<Double> res = new ArrayList<>();
        for (double n : nums) {
            res.add(n);
        }
        return res;
    }
}