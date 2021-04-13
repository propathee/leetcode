package com.leetcode.leetcode_116_Populating_Next_Right_Pointers_in_Each_Node_Medium;

import com.leetcode.leetcode_116_Populating_Next_Right_Pointers_in_Each_Node_Medium.Solution116.Node;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Solution116Tests {
    private Solution116 solution = Solution116.newSolution();

    @Test
    public void should_pass_1() {
        Node root = makePerfectTree(1,2,3,4,5,6,7);
        Node expect = makePerfectTreeWithNextPointersPopulated(1,2,3,4,5,6,7);
        assertPass(expect, solution.connect(root));
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

    private void assertPass(Node expect, Node actual) {
        if (expect == null) {
            assertNull(actual);
        } else {
            assertEquals(expect.val, actual.val);
            assertPass(expect.left, actual.left);
            assertPass(expect.right, actual.right);
            if (expect.next == null) {
                assertNull(actual.next);
            } else {
                assertEquals(expect.next.val, actual.next.val);
            }
        }
    }
}