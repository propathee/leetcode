package com.leetcode.leetcode_589_N_ary_Tree_Preorder_Traversal_Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

abstract class Solution589 {
    public abstract List<Integer> preorder(Node root);

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

    static Solution589 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution589 {
        private List<Integer> res = new ArrayList<>();

        @Override
        public List<Integer> preorder(Node root) {
            doPreorder(root);
            return res;
        }

        private void doPreorder(Node root) {
            if (root != null) {
                res.add(root.val);
                if (root.children != null) {
                    for (Node child : root.children) {
                        doPreorder(child);
                    }
                }
            }
        }
    }

    private static class S2 extends Solution589 {
        @Override
        public List<Integer> preorder(Node root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                res.add(node.val);
                if (node.children != null) {
                    for (int i = node.children.size() - 1; i >= 0; i--) {
                        stack.push(node.children.get(i));
                    }
                }
            }
            return res;
        }
    }
}
