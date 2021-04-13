package com.leetcode.leetcode_117_Populating_Next_Right_Pointers_in_Each_Node_II_Medium;

import com.leetcode.utils.Node;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

abstract class Solution117 {
    public abstract Node connect(Node root);

    static Solution117 newSolution() {
        return new S6();
    }

    private static class S1 extends Solution117 {
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
                    if (i != size - 1 && !queue.isEmpty()) {
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

    private static class S2 extends Solution117 {
        @Override
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Deque<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean isHead = true;
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    if (node.left != null) {
                        if (isHead) {
                            isHead = false;
                        } else {
                            queue.peekLast().next = node.left;
                        }
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        if (isHead) {
                            isHead = false;
                        } else {
                            queue.peekLast().next = node.right;
                        }
                        queue.offer(node.right);
                    }
                }
            }
            return root;
        }
    }

    private static class S3 extends Solution117 {
        @Override
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                Node pre = null;
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                        if (pre != null) {
                            pre.next = node.left;
                        }
                        pre = node.left;
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                        if (pre != null) {
                            pre.next = node.right;
                        }
                        pre = node.right;
                    }
                }
            }
            return root;
        }
    }

    private static class S4 extends Solution117 {
        @Override
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                Node cur = queue.poll(), pre = null;
                while (cur != null) {
                    if (cur.left != null) {
                        if (pre != null) {
                            pre.next = cur.left;
                        }
                        queue.offer(cur.left);
                        pre = cur.left;
                    }
                    if (cur.right != null) {
                        if (pre != null) {
                            pre.next = cur.right;
                        }
                        queue.offer(cur.right);
                        pre = cur.right;
                    }
                    cur = cur.next;
                }
            }
            return root;
        }
    }

    private static class S5 extends Solution117 {
        @Override
        public Node connect(Node root) {
            Node node = root;
            while (node != null) {
                Node headInNextLevel = null;
                Node preNodeInNextLevel = null;
                while (node != null) {
                    if (node.left != null) {
                        if (preNodeInNextLevel != null) {
                            preNodeInNextLevel.next = node.left;
                        } else {
                            headInNextLevel = node.left;
                        }
                        preNodeInNextLevel = node.left;
                    }
                    if (node.right != null) {
                        if (preNodeInNextLevel != null) {
                            preNodeInNextLevel.next = node.right;
                        } else {
                            headInNextLevel = node.right;
                        }
                        preNodeInNextLevel = node.right;
                    }
                    node = node.next;
                }
                node = headInNextLevel;
            }
            return root;
        }
    }

    private static class S6 extends Solution117 {
        @Override
        public Node connect(Node root) {
            Node node = root;
            while (node != null) {
                Node headInNextLevel = new Node();
                Node preNodeInNextLevel = headInNextLevel;
                while (node != null) {
                    if (node.left != null) {
                        preNodeInNextLevel.next = node.left;
                        preNodeInNextLevel = node.left;
                    }
                    if (node.right != null) {
                        preNodeInNextLevel.next = node.right;
                        preNodeInNextLevel = node.right;
                    }
                    node = node.next;
                }
                node = headInNextLevel.next;
            }
            return root;
        }
    }
}
