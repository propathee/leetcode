package com.leetcode.leetcode_653_Two_Sum_IV_Input_is_a_BST_Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

abstract class Solution653 {
    public abstract boolean findTarget(TreeNode root, int k);

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

    static Solution653 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution653 {
        @Override
        public boolean findTarget(TreeNode root, int k) {
            List<Integer> values = new ArrayList<>();
            inorder(root, values);
            int p = 0, q = values.size() - 1;
            while (p < q) {
                int sum = values.get(p) + values.get(q);
                if (sum == k) {
                    return true;
                } else if (sum > k) {
                    q--;
                } else {
                    p++;
                }
            }
            return false;
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

    private static class S2 extends Solution653 {
        @Override
        public boolean findTarget(TreeNode root, int k) {
            Set<Integer> set = new HashSet<>();
            return dfs(root, set, k);
        }

        private boolean dfs(TreeNode root, Set<Integer> set, int k) {
            if (root == null) {
                return false;
            }
            if (set.contains(k - root.val)) {
                return true;
            } else {
                set.add(root.val);
                return dfs(root.left, set, k) || dfs(root.right, set, k);
            }
        }
    }

    private static class S3 extends Solution653 {
        private TreeNode root;

        @Override
        public boolean findTarget(TreeNode root, int k) {
            this.root = root;
            return dfs(root, k);
        }

        private boolean dfs(TreeNode node, int k) {
            if (node == null) {
                return false;
            }
            return search(root, node, k - node.val)
                || dfs(node.left, k)
                || dfs(node.right, k);
        }

        private boolean search(TreeNode root, TreeNode curNode, int v) {
            if (root == null) {
                return false;
            }
            if (v == root.val) {
                return root != curNode;
            } else if (v > root.val) {
                return search(root.right, curNode, v);
            } else {
                return search(root.left, curNode, v);
            }
        }
    }

    private static class S4 extends Solution653 {
        private TreeNode root;

        @Override
        public boolean findTarget(TreeNode root, int k) {
            this.root = root;
            return dfs(root, k);
        }

        private boolean dfs(TreeNode node, int k) {
            if (node == null) {
                return false;
            }
            if (node.val != k - node.val && search(root, k - node.val)) {
                return true;
            } else {
                return dfs(node.left, k) || dfs(node.right, k);
            }
        }

        private boolean search(TreeNode node, int v) {
            if (node == null) {
                return false;
            }
            if (v == node.val) {
                return true;
            } else if (v > node.val) {
                return search(node.right, v);
            } else {
                return search(node.left, v);
            }
        }
    }
}
