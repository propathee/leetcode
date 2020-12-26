package com.leetcode.leetcode_543_Diameter_of_Binary_Tree_Easy;

abstract class Solution543 {
    /**
     * Given a binary tree, you need to compute the length of the diameter of the tree.
     * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
     * This path may or may not pass through the root.
     */
    public abstract int diameterOfBinaryTree(TreeNode root);

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

    static Solution543 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution543 {
        @Override
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(
                Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)),
                path(root.left) + path(root.right));
        }

        private int path(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(path(root.left), path(root.right)) + 1;
        }
    }

    private static class S2 extends Solution543 {
        @Override
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return postOrder(root)[0];
        }

        private int[] postOrder(TreeNode root) {
            if (root == null) {
                return new int[2];
            }
            int[] l = postOrder(root.left);
            int[] r = postOrder(root.right);
            int diameter = Math.max(l[0], r[0]);
            return new int[] {Math.max(diameter, l[1] + r[1]), Math.max(l[1], r[1]) + 1};
        }
    }

    private static class S3 extends Solution543 {
        private int max = 0;

        @Override
        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            postOrder(root);
            return max;
        }

        private int postOrder(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int l = postOrder(root.left);
            int r = postOrder(root.right);
            max = Math.max(max, l + r);
            return Math.max(l, r) + 1;
        }
    }
}
