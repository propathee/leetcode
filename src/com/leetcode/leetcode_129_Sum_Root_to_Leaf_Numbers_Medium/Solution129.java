package com.leetcode.leetcode_129_Sum_Root_to_Leaf_Numbers_Medium;

import com.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

abstract class Solution129 {
    public abstract int sumNumbers(TreeNode root);

    static Solution129 newSolution() {
        return new S6();
    }

    private static class S1 extends Solution129 {
        private int sum = 0;

        @Override
        public int sumNumbers(TreeNode root) {
            sumNumbers(root, 0);
            return sum;
        }

        private void sumNumbers(TreeNode root, int partSum) {
            if (root.left == null && root.right == null) {
                sum += (partSum * 10 + root.val);
            } else {
                if (root.left != null) {
                    sumNumbers(root.left, partSum * 10 + root.val);
                }
                if (root.right != null) {
                    sumNumbers(root.right, partSum * 10 + root.val);
                }
            }
        }
    }

    private static class S2 extends Solution129 {
        private int sum = 0;

        @Override
        public int sumNumbers(TreeNode root) {
            sumNumbers(root, 0);
            return sum;
        }

        private void sumNumbers(TreeNode root, int partSum) {
            if (root.left == null && root.right == null) {
                sum += (partSum + root.val);
            } else {
                if (root.left != null) {
                    sumNumbers(root.left, (partSum + root.val) * 10);
                }
                if (root.right != null) {
                    sumNumbers(root.right, (partSum + root.val) * 10);
                }
            }
        }
    }

    private static class S3 extends Solution129 {
        @Override
        public int sumNumbers(TreeNode root) {
            return sumNumbers(root, 0);
        }

        private int sumNumbers(TreeNode root, int preSum) {
            if (root == null) {
                return 0;
            } else if (root.left == null && root.right == null) {
                return preSum * 10 + root.val;
            } else {
                return sumNumbers(root.left, preSum * 10 + root.val) + sumNumbers(root.right, preSum * 10 + root.val);
            }
        }
    }

    private static class S4 extends Solution129 {
        @Override
        public int sumNumbers(TreeNode root) {
            if (root.left == null && root.right == null) {
                return root.val;
            } else {
                int sum = 0;
                if (root.left != null) {
                    root.left.val += (root.val * 10);
                    sum += sumNumbers(root.left);
                }
                if (root.right != null) {
                    root.right.val += (root.val * 10);
                    sum += sumNumbers(root.right);
                }
                return sum;
            }
        }
    }

    private static class S5 extends Solution129 {
        @Override
        public int sumNumbers(TreeNode root) {
            int sum = 0;
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            stack1.push(root);
            stack2.push(root.val);
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                int preSum = stack2.pop();
                if (node.left == null && node.right == null) {
                    sum += preSum;
                } else {
                    if (node.left != null) {
                        stack1.push(node.left);
                        stack2.push(preSum * 10 + node.left.val);
                    }
                    if (node.right != null) {
                        stack1.push(node.right);
                        stack2.push(preSum * 10 + node.right.val);
                    }
                }
            }
            return sum;
        }
    }

    private static class S6 extends Solution129 {
        @Override
        public int sumNumbers(TreeNode root) {
            int sum = 0;
            Queue<TreeNode> queue1 = new LinkedList<>();
            Queue<Integer> queue2 = new LinkedList<>();
            queue1.offer(root);
            queue2.offer(0);
            while (!queue1.isEmpty()) {
                int size = queue1.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue1.poll();
                    int preSum = queue2.poll();
                    if (node.left == null && node.right == null) {
                        sum += (preSum * 10 + node.val);
                    } else {
                        if (node.left != null) {
                            queue1.offer(node.left);
                            queue2.offer(preSum * 10 + node.val);
                        }
                        if (node.right != null) {
                            queue1.offer(node.right);
                            queue2.offer(preSum * 10 + node.val);
                        }
                    }
                }
            }
            return sum;
        }
    }
}
