package com.leetcode.leetcode_872_Leaf_Similar_Trees_Easy;

import com.leetcode.leetcode_872_Leaf_Similar_Trees_Easy.Solution872.TreeNode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution872Tests {
    private Solution872 solution = Solution872.newSolution();

    @Test
    public void should_pass_1() {
        TreeNode root1 = makeTree(3,5,1,6,2,9,8,null,null,7,4);
        TreeNode root2 = makeTree(3,5,1,6,7,4,2,null,null,null,null,null,null,9,8);
        assertTrue(solution.leafSimilar(root1, root2));
    }

    @Test
    public void should_pass_2() {
        TreeNode root1 = makeTree(1);
        TreeNode root2 = makeTree(1);
        assertTrue(solution.leafSimilar(root1, root2));
    }

    @Test
    public void should_pass_3() {
        TreeNode root1 = makeTree(1);
        TreeNode root2 = makeTree(2);
        assertFalse(solution.leafSimilar(root1, root2));
    }

    @Test
    public void should_pass_4() {
        TreeNode root1 = makeTree(1,2);
        TreeNode root2 = makeTree(2,2);
        assertTrue(solution.leafSimilar(root1, root2));
    }

    @Test
    public void should_pass_5() {
        TreeNode root1 = makeTree(1,2,3);
        TreeNode root2 = makeTree(1,3,2);
        assertFalse(solution.leafSimilar(root1, root2));
    }

    @Test
    public void should_pass_6() {
        TreeNode root1 = makeTree(3,5,1,6,2,9,8,null,null,7,14);
        TreeNode root2 = makeTree(3,5,1,6,71,4,2,null,null,null,null,null,null,9,8);
        assertFalse(solution.leafSimilar(root1, root2));
    }

    private TreeNode makeTree(Integer... values) {
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>(Arrays.asList(values).subList(1, values.length));
        q1.offer(root);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node = q1.poll();
            if (node == null) {
                continue;
            }
            Integer l = q2.poll();
            node.left = l == null ? null : new TreeNode(l);
            q1.offer(node.left);
            Integer r = q2.isEmpty() ? null : q2.poll();
            node.right = r == null ? null : new TreeNode(r);
            q1.offer(node.right);
        }
        return root;
    }
}