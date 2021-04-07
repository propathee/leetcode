package com.leetcode.leetcode_107_Binary_Tree_Level_Order_Traversal_II_Medium;

import com.leetcode.utils.TreeNode;

import java.util.*;

abstract class Solution107 {
    public abstract List<List<Integer>> levelOrderBottom(TreeNode root);

    static Solution107 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution107 {
        @Override
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> levels = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size= queue.size();
                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                levels.add(0, level);
            }
            return levels;
        }
    }

    private static class S2 extends Solution107 {
        @Override
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> levels = new ArrayList<>();
            appendLevel(root, 0, levels);
            return levels;
        }

        private void appendLevel(TreeNode root, int levelNum, List<List<Integer>> levels) {
            if (root == null) {
                return;
            }
            if (levels.size() <= levelNum) {
                levels.add(0, new ArrayList<>());
            }
            levels.get(levels.size() - levelNum - 1).add(root.val);
            appendLevel(root.left, levelNum + 1, levels);
            appendLevel(root.right, levelNum + 1, levels);
        }
    }

    private static class S3 extends Solution107 {
        @Override
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> levels = new ArrayList<>();
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            stack1.push(root);
            stack2.push(1);
            while (!stack1.isEmpty()) {
                if (levels.size() < stack2.peek()) {
                    levels.add(0, new ArrayList<>());
                }
                TreeNode node = stack1.pop();
                int levelCnt = stack2.pop();
                levels.get(levels.size() - levelCnt).add(node.val);
                if (node.right != null) {
                    stack1.push(node.right);
                    stack2.push(levelCnt + 1);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                    stack2.push(levelCnt + 1);
                }
            }
            return levels;
        }
    }
}
