package com.leetcode.leetcode_501_Find_Mode_in_Binary_Search_Tree_Easy;

import java.util.*;

abstract class Solution501 {
    public abstract int[] findMode(TreeNode root);

    static Solution501 newSolution() {
        return new S2();
    }

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

    private static class S1 extends Solution501 {
        @Override
        public int[] findMode(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            Map<Integer, Integer> map = new HashMap<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                map.put(node.val, map.getOrDefault(node.val, 0) + 1);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            List<Integer> res = new ArrayList<>();
            int max = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int cnt = entry.getValue();
                if (cnt > max) {
                    res.clear();
                    max = cnt;
                }
                if (cnt == max) {
                    res.add(entry.getKey());
                }
            }
            int[] arr = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                arr[i] = res.get(i);
            }
            return arr;
        }
    }

    private static class S2 extends Solution501 {
        private int curVal;
        private int maxCnt = 0;
        private int curCnt = 0;
        private List<Integer> modes = new ArrayList<>();

        @Override
        public int[] findMode(TreeNode root) {
            inorder(root);
            int[] res = new int[modes.size()];
            for (int i = 0; i < modes.size(); i++) {
                res[i] = modes.get(i);
            }
            return res;
        }

        // it is very easy to get modes from a sorted array since all duplicates are consecutive.
        // key observation: an inorder traverse gives exactly a sorted sequence.
        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            handle(root.val);
            inorder(root.right);
        }

        private void handle(int val) {
            if (val != curVal) {
                curVal = val;
                curCnt = 1;
            } else {
                curCnt++;
            }
            if (curCnt > maxCnt) {
                maxCnt = curCnt;
                modes.clear();
                modes.add(curVal);
            } else if (curCnt == maxCnt) {
                modes.add(curVal);
            }
        }
    }
}
