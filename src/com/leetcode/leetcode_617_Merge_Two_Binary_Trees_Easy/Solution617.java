package com.leetcode.leetcode_617_Merge_Two_Binary_Trees_Easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

abstract class Solution617 {
    public abstract TreeNode mergeTrees(TreeNode t1, TreeNode t2);

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

    static Solution617 newSolution() {
        return new S6();
    }

    private static class S1 extends Solution617 {
        @Override
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return null;
            } else if (t1 == null) {
                return t2;
            } else if (t2 == null) {
                return t1;
            } else {
                t1.val = t1.val + t2.val;
                t1.left = mergeTrees(t1.left, t2.left);
                t1.right = mergeTrees(t1.right, t2.right);
                return t1;
            }
        }
    }

    private static class S2 extends Solution617 {
        @Override
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return null;
            }
            TreeNode node = new TreeNode();
            node.val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
            node.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
            node.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
            return node;
        }
    }

    private static class S3 extends Solution617 {
        @Override
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }
            t1.val = t1.val + t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
    }

    private static class S4 extends Solution617 {
        @Override
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }
            Queue<TreeNode> q1 = new LinkedList<>();
            Queue<TreeNode> q2 = new LinkedList<>();
            q1.offer(t1);
            q2.offer(t2);
            while (!q1.isEmpty()) {
                TreeNode n1 = q1.poll();
                TreeNode n2 = q2.poll();
                n1.val = n1.val + n2.val;
                if (n1.left == null) {
                    n1.left = n2.left;
                } else if (n2.left != null) {
                    q1.offer(n1.left);
                    q2.offer(n2.left);
                }
                if (n1.right == null) {
                    n1.right = n2.right;
                } else if (n2.right != null) {
                    q1.offer(n1.right);
                    q2.offer(n2.right);
                }
            }
            return t1;
        }
    }

    private static class S5 extends Solution617 {
        @Override
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }
            Queue<TreeNode> q1 = new LinkedList<>();
            Queue<TreeNode> q2 = new LinkedList<>();
            q1.offer(t1);
            q2.offer(t2);
            while (!q1.isEmpty()) {
                TreeNode n1 = q1.poll();
                TreeNode n2 = q2.poll();
                if (n1 != null && n2 != null) {
                    n1.val = n1.val + n2.val;
                    if (n1.left == null && n2.left != null) {
                        n1.left = new TreeNode(0);
                    }
                    if (n1.right == null && n2.right != null) {
                        n1.right = new TreeNode(0);
                    }
                    q1.offer(n1.left);
                    q2.offer(n2.left);
                    q1.offer(n1.right);
                    q2.offer(n2.right);
                }
            }
            return t1;
        }
    }

    private static class S6 extends Solution617 {
        @Override
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null) {
                return t2;
            }
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(t1);
            s2.push(t2);
            while (!s1.isEmpty()) {
                TreeNode n1 = s1.pop();
                TreeNode n2 = s2.pop();
                if (n2 != null) {
                    n1.val = n1.val + n2.val;
                    if (n1.left == null) {
                        n1.left = n2.left;
                        n2.left = null;
                    }
                    if (n1.right == null) {
                        n1.right = n2.right;
                        n2.right = null;
                    }
                    s1.push(n1.right);
                    s2.push(n2.right);
                    s1.push(n1.left);
                    s2.push(n2.left);
                }
            }
            return t1;
        }
    }
}
