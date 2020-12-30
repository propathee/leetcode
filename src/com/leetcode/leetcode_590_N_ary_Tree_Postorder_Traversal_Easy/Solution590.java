package com.leetcode.leetcode_590_N_ary_Tree_Postorder_Traversal_Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

abstract class Solution590 {
    public abstract List<Integer> postorder(Node root);

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static Solution590 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution590 {
        private List<Integer> res = new ArrayList<>();

        @Override
        public List<Integer> postorder(Node root) {
            doPostOrder(root);
            return res;
        }

        private void doPostOrder(Node root) {
            if (root != null) {
                if (root.children != null) {
                    for (Node child : root.children) {
                        doPostOrder(child);
                    }
                }
                res.add(root.val);
            }
        }
    }

    private static class S2 extends Solution590 {
        @Override
        public List<Integer> postorder(Node root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            boolean visited = false;
            while (!stack.isEmpty()) {
                Node node = stack.peek();
                if (hasChild(node) && !visited) {
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        stack.push(node.children.get(i));
                    }
                } else {
                    node = stack.pop();
                    res.add(node.val);
                    if (!stack.isEmpty()) {
                        Node next = stack.peek();
                        if (hasChild(next) && next.children.get(next.children.size() - 1) == node) {
                            visited = true;
                        } else {
                            visited = false;
                        }
                    }
                }
            }
            return res;
        }

        private boolean hasChild(Node root) {
            return root.children != null && !root.children.isEmpty();
        }
    }

    private static class S3 extends Solution590 {
        @Override
        public List<Integer> postorder(Node root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(root);
            stack2.push(null);
            boolean visited = false;
            while (!stack1.isEmpty()) {
                Node node = stack1.peek();
                if (hasChild(node) && !visited) {
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        stack1.push(node.children.get(i));
                        stack2.push(node);
                    }
                } else {
                    res.add(stack1.pop().val);
                    if (!stack1.isEmpty()) {
                        visited = stack1.peek() == stack2.pop();
                    }
                }
            }
            return res;
        }

        private boolean hasChild(Node root) {
            return root.children != null && !root.children.isEmpty();
        }
    }

    private static class S4 extends Solution590 {
        @Override
        public List<Integer> postorder(Node root) {
            if (root == null) {
                return new ArrayList<>();
            }
            LinkedList<Integer> res = new LinkedList<>();
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                res.addFirst(node.val);
                if (node.children != null) {
                    for (Node child : node.children) {
                        stack.push(child);
                    }
                }
            }
            return res;
        }
    }

    private static class S5 extends Solution590 {
        @Override
        public List<Integer> postorder(Node root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            Stack<Node> stack1 = new Stack<>();
            Stack<Boolean> stack2 = new Stack<>();
            stack1.push(root);
            stack2.push(null);
            boolean visited = false;
            while (!stack1.isEmpty()) {
                Node node = stack1.peek();
                if (hasChild(node) && !visited) {
                    int r = node.children.size() - 1;
                    for (int i = r; i >= 0; i--) {
                        stack1.push(node.children.get(i));
                        stack2.push(i == r);
                    }
                } else {
                    res.add(stack1.pop().val);
                    if (!stack1.isEmpty()) {
                        visited = stack2.pop();
                    }
                }
            }
            return res;
        }

        private boolean hasChild(Node root) {
            return root.children != null && !root.children.isEmpty();
        }
    }
}
