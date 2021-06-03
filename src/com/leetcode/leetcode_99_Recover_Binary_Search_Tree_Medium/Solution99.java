package com.leetcode.leetcode_99_Recover_Binary_Search_Tree_Medium;

import com.leetcode.utils.TreeNode;

import java.util.Stack;

abstract class Solution99 {
    public abstract void recoverTree(TreeNode root);

    static Solution99 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution99 {
        private TreeNode first;
        private TreeNode second;
        private TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

        @Override
        public void recoverTree(TreeNode root) {
            inorder(root);
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            if (root.val < preNode.val) {
                if (first == null) {
                    first = preNode;
                }
                second = root;
            }
            preNode = root;
            inorder(root.right);
        }
    }

    private static class S2 extends Solution99 {
        @Override
        public void recoverTree(TreeNode root) {
            TreeNode first = null;
            TreeNode second = null;
            TreeNode preNode = new TreeNode(Integer.MIN_VALUE);
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    if (node.val < preNode.val) {
                        if (first == null) {
                            first = preNode;
                            second = node;
                        } else {
                            second = node;
                            break;
                        }
                    }
                    preNode = node;

                    node = node.right;
                }
            }
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }
    }

    private static class S3 extends Solution99 {
        private TreeNode first = null;
        private TreeNode second = null;
        private TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

        @Override
        public void recoverTree(TreeNode root) {
            while (root != null) {
                TreeNode tmpNode = root.left;
                if (tmpNode == null) {
                    process(root);
                    root = root.right;
                } else {
                    while (tmpNode.right != null && tmpNode.right != root) {
                        tmpNode = tmpNode.right;
                    }
                    if (tmpNode.right == null) {
                        tmpNode.right = root;
                        root = root.left;
                    } else {
                        process(root);
                        tmpNode.right = null;
                        root = root.right;
                    }
                }
            }
            int tmp = first.val;
            first.val = second.val;
            second.val = tmp;
        }

        private void process(TreeNode root) {
            if (root.val < preNode.val) {
                if (first == null) {
                    first = preNode;
                }
                second = root;
            }
            preNode = root;
        }
    }
}
