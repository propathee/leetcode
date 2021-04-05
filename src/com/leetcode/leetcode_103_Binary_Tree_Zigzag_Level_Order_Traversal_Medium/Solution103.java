package com.leetcode.leetcode_103_Binary_Tree_Zigzag_Level_Order_Traversal_Medium;

import java.util.*;

abstract class Solution103 {
    public abstract List<List<Integer>> zigzagLevelOrder(TreeNode root);

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

    static Solution103 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution103 {
        @Override
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> levels = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean isReverse = false;
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (isReverse) {
                        level.add(0, node.val);
                    } else {
                        level.add(node.val);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                levels.add(level);
                isReverse = !isReverse;
            }
            return levels;
        }
    }

    private static class S2 extends Solution103 {
        @Override
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> levels = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean isReverse = false;
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int size = queue.size();
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
                if (isReverse) {
                    Collections.reverse(level);
                }
                levels.add(level);
                isReverse = !isReverse;
            }
            return levels;
        }
    }
}
