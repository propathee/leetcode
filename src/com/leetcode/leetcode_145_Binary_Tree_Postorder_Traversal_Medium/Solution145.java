package com.leetcode.leetcode_145_Binary_Tree_Postorder_Traversal_Medium;

import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

abstract class Solution145 {
    public abstract List<Integer> postorderTraversal(TreeNode root);

    static Solution145 newSolution() {
        return new S7();
    }

    private static class S1 extends Solution145 {
        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> values = new ArrayList<>();
            postorder(root, values);
            return values;
        }

        private void postorder(TreeNode root, List<Integer> values) {
            if (root == null) {
                return;
            }
            postorder(root.left, values);
            postorder(root.right, values);
            values.add(root.val);
        }
    }

    private static class S2 extends Solution145 {
        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> values = new ArrayList<>();
            values.addAll(postorderTraversal(root.left));
            values.addAll(postorderTraversal(root.right));
            values.add(root.val);
            return values;
        }
    }

    private static class S3 extends Solution145 {
        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> values = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                if (stack.peek().left != null) {
                    stack.push(stack.peek().left);
                } else {
                    if (stack.peek().right != null) {
                        stack.push(stack.peek().right);
                    } else {
                        while (!stack.isEmpty()) {
                            TreeNode node = stack.pop();
                            values.add(node.val);
                            if (!stack.isEmpty() && stack.peek().right != null && stack.peek().right != node) {
                                stack.push(stack.peek().right);
                                break;
                            }
                        }
                    }
                }
            }
            return values;
        }
    }

    private static class S4 extends Solution145 {
        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> values = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                values.add(node.val);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
            Collections.reverse(values);
            return values;
        }
    }

    private static class S5 extends Solution145 {
        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> values = new ArrayList<>();
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<Boolean> stack2 = new Stack<>(); // true: current node's children have been visited
            stack1.push(root);
            stack2.push(false);
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                boolean visit = stack2.pop();
                if (visit) {
                    values.add(node.val);
                } else {
                    stack1.push(node);
                    stack2.push(true);
                    if (node.right != null) {
                        stack1.push(node.right);
                        stack2.push(false);
                    }
                    if (node.left != null) {
                        stack1.push(node.left);
                        stack2.push(false);
                    }
                }
            }
            return values;
        }
    }

    private static class S6 extends Solution145 {
        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> values = new ArrayList<>();
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<Boolean> stack2 = new Stack<>(); // true: current node's right child has been visited
            while (root != null) {
                stack1.push(root);
                stack2.push(false);
                root = root.left;
            }
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                boolean visit = stack2.pop();
                if (node.right == null || visit) {
                    values.add(node.val);
                } else {
                    stack1.push(node);
                    stack2.push(true);

                    node = node.right;
                    while (node != null) {
                        stack1.push(node);
                        stack2.push(false);
                        node = node.left;
                    }
                }
            }
            return values;
        }
    }

    private static class S7 extends Solution145 {
        @Override
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> values = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            while (root != null || !stack.isEmpty()) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    TreeNode node = stack.peek();
                    if (node.right != null && node.right != pre) {
                        root = node.right;
                    } else {
                        values.add(node.val);
                        pre = node;
                        stack.pop();
                    }
                }
            }
            return values;
        }
    }
}
