package com.leetcode.leetcode_938_Range_Sum_of_BST_Easy;

import java.util.ArrayList;
import java.util.List;

abstract class Solution938 {
    public abstract int rangeSumBST(TreeNode root, int low, int high);

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

    static Solution938 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution938 {
        @Override
        public int rangeSumBST(TreeNode root, int low, int high) {
            List<Integer> numbers = new ArrayList<>();
            inorder(root, numbers);

            int sum = 0;
            for (int num : numbers) {
                if (num > high) {
                    break;
                } else if (num >= low) {
                    sum += num;
                }
            }
            return sum;
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

    private static class S2 extends Solution938 {
        private int sum = 0;

        @Override
        public int rangeSumBST(TreeNode root, int low, int high) {
            inorder(root, low, high);
            return sum;
        }

        private void inorder(TreeNode root, int low, int high) {
            if (root == null) {
                return;
            }
            inorder(root.left, low, high);
            if (root.val > high) {
                return;
            } else if (root.val >= low) {
                sum += root.val;
            }
            inorder(root.right, low, high);
        }
    }

    private static class S3 extends Solution938 {
        private int sum = 0;

        @Override
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) {
                return sum;
            }
            rangeSumBST(root.left, low, high);
            if (root.val > high) {
                return sum;
            } else if (root.val >= low) {
                sum += root.val;
            }
            rangeSumBST(root.right, low, high);
            return sum;
        }
    }

    private static class S4 extends Solution938 {
        @Override
        public int rangeSumBST(TreeNode root, int low, int high) {
            if (root == null) {
                return 0;
            }
            if (root.val < low) {
                return rangeSumBST(root.right, low, high);
            } else if (root.val > high) {
                return rangeSumBST(root.left, low, high);
            } else {
                return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
            }
        }
    }
}
