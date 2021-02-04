package com.leetcode.leetcode_872_Leaf_Similar_Trees_Easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

abstract class Solution872 {
    public abstract boolean leafSimilar(TreeNode root1, TreeNode root2);

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

    static Solution872 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution872 {
        @Override
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> leaves1 = getLeaves(root1);
            List<Integer> leaves2 = getLeaves(root2);
            if (leaves1.size() != leaves2.size()) {
                return false;
            }
            for (int i = 0; i < leaves1.size(); i++) {
                if (leaves1.get(i).intValue() != leaves2.get(i)) {
                    return false;
                }
            }
            return true;
        }

        private List<Integer> getLeaves(TreeNode root) {
            List<Integer> leaves = new ArrayList<>();
            preorder(root, leaves);
            return leaves;
        }

        private void preorder(TreeNode root, List<Integer> leaves) {
            if (root.left == null && root.right == null) {
                leaves.add(root.val);
                return;
            }
            if (root.left != null) {
                preorder(root.left, leaves);
            }
            if (root.right != null) {
                preorder(root.right, leaves);
            }
        }
    }

    private static class S2 extends Solution872 {
        @Override
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            StringBuilder leaves1 = getLeaves(root1);
            StringBuilder leaves2 = getLeaves(root2);
            return leaves1.toString().equals(leaves2.toString());
        }

        private StringBuilder getLeaves(TreeNode root) {
            StringBuilder leaves = new StringBuilder();
            preorder(root, leaves);
            return leaves;
        }

        private void preorder(TreeNode root, StringBuilder leaves) {
            if (root == null) {
                return;
            } else if (root.left == null && root.right == null) {
                leaves.append(root.val).append(",");
            } else {
                preorder(root.left, leaves);
                preorder(root.right, leaves);
            }
        }
    }

    private static class S3 extends Solution872 {
        @Override
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            LeafIterator it1 = new LeafIterator(root1), it2 = new LeafIterator(root2);
            while (it1.hasNext() && it2.hasNext()) {
                if (it1.next().val != it2.next().val) {
                    return false;
                }
            }
            return !it1.hasNext() && !it2.hasNext();
        }

        private static class LeafIterator implements Iterator<TreeNode> {
            private Stack<TreeNode> stack = new Stack<>();

            private LeafIterator(TreeNode root) {
                stack.push(root);
                update();
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public TreeNode next() {
                TreeNode res = stack.pop();
                update();
                return res;
            }

            private void update() {
                while (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    if (node.left == null && node.right == null) {
                        stack.push(node);
                        break;
                    } else {
                        if (node.right != null) {
                            stack.push(node.right);
                        }
                        if (node.left != null) {
                            stack.push(node.left);
                        }
                    }
                }
            }
        }
    }

    private static class S4 extends Solution872 {
        @Override
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            LeafIterator it1 = new LeafIterator(root1), it2 = new LeafIterator(root2);
            while (it1.hasNext() && it2.hasNext()) {
                if (it1.next().val != it2.next().val) {
                    return false;
                }
            }
            return !it1.hasNext() && !it2.hasNext();
        }

        private static class LeafIterator implements Iterator<TreeNode> {
            private Stack<TreeNode> stack = new Stack<>();
            private TreeNode next;

            private LeafIterator(TreeNode root) {
                stack.push(root);
                next = findNext();
            }

            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public TreeNode next() {
                TreeNode res = next;
                next = findNext();
                return res;
            }

            private TreeNode findNext() {
                while (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    if (node.left == null && node.right == null) {
                        return node;
                    } else {
                        if (node.right != null) {
                            stack.push(node.right);
                        }
                        if (node.left != null) {
                            stack.push(node.left);
                        }
                    }
                }
                return null;
            }
        }
    }
}
