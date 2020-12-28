package com.leetcode.leetcode_563_Binary_Tree_Tilt_Easy;

abstract class Solution563 {
    public abstract int findTilt(TreeNode root);

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

    static Solution563 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution563 {
        @Override
        public int findTilt(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) {
                return 0;
            }
            return findTilt(root.left) + findTilt(root.right)
                + Math.abs(sum(root.left) - sum(root.right));
        }

        private int sum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return root.val + sum(root.left) + sum(root.right);
        }
    }

    private static class S2 extends Solution563 {
        private int tilt = 0;

        @Override
        public int findTilt(TreeNode root) {
            postOrder(root);
            return tilt;
        }

        private int postOrder(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int sumL = postOrder(root.left);
            int sumR = postOrder(root.right);
            tilt += Math.abs(sumL - sumR);
            return root.val + sumL + sumR;
        }
    }

    private static class S3 extends Solution563 {
        @Override
        public int findTilt(TreeNode root) {
            int[] tilt = new int[1];
            postOrder(root, tilt);
            return tilt[0];
        }

        private int postOrder(TreeNode root, int[] tilt) {
            if (root == null) {
                return 0;
            }
            int sumL = postOrder(root.left, tilt);
            int sumR = postOrder(root.right, tilt);
            tilt[0] += Math.abs(sumL - sumR);
            return root.val + sumL + sumR;
        }
    }
}
