package com.leetcode.leetcode_783_Minimum_Distance_Between_BST_Nodes_Easy;

import java.util.ArrayList;
import java.util.List;

abstract class Solution783 {
    public abstract int minDiffInBST(TreeNode root);

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

    static Solution783 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution783 {
        private List<Integer> values = new ArrayList<>();

        @Override
        public int minDiffInBST(TreeNode root) {
            inorder(root);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < values.size(); i++) {
                min = Math.min(min, values.get(i) - values.get(i - 1));
            }
            return min;
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            values.add(root.val);
            inorder(root.right);
        }
    }
}
