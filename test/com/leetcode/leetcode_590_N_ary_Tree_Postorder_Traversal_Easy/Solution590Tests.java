package com.leetcode.leetcode_590_N_ary_Tree_Postorder_Traversal_Easy;

import com.leetcode.leetcode_590_N_ary_Tree_Postorder_Traversal_Easy.Solution590.Node;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class Solution590Tests {
    private Solution590 solution = Solution590.newSolution();

    @Test
    public void should_pass_1() {
        Node root = makeNaryTree(1,null,3,2,4,null,5,6);
        List<Integer> expect = Arrays.asList(5,6,3,2,4,1);
        assertEquals(expect, solution.postorder(root));
    }

    @Test
    public void should_pass_2() {
        Node root = makeNaryTree(1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14);
        List<Integer> expect = Arrays.asList(2,6,14,11,7,3,12,8,4,13,9,10,5,1);
        assertEquals(expect, solution.postorder(root));
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