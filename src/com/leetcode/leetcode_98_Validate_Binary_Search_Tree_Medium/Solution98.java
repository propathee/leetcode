package com.leetcode.leetcode_98_Validate_Binary_Search_Tree_Medium;

import java.util.Stack;

abstract class Solution98 {
    public abstract boolean isValidBST(TreeNode root);

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    static Solution98 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution98 {
        @Override
        public boolean isValidBST(TreeNode root) {
            return (root.left == null || (isValidBST(root.left) && findMax(root.left) < root.val))
                && (root.right == null || (isValidBST(root.right) && findMin(root.right) > root.val));
        }

        private int findMin(TreeNode root) {
            int min = 0;
            while (root != null) {
                min = root.val;
                root = root.left;
            }
            return min;
        }

        private int findMax(TreeNode root) {
            int max = 0;
            while (root != null) {
                max = root.val;
                root = root.right;
            }
            return max;
        }
    }

    private static class S2 extends Solution98 {
        @Override
        public boolean isValidBST(TreeNode root) {
            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean helper(TreeNode root, long min, long max) {
            if (root == null) {
                return true;
            } else if (root.val <= min || root.val >= max) {
                return false;
            } else {
                return helper(root.left, min, root.val) && helper(root.right, root.val, max);
            }
        }
    }

    private static class S3 extends Solution98 {
        @Override
        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }

        private boolean helper(TreeNode root, TreeNode min, TreeNode max) {
            if (root == null) {
                return true;
            } else if ((min != null && min.val >= root.val) || (max != null && max.val <= root.val)) {
                return false;
            } else {
                return helper(root.left, min, root) && helper(root.right, root, max);
            }
        }
    }

    private static class S4 extends Solution98 {
        private TreeNode preNode = null;

        @Override
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (!isValidBST(root.left)) {
                return false;
            }
            if (preNode != null && preNode.val >= root.val) {
                return false;
            }
            preNode = root;
            return isValidBST(root.right);
        }
    }

    private static class S5 extends Solution98 {
        @Override
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            while (root != null || !stack.isEmpty()) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    if (pre != null && pre.val >= root.val) {
                        return false;
                    }
                    pre = root;
                    root = root.right;
                }
            }
            return true;
        }
    }
}
