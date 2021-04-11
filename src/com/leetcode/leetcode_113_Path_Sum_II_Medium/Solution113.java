package com.leetcode.leetcode_113_Path_Sum_II_Medium;

import com.leetcode.utils.TreeNode;

import java.util.*;

abstract class Solution113 {
    public abstract List<List<Integer>> pathSum(TreeNode root, int targetSum);

    static Solution113 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution113 {
        private List<List<Integer>> paths = new ArrayList<>();

        @Override
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            helper(new ArrayList<>(), root, targetSum);
            return paths;
        }

        private void helper(List<Integer> path, TreeNode root, int targetSum) {
            if (root == null) {
                return;
            }
            if (root.val == targetSum && root.left == null && root.right == null) {
                path.add(root.val);
                paths.add(path);
            } else {
                path.add(root.val);
                helper(new ArrayList<>(path), root.left, targetSum - root.val);
                helper(new ArrayList<>(path), root.right, targetSum - root.val);
            }
        }
    }

    private static class S2 extends Solution113 {
        private List<List<Integer>> paths = new ArrayList<>();

        @Override
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            helper(new Stack<>(), root, targetSum);
            return paths;
        }

        private void helper(Stack<Integer> path, TreeNode root, int targetSum) {
            if (root == null) {
                return;
            }
            path.push(root.val);
            if (root.val == targetSum && root.left == null && root.right == null) {
                paths.add(new ArrayList<>(path));
            } else {
                helper(path, root.left, targetSum - root.val);
                helper(path, root.right, targetSum - root.val);
            }
            path.pop();
        }
    }

    private static class S3 extends Solution113 {
        @Override
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> paths = new ArrayList<>();
            Queue<TreeNode> queue1 = new LinkedList<>();
            Queue<Integer> queue2 = new LinkedList<>();
            Queue<List<Integer>> queue3 = new LinkedList<>();
            queue1.offer(root);
            queue2.offer(root.val);
            queue3.offer(new ArrayList<>(Collections.singletonList(root.val)));
            while (!queue1.isEmpty()) {
                int size = queue1.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue1.poll();
                    int sum = queue2.poll();
                    List<Integer> path = queue3.poll();
                    if (node.left == null && node.right == null && sum == targetSum) {
                        paths.add(path);
                    } else {
                        if (node.left != null) {
                            queue1.offer(node.left);
                            queue2.offer(sum + node.left.val);
                            List<Integer> pathL = new ArrayList<>(path);
                            pathL.add(node.left.val);
                            queue3.offer(pathL);
                        }
                        if (node.right != null) {
                            queue1.offer(node.right);
                            queue2.offer(sum + node.right.val);
                            List<Integer> pathR = new ArrayList<>(path);
                            pathR.add(node.right.val);
                            queue3.offer(pathR);
                        }
                    }
                }
            }
            return paths;
        }
    }
}
