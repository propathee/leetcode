package com.leetcode.leetcode_116_Populating_Next_Right_Pointers_in_Each_Node_Medium;

import com.leetcode.utils.Node;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static com.leetcode.utils.NodeTests.assertRightNeighbourConnectedTreeEquals;

public class Solution116Tests {
    private Solution116 solution = Solution116.newSolution();

    @Test
    public void should_pass_1() {
        Node root = makePerfectTree(1,2,3,4,5,6,7);
        Node expect = makePerfectTreeWithNextPointersPopulated(1,2,3,4,5,6,7);
        assertRightNeighbourConnectedTreeEquals(expect, solution.connect(root));
    }

    private Node makePerfectTree(Integer... values) {
        Queue<Integer> q1 = new LinkedList<>(Arrays.asList(values));
        Queue<Node> q2 = new LinkedList<>();
        Node root = new Node(q1.poll());
        q2.offer(root);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int size = q2.size();
            for (int i = 0; i < size; i++) {
                Node node = q2.poll();
                node.left = new Node(q1.poll());
                node.right = new Node(q1.poll());
                q2.offer(node.left);
                q2.offer(node.right);
            }
        }
        return root;
    }

    private Node makePerfectTreeWithNextPointersPopulated(Integer... values) {
        Queue<Integer> q1 = new LinkedList<>(Arrays.asList(values));
        Queue<Node> q2 = new LinkedList<>();
        Node root = new Node(q1.poll());
        q2.offer(root);
        while (!q2.isEmpty()) {
            int size = q2.size();
            for (int i = 0; i < size; i++) {
                Node node = q2.poll();
                if (i < (size - 1)) {
                    node.next = q2.peek();
                }
                if (!q1.isEmpty()) {
                    node.left = new Node(q1.poll());
                    node.right = new Node(q1.poll());
                    q2.offer(node.left);
                    q2.offer(node.right);
                }
            }
        }
        return root;
    }
}