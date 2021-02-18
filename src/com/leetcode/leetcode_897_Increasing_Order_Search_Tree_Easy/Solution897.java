package com.leetcode.leetcode_897_Increasing_Order_Search_Tree_Easy;

import java.util.ArrayList;
import java.util.List;

abstract class Solution897 {
    public abstract TreeNode increasingBST(TreeNode root);

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }

    static Solution897 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution897 {
        @Override
        public TreeNode increasingBST(TreeNode root) {
            List<Integer> values = new ArrayList<>();
            inorder(root, values);
            TreeNode dummy = new TreeNode();
            TreeNode node = dummy;
            for (int val : values) {
                node.right = new TreeNode(val);
                node = node.right;
            }
            return dummy.right;
        }

        private void inorder(TreeNode root, List<Integer> values) {
            if (root == null) {
                return;
            }
            inorder(root.left, values);
            values.add(root.val);
            inorder(root.right, values);
        }
    }

    private static class S2 extends Solution897 {
        @Override
        public TreeNode increasingBST(TreeNode root) {
            TreeNode dummy = new TreeNode();
            inorder(root, dummy);
            return dummy.right;
        }

        private TreeNode inorder(TreeNode source, TreeNode target) {
            if (source == null) {
                return target;
            }
            target = inorder(source.left, target);
            target.right = new TreeNode(source.val);
            return inorder(source.right, target.right);
        }
    }

    private static class S3 extends Solution897 {
        @Override
        public TreeNode increasingBST(TreeNode root) {
            return increasingBST(root, null);
        }

        private TreeNode increasingBST(TreeNode root, TreeNode tail) {
            if (root == null) {
                return tail;
            }
            TreeNode res = increasingBST(root.left, root);
            root.left  = null;
            root.right = increasingBST(root.right, tail);
            return res;
        }
    }

    private static class S4 extends Solution897 {
        @Override
        public TreeNode increasingBST(TreeNode root) {
            return increasingBST(root, null);
        }

        private TreeNode increasingBST(TreeNode root, TreeNode tail) {
            TreeNode res = root;
            if (root.left != null) {
                res = increasingBST(root.left, root);
                root.left = null;
            }
            if (root.right != null) {
                root.right = increasingBST(root.right, tail);
            } else {
                root.right = tail;
            }
            return res;
        }
    }
}
