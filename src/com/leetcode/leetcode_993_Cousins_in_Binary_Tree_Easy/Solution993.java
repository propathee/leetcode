package com.leetcode.leetcode_993_Cousins_in_Binary_Tree_Easy;

abstract class Solution993 {
    public abstract boolean isCousins(TreeNode root, int x, int y);

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

    static Solution993 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution993 {
        private int xDepth;
        private int yDepth;
        private int xParent;
        private int yParent;

        @Override
        public boolean isCousins(TreeNode root, int x, int y) {
            preorder(root, 0, 0, x, y);
            return xDepth == yDepth && xParent != yParent;
        }

        private void preorder(TreeNode root, int depth, int parent, int x, int y) {
            if (root == null) {
                return;
            }
            if (root.val == x) {
                xDepth = depth + 1;
                xParent = parent;
            } else if (root.val == y) {
                yDepth = depth + 1;
                yParent = parent;
            }
            preorder(root.left, depth + 1, root.val, x, y);
            preorder(root.right, depth + 1, root.val, x, y);
        }
    }
}
