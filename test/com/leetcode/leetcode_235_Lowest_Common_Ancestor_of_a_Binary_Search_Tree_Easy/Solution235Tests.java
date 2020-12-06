package com.leetcode.leetcode_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree_Easy;

import com.leetcode.leetcode_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree_Easy.Solution235.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution235Tests {
    private Solution235 solution = new Solution235();

    @Test
    public void should_pass_1() {
        TreeNode tree = makeTree(6,2,8,0,4,7,9,null,null,3,5);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        int expect = 6;
        assertEquals(expect, solution.lowestCommonAncestor_3(tree, p, q).val);
    }

    @Test
    public void should_pass_2() {
        TreeNode tree = makeTree(6,2,8,0,4,7,9,null,null,3,5);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        int expect = 2;
        assertEquals(expect, solution.lowestCommonAncestor_3(tree, p, q).val);
    }

    @Test
    public void should_pass_3() {
        TreeNode tree = makeTree(2,1);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        int expect = 2;
        assertEquals(expect, solution.lowestCommonAncestor_3(tree, p, q).val);
    }

    private TreeNode makeTree(Integer... values) {
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode node = queue.poll();

            if (values[i] != null) {
                node.left = new TreeNode(values[i]);
                queue.offer(node.left);
            }
            i++;
            if (i < values.length) {
                if (values[i] != null) {
                    node.right = new TreeNode(values[i]);
                    queue.offer(node.right);
                }
                i++;
            }
        }
        return root;
    }
}