package com.leetcode.leetcode_404_Sum_of_Left_Leaves_Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public abstract class Solution404 {
    /**
     * Find the sum of all left <b>leaves</b> in a given binary tree.
     */
    public abstract int sumOfLeftLeaves(TreeNode root);

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

    static Solution404 newSolution() {
        return new S6();
    }

    private static class S1 extends Solution404 {
        @Override
        public int sumOfLeftLeaves(TreeNode root) {
            return helper(root, false);
        }

        private int helper(TreeNode root, boolean isLeft) {
            if (root == null) {
                return 0;
            } else if (root.left == null && root.right == null) {
                return isLeft ? root.val : 0;
            } else {
                return helper(root.left, true) + helper(root.right, false);
            }
        }
    }

    private static class S2 extends Solution404 {
        @Override
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int res = 0;
            if (root.left != null) {
                if (root.left.left == null && root.left.right == null) {
                    res += root.left.val;
                } else {
                    res += sumOfLeftLeaves(root.left);
                }
            }
            res += sumOfLeftLeaves(root.right);
            return res;
        }
    }

    private static class S3 extends Solution404 {
        @Override
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int res = 0;
            Queue<TreeNode> q1 = new LinkedList<>();
            Queue<Boolean> q2 = new LinkedList<>();
            q1.offer(root);
            q2.offer(false);
            while (!q1.isEmpty()) {
                TreeNode node = q1.poll();
                boolean isLeft = q2.poll();
                if (isLeft && node.left == null && node.right == null) {
                    res += node.val;
                } else {
                    if (node.left != null) {
                        q1.offer(node.left);
                        q2.offer(true);
                    }
                    if (node.right != null) {
                        q1.offer(node.right);
                        q2.offer(false);
                    }
                }
            }
            return res;
        }
    }

    // this solution got passed but maybe unsafe, for we modify the value of non-left nodes
    private static class S4 extends Solution404 {
        @Override
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int res = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            root.val = 0; // Attention
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    res += node.val;
                } else {
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        node.right.val = 0; // Attention
                        queue.offer(node.right);
                    }
                }
            }
            return res;
        }
    }

    private static class S5 extends Solution404 {
        @Override
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int res = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    if (node.left.left == null && node.left.right == null) {
                        res += node.left.val;
                    } else {
                        queue.offer(node.left);
                    }
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            return res;
        }
    }

    private static class S6 extends Solution404 {
        @Override
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int res = 0;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.left != null) {
                    if (node.left.left == null && node.left.right == null) {
                        res += node.left.val;
                    } else {
                        stack.push(node.left);
                    }
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            return res;
        }
    }
}
