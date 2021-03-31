package com.leetcode.leetcode_94_Binary_Tree_Inorder_Traversal_Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

abstract class Solution94 {
    public abstract List<Integer> inorderTraversal(TreeNode root);

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

    static Solution94 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution94 {
        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(root, res);
            return res;
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

    private static class S2 extends Solution94 {
        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> res = inorderTraversal(root.left);
            res.add(root.val);
            res.addAll(inorderTraversal(root.right));
            return res;
        }
    }

    private static class S3 extends Solution94 {
        @Override
        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    res.add(node.val);
                    node = node.right;
                }
            }
            return res;
        }
    }
}
