package com.leetcode.leetcode_257_Binary_Tree_Paths_Easy;

import java.util.*;

public class Solution257 {
    public List<String> binaryTreePaths_1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> childPaths = binaryTreePaths_1(root.left);
        childPaths.addAll(binaryTreePaths_1(root.right));
        if (childPaths.isEmpty()) {
            childPaths.add(String.valueOf(root.val));
        } else {
            for (int i = 0; i < childPaths.size(); i++) {
                childPaths.set(i, root.val + "->" + childPaths.get(i));
            }
        }
        return childPaths;
    }

    public List<String> binaryTreePaths_2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();
        helper(root, "", ans);
        return ans;
    }

    private void helper(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) {
            answer.add(path + root.val);
        }
        if (root.left != null) {
            helper(root.left, path + root.val + "->", answer);
        }
        if (root.right != null) {
            helper(root.right, path + root.val + "->", answer);
        }
    }

    public List<String> binaryTreePaths_3(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }
        for (String path : binaryTreePaths_3(root.left)) {
            res.add(root.val + "->" + path);
        }
        for (String path : binaryTreePaths_3(root.right)) {
            res.add(root.val + "->" + path);
        }
        return res;
    }

    // BFS with stack, first-order, top-to-down
    public List<String> binaryTreePaths_4(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();
        s1.push(root);
        s2.push(String.valueOf(root.val));
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            String path = s2.pop();
            if (node.left == null && node.right == null) {
                res.add(path);
                continue;
            }
            if (node.right != null) {
                s1.push(node.right);
                s2.push(path + "->" + node.right.val);
            }
            if (node.left != null) {
                s1.push(node.left);
                s2.push(path + "->" + node.left.val);
            }
        }
        return res;
    }

    // BFS with queue, top-to-down
    public List<String> binaryTreePaths_5(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<String> q2 = new LinkedList<>();
        q1.offer(root);
        q2.offer(String.valueOf(root.val));
        while (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q1.poll();
                String path = q2.poll();
                if (node.left == null && node.right == null) {
                    res.add(path);
                    continue;
                }
                if (node.left != null) {
                    q1.offer(node.left);
                    q2.offer(path + "->" + node.left.val);
                }
                if (node.right != null) {
                    q1.offer(node.right);
                    q2.offer(path + "->" + node.right.val);
                }
            }
        }
        return res;
    }

    // DFS with stack, post-order, down-to-top
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<List<String>> s2 = new Stack<>();
        TreeNode node = root;
        TreeNode preVisit = null;
        while (node != null || !s1.isEmpty()) {
            while (node != null) {
                s1.push(node);
                node = node.left;
            }
            node = s1.peek();
            if (node.right == null || node.right == preVisit) {
                node = s1.pop();
                // do something
                preVisit = node;
                node = null;
            } else {
                node = node.right;
            }
        }
        return res;
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
}
