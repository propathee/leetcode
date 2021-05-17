package com.leetcode.leetcode_230_Kth_Smallest_Element_in_a_BST_Medium;

import com.leetcode.utils.TreeNode;

import java.util.Stack;

abstract class Solution230 {
    public abstract int kthSmallest(TreeNode root, int k);

    static Solution230 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution230 {
        private int cnt = 0;

        @Override
        public int kthSmallest(TreeNode root, int k) {
            if (root == null) {
                return -1;
            }
            int res = kthSmallest(root.left, k);
            if (res >= 0) {
                return res;
            } else {
                cnt++;
                if (cnt == k) {
                    return root.val;
                } else {
                    return kthSmallest(root.right, k);
                }
            }
        }
    }

    private static class S2 extends Solution230 {
        @Override
        public int kthSmallest(TreeNode root, int k) {
            int cnt = 0;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    if (++cnt == k) {
                        return stack.peek().val;
                    } else {
                        node = stack.pop().right;
                    }
                }
            }
            return -1;
        }
    }

    private static class S3 extends Solution230 {
        @Override
        public int kthSmallest(TreeNode root, int k) {
            int cnt = countNodes(root.left);
            if (k <= cnt) {
                return kthSmallest(root.left, k);
            } else if (k > cnt + 1) {
                return kthSmallest(root.right, k - cnt - 1);
            } else {
                return root.val;
            }
        }

        private int countNodes(TreeNode root) {
            return root == null ? 0 : 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
