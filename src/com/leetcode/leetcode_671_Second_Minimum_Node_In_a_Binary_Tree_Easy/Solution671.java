package com.leetcode.leetcode_671_Second_Minimum_Node_In_a_Binary_Tree_Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

abstract class Solution671 {
    public abstract int findSecondMinimumValue(TreeNode root);

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

    static Solution671 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution671 {
        private int min;
        private int res;

        @Override
        public int findSecondMinimumValue(TreeNode root) {
            min = root.val;
            res = -1;
            preorder(root);
            return res;
        }

        private void preorder(TreeNode root) {
            if (root.val == min) {
                if (root.left != null) {
                    preorder(root.left);
                    preorder(root.right);
                }
            } else if (res < 0 || root.val < res) {
                res = root.val;
            }
        }
    }

    private static class S2 extends Solution671 {
        @Override
        public int findSecondMinimumValue(TreeNode root) {
            if (root.left == null) {
                return -1;
            }
            int l = root.left.val == root.val ? findSecondMinimumValue(root.left) : root.left.val;
            int r = root.right.val == root.val ? findSecondMinimumValue(root.right) : root.right.val;
            return l == -1 || r == -1 ? Math.max(l, r) : Math.min(l, r);
        }
    }

    private static class S3 extends Solution671 {
        @Override
        public int findSecondMinimumValue(TreeNode root) {
            return helper(root, root.val);
        }

        private int helper(TreeNode node, int min) {
            if (node.val != min) {
                return node.val;
            }
            if (node.left == null) {
                return -1;
            }
            int l = helper(node.left, min);
            int r = helper(node.right, min);
            return l == -1 || r == -1 ? Math.max(l, r) : Math.min(l, r);
        }
    }

    private static class S4 extends Solution671 {
        @Override
        public int findSecondMinimumValue(TreeNode root) {
            if (root.left == null) {
                return -1;
            }
            int res = -1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.val == root.val) {
                    if (node.left != null) {
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }
                } else if (res < 0 || node.val < res) {
                    res = node.val;
                }
            }
            return res;
        }
    }

    private static class S5 extends Solution671 {
        @Override
        public int findSecondMinimumValue(TreeNode root) {
            if (root.left == null) {
                return -1;
            }
            int res = -1;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.val == root.val) {
                    if (node.left != null) {
                        stack.push(node.right);
                        stack.push(node.left);
                    }
                } else if (res < 0 || node.val < res) {
                    res = node.val;
                }
            }
            return res;
        }
    }
}
