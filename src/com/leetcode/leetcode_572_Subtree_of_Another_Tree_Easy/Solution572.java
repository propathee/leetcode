package com.leetcode.leetcode_572_Subtree_of_Another_Tree_Easy;

import java.util.ArrayList;
import java.util.List;

abstract class Solution572 {
    public abstract boolean isSubtree(TreeNode s, TreeNode t);

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

    static Solution572 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution572 {
        @Override
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) {
                return false;
            }
            return equals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        private boolean equals(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
                return true;
            }
            if (s != null && t != null) {
                return s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
            }
            return false;
        }
    }

    private static class S2 extends Solution572 {
        @Override
        public boolean isSubtree(TreeNode s, TreeNode t) {
            StringBuilder sbS = new StringBuilder();
            StringBuilder sbT = new StringBuilder();
            toString(s, sbS);
            toString(t, sbT);
            return sbS.toString().contains(sbT.toString());
        }

        private void toString(TreeNode s, StringBuilder strBuilder) {
            if (s == null) {
                strBuilder.append(",#");
            } else {
                strBuilder.append(",").append(s.val);
                toString(s.left, strBuilder);
                toString(s.right, strBuilder);
            }
        }
    }

    private static class S3 extends Solution572 {
        List<TreeNode> nodes = new ArrayList<>();

        @Override
        public boolean isSubtree(TreeNode s, TreeNode t) {
            getDepthAndCollectNodes(s, getDepth(t));
            for (TreeNode node : nodes) {
                if (equals(node, t)) {
                    return true;
                }
            }
            return false;
        }

        private int getDepth(TreeNode t) {
            return t == null ? 0 : Math.max(getDepth(t.left), getDepth(t.right)) + 1;
        }

        private int getDepthAndCollectNodes(TreeNode s, int depth) {
            if (s == null) {
                return 0;
            }
            int sDepth = 1 + Math.max(getDepthAndCollectNodes(s.left, depth), getDepthAndCollectNodes(s.right, depth));
            if (sDepth == depth) {
                nodes.add(s);
            }
            return sDepth;
        }

        private boolean equals(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
                return true;
            } else if (s == null || t == null) {
                return false;
            }
            return s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
        }
    }
}
