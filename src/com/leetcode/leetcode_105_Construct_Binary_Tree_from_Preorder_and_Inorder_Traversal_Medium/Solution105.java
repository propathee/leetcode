package com.leetcode.leetcode_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_Medium;

import com.leetcode.utils.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

abstract class Solution105 {
    public abstract TreeNode buildTree(int[] preorder, int[] inorder);

    static Solution105 newSolution() {
        return new S6();
    }

    private static class S1 extends Solution105 {
        @Override
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) {
                return null;
            }
            int rootVal = preorder[0];
            int rootIndex = 0;
            while (inorder[rootIndex] != rootVal) {
                rootIndex++;
            }
            TreeNode root = new TreeNode(rootVal);
            int[] preorderL = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
            int[] preorderR = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
            int[] inorderL = Arrays.copyOfRange(inorder, 0, rootIndex);
            int[] inorderR = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
            root.left = buildTree(preorderL, inorderL);
            root.right = buildTree(preorderR, inorderR);
            return root;
        }
    }

    private static class S2 extends Solution105 {
        @Override
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
        }

        private TreeNode buildTree(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
            if (s1 == e1) {
                return null;
            }
            int rootValue = preorder[s1];
            int rootIndex = s2;
            while (inorder[rootIndex] != rootValue) {
                rootIndex++;
            }
            int lenL = rootIndex - s2;
            TreeNode root = new TreeNode(rootValue);
            root.left = buildTree(preorder, s1 + 1, s1 + lenL + 1, inorder, s2, rootIndex);
            root.right = buildTree(preorder, s1 + lenL + 1, e1, inorder, rootIndex + 1, e2);
            return root;
        }
    }

    private static class S3 extends Solution105 {
        private Map<Integer, Integer> map = new HashMap<>();
        private int preorderIndex = 0;

        @Override
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(preorder, inorder, 0, inorder.length);
        }

        private TreeNode buildTree(int[] preorder, int[] inorder, int from, int to) {
            if (from == to) {
                return null;
            }
            int val = preorder[preorderIndex];
            int inorderIndex = map.get(val);
            TreeNode root = new TreeNode(val);
            preorderIndex++;
            root.left = buildTree(preorder, inorder, from, inorderIndex);
            root.right = buildTree(preorder, inorder, inorderIndex + 1, to);
            return root;
        }
    }

    private static class S4 extends Solution105 {
        @Override
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[0]), cur = root;
            Stack<TreeNode> stack = new Stack<>();
            for (int i = 1, j = 0; i < preorder.length; i++) {
                if (cur.val != inorder[j]) {
                    cur.left = new TreeNode(preorder[i]);
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    j++;
                    while (!stack.isEmpty() && stack.peek().val == inorder[j]) {
                        cur = stack.pop();
                        j++;
                    }
                    cur = cur.right = new TreeNode(preorder[i]);
                }
            }
            return root;
        }
    }

    private static class S5 extends Solution105 {
        @Override
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[0]);
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            for (int i = 1, j = 0; i < preorder.length; i++) {
                TreeNode node = new TreeNode(preorder[i]);
                if (stack.peek().val != inorder[j]) {
                    stack.peek().left = node;
                } else {
                    TreeNode parent = null;
                    while (!stack.isEmpty() && stack.peek().val == inorder[j]) {
                        j++;
                        parent = stack.pop();
                    }
                    parent.right = node;
                }
                stack.push(node);
            }
            return root;
        }
    }

    private static class S6 extends Solution105 {
        @Override
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0) {
                return null;
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            TreeNode root = new TreeNode(preorder[0]);
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            for (int i = 1; i < preorder.length; i++) {
                int val = preorder[i];
                TreeNode node = new TreeNode(val);
                if (map.get(val) < map.get(stack.peek().val)) {
                    stack.peek().left = node;
                } else {
                    TreeNode parent = null;
                    while (!stack.isEmpty() && map.get(val) > map.get(stack.peek().val)) {
                        parent = stack.pop();
                    }
                    parent.right = node;
                }
                stack.push(node);
            }
            return root;
        }
    }
}
