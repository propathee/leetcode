package com.leetcode.leetcode_257_Binary_Tree_Paths_Easy;

import com.leetcode.leetcode_257_Binary_Tree_Paths_Easy.Solution257.TreeNode;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution257Tests {
    private Solution257 solution = new Solution257();

    @Test
    public void should_pass_1() {
        List<String> actual = solution.binaryTreePaths(makeTree(1,2,3,null,5));
        List<String> expect = Arrays.asList("1->2->5", "1->3");
        assertEquals(expect, actual);
    }

    @Test
    public void should_pass_2() {
        List<String> actual = solution.binaryTreePaths(makeTree(1));
        List<String> expect = Arrays.asList("1");
        assertEquals(expect, actual);
    }

    @Test
    public void should_pass_3() {
        List<String> actual = solution.binaryTreePaths(makeTree(1, 2));
        List<String> expect = Arrays.asList("1->2");
        assertEquals(expect, actual);
    }

    @Test
    public void should_pass_4() {
        List<String> actual = solution.binaryTreePaths(makeTree(1,null,2));
        List<String> expect = Arrays.asList("1->2");
        assertEquals(expect, actual);
    }

    @Test
    public void should_pass_5() {
        List<String> actual = solution.binaryTreePaths(makeTree(1,2,null,3,4));
        List<String> expect = Arrays.asList("1->2->3", "1->2->4");
        assertEquals(expect, actual);
    }

    @Test
    public void should_pass_6() {
        List<String> actual = solution.binaryTreePaths(makeTree(1,2,3,4,5,6));
        List<String> expect = Arrays.asList("1->2->4", "1->2->5", "1->3->6");
        assertEquals(expect, actual);
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
            if (i < values.length && values[i] != null) {
                node.right = new TreeNode(values[i]);
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}