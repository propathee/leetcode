package com.leetcode.leetcode_116_Populating_Next_Right_Pointers_in_Each_Node_Medium;

import com.leetcode.utils.Node;

import java.util.LinkedList;
import java.util.Queue;

abstract class Solution116 {
    public abstract Node connect(Node root);

    static Solution116 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution116 {
        @Override
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    if (i < (size - 1)) {
                        node.next = queue.peek();
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return root;
        }
    }

    private static class S2 extends Solution116 {
        @Override
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    if (node.left != null && node.right != null) {
                        queue.offer(node.left);
                        queue.offer(node.right);
                        node.left.next = node.right;
                        if (node.next != null) {
                            node.right.next = node.next.left;
                        }
                    }
                }
            }
            return root;
        }
    }

    private static class S3 extends Solution116 {
        @Override
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            if (root.left != null && root.right != null) {
                root.left.next = root.right;
                if (root.next != null) {
                    root.right.next = root.next.left;
                }
                connect(root.left);
                connect(root.right);
            }
            return root;
        }
    }

    private static class S4 extends Solution116 {
        @Override
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Node levelHead = root, node = root;
            while (levelHead.left != null) {
                node = levelHead;
                while (node != null) {
                    if (node.left != null) {
                        node.left.next = node.right;
                        if (node.next != null) {
                            node.right.next = node.next.left;
                        }
                    }
                    node = node.next;
                }
                levelHead = levelHead.left;
            }
            return root;
        }
    }
}
