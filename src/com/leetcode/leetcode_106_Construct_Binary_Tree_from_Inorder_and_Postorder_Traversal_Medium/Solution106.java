package com.leetcode.leetcode_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_Medium;

import com.leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

abstract class Solution106 {
    public abstract TreeNode buildTree(int[] inorder, int[] postorder);

    static Solution106 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution106 {
        @Override
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode buildTree(int[] inorder, int l1, int r1, int[] postorder, int l2, int r2) {
            if (l2 > r2) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[r2]);
            int idx = l1;
            for (; idx <= r1; idx++) {
                if (inorder[idx] == root.val) {
                    break;
                }
            }
            int lenL = idx - l1;
            root.left = buildTree(inorder, l1, idx - 1, postorder, l2, l2 + lenL - 1);
            root.right = buildTree(inorder, idx + 1, r1, postorder, l2 + lenL, r2 - 1);
            return root;
        }
    }

    private static class S2 extends Solution106 {
        private Map<Integer, Integer> inorderMap = new HashMap<>();
        private int postorderIdx;

        @Override
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }
            postorderIdx = postorder.length - 1;
            return buildTree(inorder, 0, inorder.length - 1, postorder);
        }

        private TreeNode buildTree(int[] inorder, int l, int r, int[] postorder) {
            if (l > r) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[postorderIdx]);
            int idx = inorderMap.get(root.val);
            postorderIdx--;
            root.right = buildTree(inorder, idx + 1, r, postorder);
            root.left = buildTree(inorder, l, idx - 1, postorder);
            return root;
        }
    }

    private static class S3 extends Solution106 {
        @Override
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            TreeNode root = new TreeNode(postorder[postorder.length - 1]);
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            int inIdx = inorder.length - 1;
            for (int postIdx = postorder.length - 2; postIdx >= 0; postIdx--) {
                TreeNode node = new TreeNode(postorder[postIdx]);
                if (stack.peek().val != inorder[inIdx]) {
                    stack.peek().right = node;
                } else {
                    TreeNode parent = null;
                    while (!stack.isEmpty() && stack.peek().val == inorder[inIdx]) {
                        // the node being popped has finished building its right child tree
                        parent = stack.pop();
                        inIdx--;
                    }
                    parent.left = node;
                }
                stack.push(node);
            }
            return root;
        }
    }

    private static class S4 extends Solution106 {
        @Override
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            Map<Integer, Integer> inorderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }
            TreeNode root = new TreeNode(postorder[postorder.length - 1]);
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            for (int postIdx = postorder.length - 2; postIdx >= 0; postIdx--) {
                int val = postorder[postIdx];
                TreeNode node = new TreeNode(val);
                if (inorderMap.get(val) > inorderMap.get(stack.peek().val)) {
                    stack.peek().right = node;
                } else {
                    TreeNode parent = null;
                    while (!stack.isEmpty() && inorderMap.get(stack.peek().val) > inorderMap.get(val)) {
                        parent = stack.pop();
                    }
                    parent.left = node;
                }
                stack.push(node);
            }
            return root;
        }
    }
}
