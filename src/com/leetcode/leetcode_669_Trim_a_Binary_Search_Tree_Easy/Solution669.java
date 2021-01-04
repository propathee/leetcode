package com.leetcode.leetcode_669_Trim_a_Binary_Search_Tree_Easy;

import java.util.LinkedList;
import java.util.Queue;

abstract class Solution669 {
    public abstract TreeNode trimBST(TreeNode root, int low, int high);

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

    static Solution669 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution669 {
        @Override
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            } else if (root.val < low) {
                return trimBST(root.right, low, high);
            } else if (root.val > high) {
                return trimBST(root.left, low, high);
            } else {
                root.left = trimBST(root.left, low, high);
                root.right = trimBST(root.right, low, high);
                return root;
            }
        }
    }

    private static class S2 extends Solution669 {
        @Override
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            TreeNode l = trimBST(root.left, low, high);
            TreeNode r = trimBST(root.right, low, high);
            root.left = l;
            root.right = r;
            return root.val >= low && root.val <= high ? root : root.val < low ? r : l;
        }
    }

    private static class S3 extends Solution669 {
        @Override
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            Queue<TreeNode> q1 = new LinkedList<>();
            Queue<TreeNode> q2 = new LinkedList<>();
            Queue<Boolean> q3 = new LinkedList<>();
            TreeNode dummy = new TreeNode();
            dummy.right = root;
            q1.offer(root);
            q2.offer(dummy);
            q3.offer(true);
            while (!q1.isEmpty()) {
                TreeNode node = q1.poll();
                TreeNode parent = q2.poll();
                boolean isRight = q3.poll();
                if (node.val >= low && node.val <= high) {
                    if (isRight) {
                        parent.right = node;
                    } else {
                        parent.left = node;
                    }
                    if (node.left != null) {
                        q1.offer(node.left);
                        q2.offer(node);
                        q3.offer(false);
                    }
                    if (node.right != null) {
                        q1.offer(node.right);
                        q2.offer(node);
                        q3.offer(true);
                    }
                } else {
                    if (isRight) {
                        parent.right = null;
                    } else {
                        parent.left = null;
                    }
                    if (node.val < low) {
                        if (node.right != null) {
                            q1.offer(node.right);
                            q2.offer(parent);
                            q3.offer(isRight);
                        }
                    } else {
                        if (node.left != null) {
                            q1.offer(node.left);
                            q2.offer(parent);
                            q3.offer(isRight);
                        }
                    }
                }
            }
            return dummy.right;
        }
    }

    private static class S4 extends Solution669 {
        @Override
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            while (root.val < low || root.val > high) {
                if (root.val < low) {
                    root = root.right;
                } else {
                    root = root.left;
                }
                if (root == null) {
                    return null;
                }
            }
            TreeNode node = root;
            while (node != null) {
                while (node.left != null && node.left.val < low) {
                    node.left = node.left.right;
                }
                node = node.left;
            }
            node = root;
            while (node != null) {
                while (node.right != null && node.right.val > high) {
                    node.right = node.right.left;
                }
                node = node.right;
            }
            return root;
        }
    }

    private static class S5 extends Solution669 {
        @Override
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            while (root.val < low || root.val > high) {
                if (root.val < low) {
                    root = root.right;
                } else {
                    root = root.left;
                }
                if (root == null) {
                    return null;
                }
            }
            TreeNode nodeL = root;
            TreeNode nodeR = root;
            while (nodeL.left != null) {
                if (nodeL.left.val < low) {
                    nodeL.left = nodeL.left.right;
                } else {
                    nodeL = nodeL.left;
                }
            }
            while (nodeR.right != null) {
                if (nodeR.right.val > high) {
                    nodeR.right = nodeR.right.left;
                } else {
                    nodeR = nodeR.right;
                }
            }
            return root;
        }
    }
}
