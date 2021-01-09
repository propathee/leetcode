package com.leetcode.leetcode_700_Search_in_a_Binary_Search_Tree_Easy;

abstract class Solution700 {
    public abstract TreeNode searchBST(TreeNode root, int val);

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

    static Solution700 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution700 {
        @Override
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            } else if (root.val == val) {
                return root;
            } else if (root.val > val) {
                return searchBST(root.left, val);
            } else {
                return searchBST(root.right, val);
            }
        }
    }

    private static class S2 extends Solution700 {
        @Override
        public TreeNode searchBST(TreeNode root, int val) {
            TreeNode node = root;
            while (node != null) {
                if (node.val == val) {
                    return node;
                } else if (node.val > val) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            return null;
        }
    }

    private static class S3 extends Solution700 {
        @Override
        public TreeNode searchBST(TreeNode root, int val) {
            while (root != null && root.val != val) {
                root = root.val > val ? root.left : root.right;
            }
            return root;
        }
    }
}
