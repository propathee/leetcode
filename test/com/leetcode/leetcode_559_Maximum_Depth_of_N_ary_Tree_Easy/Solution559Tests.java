package com.leetcode.leetcode_559_Maximum_Depth_of_N_ary_Tree_Easy;

import com.leetcode.leetcode_559_Maximum_Depth_of_N_ary_Tree_Easy.Solution559.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.*;

public class Solution559Tests {
    private Solution559 solution = Solution559.newSolution();

    @Test
    public void should_pass_1() {
        Node root = makeTree(1,null,3,2,4,null,5,6);
        assertEquals(3, solution.maxDepth(root));
    }

    @Test
    public void should_pass_2() {
        Node root = makeTree(1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14);
        assertEquals(5, solution.maxDepth(root));
    }

    private Node makeTree(Integer... values) {
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