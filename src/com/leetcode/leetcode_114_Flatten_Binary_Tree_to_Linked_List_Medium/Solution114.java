package com.leetcode.leetcode_114_Flatten_Binary_Tree_to_Linked_List_Medium;

import com.leetcode.utils.TreeNode;

import java.util.Stack;

abstract class Solution114 {
    public abstract void flatten(TreeNode root);

    static Solution114 newSolution() {
        return new S6();
    }

    private static class S1 extends Solution114 {
        private TreeNode preNode = null;

        @Override
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            preNode = root;
            TreeNode tmp = root.right;
            root.right = root.left;
            root.left = null;
            flatten(root.right);
            preNode.right = tmp;
            flatten(tmp);
        }
    }

    private static class S2 extends Solution114 {
        private TreeNode preNode = null;

        @Override
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            preNode = root;
            TreeNode tmp = root.right;
            flatten(root.left);
            root.right = root.left;
            root.left = null;
            preNode.right = tmp;
            flatten(tmp);
        }
    }

    private static class S3 extends Solution114 {
        private TreeNode preNode = null;

        @Override
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            flatten(root.right);
            flatten(root.left);
            root.right = preNode;
            root.left = null;
            preNode = root;
        }
    }

    private static class S4 extends Solution114 {
        private TreeNode preNode = new TreeNode();

        @Override
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            preNode.right = root;
            preNode.left = null;
            preNode = root;
            TreeNode right = root.right;
            flatten(root.left);
            flatten(right);
        }
    }

    private static class S5 extends Solution114 {
        @Override
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            TreeNode preNode = new TreeNode();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                preNode.right = node;
                preNode.left = null;
                preNode = node;
            }
        }
    }

    private static class S6 extends Solution114 {
        @Override
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (!stack.isEmpty()) {
                    node.right = stack.peek();
                }
                node.left = null;
            }
        }
    }
}
