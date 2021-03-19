package com.leetcode.leetcode_965_Univalued_Binary_Tree_Easy;

abstract class Solution965 {
    public abstract boolean isUnivalTree(TreeNode root);

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

    static Solution965 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution965 {
        private int number;

        @Override
        public boolean isUnivalTree(TreeNode root) {
            number = root.val;
            return preorder(root);
        }

        private boolean preorder(TreeNode root) {
            if (root == null) {
                return true;
            }
            if (root.val != number) {
                return false;
            }
            return preorder(root.left) && preorder(root.right);
        }
    }

    private static class S2 extends Solution965 {
        @Override
        public boolean isUnivalTree(TreeNode root) {
            return (root.left == null || (root.left.val == root.val && isUnivalTree(root.left)))
                && (root.right == null || (root.right.val == root.val && isUnivalTree(root.right)));
        }
    }
}
