package com.leetcode.leetcode_589_N_ary_Tree_Preorder_Traversal_Easy;

import com.leetcode.leetcode_589_N_ary_Tree_Preorder_Traversal_Easy.Solution589.Node;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class Solution589Tests {
    private Solution589 solution = Solution589.newSolution();

    @Test
    public void should_pass_1() {
        Node root = makeNaryTree(1,null,3,2,4,null,5,6);
        List<Integer> expect = Arrays.asList(1,3,5,6,2,4);
        assertEquals(expect, solution.preorder(root));
    }

    @Test
    public void should_pass_2() {
        Node root = makeNaryTree(1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14);
        List<Integer> expect = Arrays.asList(1,2,3,6,7,11,14,4,8,12,5,9,13,10);
        assertEquals(expect, solution.preorder(root));
    }

    private Node makeNaryTree(Integer... values) {
        Node root = new Node(values[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int i = 2;
        while (!queue.isEmpty() && i < values.length) {
            Node node = queue.poll();
            List<Node> childs = new ArrayList<>();
            for (;i < values.length && values[i] != null; i++) {
                Node child = new Node(values[i]);
                childs.add(child);
                queue.offer(child);
            }
            node.children = childs;
            i++;
        }
        return root;
    }
}