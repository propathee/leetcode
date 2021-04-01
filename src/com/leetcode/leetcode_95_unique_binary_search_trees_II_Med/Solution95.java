package com.leetcode.leetcode_95_unique_binary_search_trees_II_Med;

import java.util.ArrayList;
import java.util.List;

abstract class Solution95 {
    public abstract List<TreeNode> generateTrees(int n);

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

    static Solution95 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution95 {
        @Override
        public List<TreeNode> generateTrees(int n) {
            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int from, int to) {
            List<TreeNode> res = new ArrayList<>();
            if (from > to) {
                res.add(null);
            } else if (from == to) {
                res.add(new TreeNode(from));
            } else {
                for (int i = from; i <= to; i++) {
                    List<TreeNode> leftTrees = generateTrees(from, i - 1);
                    List<TreeNode> rightTrees = generateTrees(i + 1, to);
                    for (TreeNode left : leftTrees) {
                        for (TreeNode right : rightTrees) {
                            TreeNode root = new TreeNode(i);
                            root.left = left;
                            root.right = right;
                            res.add(root);
                        }
                    }
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution95 {
        @Override
        public List<TreeNode> generateTrees(int n) {
            List<TreeNode>[] dp = new List[n + 1];
            dp[0] = (new ArrayList<>());
            dp[0].add(null);
            for (int len = 1; len <= n; len++) {
                dp[len] = new ArrayList<>();
                for (int lenL = 0; lenL < len; lenL++) {
                    for (TreeNode treeL : dp[lenL]) {
                        for (TreeNode treeR : dp[len - lenL - 1]) {
                            TreeNode root = new TreeNode(lenL + 1);
                            root.left = treeL;
                            root.right = shift(treeR, lenL + 1);
                            dp[len].add(root);
                        }
                    }
                }
            }
            return dp[n];
        }

        private TreeNode shift(TreeNode root, int offset) {
            if (root == null) {
                return null;
            }
            TreeNode newRoot = new TreeNode(root.val + offset);
            newRoot.left = shift(root.left, offset);
            newRoot.right = shift(root.right, offset);
            return newRoot;
        }
    }
}
