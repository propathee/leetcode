package com.leetcode.leetcode_144_Binary_Tree_Preorder_Traversal_Medium;

import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

abstract class Solution144 {
    public abstract List<Integer> preorderTraversal(TreeNode root);

    static Solution144 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution144 {
        @Override
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> values = new ArrayList<>();
            preorder(root, values);
            return values;
        }

        private void preorder(TreeNode root, List<Integer> values) {
            if (root == null) {
                return;
            }
            values.add(root.val);
            preorder(root.left, values);
            preorder(root.right, values);
        }
    }

    private static class S2 extends Solution144 {
        @Override
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> values = new ArrayList<>();
            if (root == null) {
                return values;
            }
            values.add(root.val);
            values.addAll(preorderTraversal(root.left));
            values.addAll(preorderTraversal(root.right));
            return values;
        }
    }

    private static class S3 extends Solution144 {
        @Override
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> values = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                values.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return values;
        }
    }

    private static class S4 extends Solution144 {
        @Override
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            TreeNode node = root;
            while (node != null) {
                if (node.left == null) {
                    res.add(node.val);
                    node = node.right;
                } else {
                    TreeNode pre = node.left;
                    while (pre.right != null && pre.right != node) {
                        pre = pre.right;
                    }
                    if (pre.right == null) {
                        pre.right = node;
                        res.add(node.val);
                        node = node.left;
                    } else {
                        node = node.right;
                        pre.right = null;
                    }
                }
            }
            return res;
        }
    }
}
