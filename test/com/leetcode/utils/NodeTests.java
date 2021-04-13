package com.leetcode.utils;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class NodeTests {
    public static Node makeRightNeighbourUnconnectedTree(Integer... values) {
        Node root = new Node(values[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        for (int i = 1; i < values.length; i += 2) {
            Node node = q.poll();
            if (values[i] != null) {
                node.left = new Node(values[i]);
                q.offer(node.left);
            }
            if (i + 1 < values.length && values[i + 1] != null) {
                node.right = new Node(values[i + 1]);
                q.offer(node.right);
            }
        }
        return root;
    }

    public static Node makeRightNeighbourConnectedTree(Integer... values) {
        Node root = new Node(values[0]);
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                Node node = q.poll();
                if (j != size - 1 && !q.isEmpty()) {
                    node.next = q.peek();
                }
                if (i < values.length && values[i] != null) {
                    node.left = new Node(values[i]);
                    q.offer(node.left);
                }
                i++;
                if (i < values.length && values[i] != null) {
                    node.right = new Node(values[i]);
                    q.offer(node.right);
                }
                i++;
            }
        }
        return root;
    }

    public static void assertRightNeighbourConnectedTreeEquals(Node expect, Node actual) {
        if (expect == null) {
            assertNull(actual);
        } else {
            assertEquals(expect.val, actual.val);
            assertRightNeighbourConnectedTreeEquals(expect.left, actual.left);
            assertRightNeighbourConnectedTreeEquals(expect.right, actual.right);
            if (expect.next == null) {
                assertNull(actual.next);
            } else {
                assertEquals(expect.next.val, actual.next.val);
            }
        }
    }
}