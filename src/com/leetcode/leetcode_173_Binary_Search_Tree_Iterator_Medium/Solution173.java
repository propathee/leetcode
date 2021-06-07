package com.leetcode.leetcode_173_Binary_Search_Tree_Iterator_Medium;

import com.leetcode.utils.TreeNode;

import java.util.Stack;

abstract class Solution173 {
    static abstract class BSTIterator {
        public abstract int next();

        public abstract boolean hasNext();
    }

    static BSTIterator iterator(TreeNode root) {
        return new BSTIterator2(root);
    }

    private static class BSTIterator1 extends BSTIterator {
        private Stack<TreeNode> stack;
        private TreeNode node;

        public BSTIterator1(TreeNode root) {
            stack = new Stack<>();
            node = root;
            run();
        }

        @Override
        public int next() {
            node = stack.pop();
            int val = node.val;
            node = node.right;
            run();
            return val;
        }

        private void run() {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    private static class BSTIterator2 extends BSTIterator {
        private Stack<TreeNode> stack;

        public BSTIterator2(TreeNode root) {
            stack = new Stack<>();
            push(root);
        }

        @Override
        public int next() {
            TreeNode node = stack.pop();
            push(node.right);
            return node.val;
        }

        private void push(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
