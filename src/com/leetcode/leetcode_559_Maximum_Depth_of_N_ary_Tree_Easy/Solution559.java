package com.leetcode.leetcode_559_Maximum_Depth_of_N_ary_Tree_Easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

abstract class Solution559 {
    public abstract int maxDepth(Node root);

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

    static Solution559 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution559 {
        @Override
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            if (root.children == null || root.children.isEmpty()) {
                return 1;
            }
            int max = 0;
            for (Node child : root.children) {
                max = Math.max(maxDepth(child), max);
            }
            return max + 1;
        }
    }

    private static class S2 extends Solution559 {
        @Override
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            int max = 0;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                max++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    if (node.children != null) {
                        for (Node child : node.children) {
                            queue.offer(child);
                        }
                    }
                }
            }
            return max;
        }
    }

    private static class S3 extends Solution559 {
        @Override
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            int max = 0;
            Stack<Node> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            stack1.push(root);
            stack2.push(1);
            while (!stack1.isEmpty()) {
                Node node = stack1.pop();
                int depth = stack2.pop();
                max = Math.max(depth, max);
                if (node.children != null && !node.children.isEmpty()) {
                    depth++;
                    for (Node child : node.children) {
                        stack1.push(child);
                        stack2.push(depth);
                    }
                }
            }
            return max;
        }
    }
}
