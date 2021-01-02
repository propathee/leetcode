package com.leetcode.leetcode_637_Average_of_Levels_in_Binary_Tree_Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

abstract class Solution637 {
    public abstract List<Double> averageOfLevels(TreeNode root);

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

    static Solution637 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution637 {
        @Override
        public List<Double> averageOfLevels(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Double> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                long sum = 0; // or double
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                res.add((double) sum / size);
            }
            return res;
        }
    }

    private static class S2 extends Solution637 {
        private List<Double> sum = new ArrayList<>();
        private List<Integer> cnt = new ArrayList<>();

        @Override
        public List<Double> averageOfLevels(TreeNode root) {
            dfs(root, 0);
            List<Double> res = new ArrayList<>();
            for (int i = 0; i < sum.size(); i++) {
                res.add(sum.get(i) / cnt.get(i));
            }
            return res;
        }

        private void dfs(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            if (sum.size() <= depth) {
                sum.add(0.0);
                cnt.add(0);
            }
            sum.set(depth, sum.get(depth) + root.val);
            cnt.set(depth, cnt.get(depth) + 1);
            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
        }
    }
}
