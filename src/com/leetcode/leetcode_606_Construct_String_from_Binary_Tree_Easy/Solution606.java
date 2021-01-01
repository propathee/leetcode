package com.leetcode.leetcode_606_Construct_String_from_Binary_Tree_Easy;

import java.util.Stack;

abstract class Solution606 {
    public abstract String tree2str(TreeNode t);

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

    static Solution606 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution606 {
        @Override
        public String tree2str(TreeNode t) {
            if (t == null) {
                return "";
            }
            if (t.left == null && t.right == null) {
                return String.valueOf(t.val);
            }
            if (t.right == null) {
                return t.val + "(" + tree2str(t.left) + ")";
            }
            return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
        }
    }

    private static class S2 extends Solution606 {
        private StringBuilder strBuilder = new StringBuilder();

        @Override
        public String tree2str(TreeNode t) {
            helper(t);
            return strBuilder.toString();
        }

        private void helper(TreeNode t) {
            if (t == null) {
                return;
            }
            if (t.left == null && t.right == null) {
                strBuilder.append(t.val);
            } else {
                strBuilder.append(t.val).append("(");
                helper(t.left);
                strBuilder.append(")");
                if (t.right != null) {
                    strBuilder.append("(");
                    helper(t.right);
                    strBuilder.append(")");
                }
            }
        }
    }

    private static class S3 extends Solution606 {
        @Override
        public String tree2str(TreeNode t) {
            if (t == null) {
                return "";
            }
            String res = String.valueOf(t.val);
            String l = tree2str(t.left);
            String r = tree2str(t.right);

            if ("".equals(l) && "".equals(r)) {
                return res;
            } else if ("".equals(l)) {
                return res + "()" + "(" + r + ")";
            } else if ("".equals(r)) {
                return res + "(" + l + ")";
            } else {
                return res + "(" + l + ")(" + r + ")";
            }
        }
    }

    private static class S4 extends Solution606 {
        @Override
        public String tree2str(TreeNode t) {
            StringBuilder strBuilder = new StringBuilder();
            helper(t, strBuilder);
            return strBuilder.toString();
        }

        private void helper(TreeNode t, StringBuilder strBuilder) {
            if (t == null) {
                return;
            }
            strBuilder.append(t.val);
            if (t.left != null || t.right != null) {
                strBuilder.append("(");
                helper(t.left, strBuilder);
                strBuilder.append(")");
                if (t.right != null) {
                    strBuilder.append("(");
                    helper(t.right, strBuilder);
                    strBuilder.append(")");
                }
            }
        }
    }

    private static class S5 extends Solution606 {
        @Override
        public String tree2str(TreeNode t) {
            if (t == null) {
                return "";
            }
            StringBuilder strBuilder = new StringBuilder();
            TreeNode dummy = new TreeNode();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(t);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node == dummy) {
                    strBuilder.append(")");
                    continue;
                }
                strBuilder.append("(").append(node.val);
                stack.push(dummy);
                if (node.left != null || node.right != null) {
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    if (node.left == null) {
                        strBuilder.append("()");
                    } else {
                        stack.push(node.left);
                    }
                }
            }
            return strBuilder.substring(1, strBuilder.length() - 1);
        }
    }
}
