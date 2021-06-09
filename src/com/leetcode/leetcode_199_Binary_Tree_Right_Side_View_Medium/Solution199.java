package com.leetcode.leetcode_199_Binary_Tree_Right_Side_View_Medium;

import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

abstract class Solution199 {
    public abstract List<Integer> rightSideView(TreeNode root);

    static Solution199 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution199 {
        @Override
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                res.add(queue.peek().val);
                int size = queue.size();
                for (; size > 0; size--) {
                    TreeNode node = queue.poll();
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution199 {
        @Override
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            collectRightSide(root, 0, res);
            return res;
        }

        private void collectRightSide(TreeNode root, int depth, List<Integer> res) {
            if (root == null) {
                return;
            }
            if (res.size() == depth) {
                res.add(root.val);
            }
            collectRightSide(root.right, depth + 1, res);
            collectRightSide(root.left, depth + 1, res);
        }
    }

    private static class S3 extends Solution199 {
        @Override
        public List<Integer> rightSideView(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> res = new ArrayList<>();
            List<Integer> right = rightSideView(root.right);
            List<Integer> left = rightSideView(root.left);
            res.add(root.val);
            res.addAll(right);
            if (left.size() > right.size()) {
                res.addAll(left.subList(right.size(), left.size()));
            }
            return res;
        }
    }
}
