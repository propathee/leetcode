package com.leetcode.leetcode_530_Minimum_Absolute_Difference_in_BST_Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

abstract class Solution530 {
    /**
     * Given a binary search tree with non-negative values,
     * find the minimum absolute difference between values of any two nodes.
     * @param root There are at least two nodes in this BST.
     */
    public abstract int getMinimumDifference(TreeNode root);

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

    static Solution530 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution530 {
        @Override
        public int getMinimumDifference(TreeNode root) {
            List<Integer> values = new ArrayList<>();
            inorder(root, values);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < values.size(); i++) {
                min = Math.min(values.get(i) - values.get(i - 1), min);
            }
            return min;
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

    private static class S2 extends Solution530 {
        private TreeNode preNode = null;
        private int min = Integer.MAX_VALUE;

        @Override
        public int getMinimumDifference(TreeNode root) {
            inorder(root);
            return min;
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            if (preNode != null) {
                min = Math.min(root.val - preNode.val, min);
            }
            preNode = root;
            inorder(root.right);
        }
    }

    private static class S3 extends Solution530 {
        private TreeNode preNode = null;
        private int min = Integer.MAX_VALUE;

        @Override
        public int getMinimumDifference(TreeNode root) {
            if (root == null) {
                return min;
            }
            getMinimumDifference(root.left);

            if (preNode != null) {
                min = Math.min(root.val - preNode.val, min);
            }
            preNode = root;

            getMinimumDifference(root.right);
            return min;
        }
    }

    private static class S4 extends Solution530 {
        TreeSet<Integer> treeSet = new TreeSet<>();
        private int min = Integer.MAX_VALUE;

        @Override
        public int getMinimumDifference(TreeNode root) {
            if (root == null) {
                return min;
            }
            if (treeSet.floor(root.val) != null) {
                min = Math.min(root.val - treeSet.floor(root.val), min);
            }
            if (treeSet.ceiling(root.val) != null) {
                min = Math.min(treeSet.ceiling(root.val) - root.val, min);
            }
            treeSet.add(root.val);
            getMinimumDifference(root.left);
            getMinimumDifference(root.right);
            return min;
        }
    }

    private static class S5 extends Solution530 {
        private long min = Long.MAX_VALUE;

        @Override
        public int getMinimumDifference(TreeNode root) {
            helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
            return (int) min;
        }

        private void helper(TreeNode root, long lb, long rb) {
            if (root == null) {
                return;
            }
            if (lb != Long.MIN_VALUE) {
                min = Math.min(root.val - lb, min);
            }
            if (rb != Long.MAX_VALUE) {
                min = Math.min(rb - root.val, min);
            }
            helper(root.left, lb, root.val);
            helper(root.right, root.val, rb);
        }
    }
}
