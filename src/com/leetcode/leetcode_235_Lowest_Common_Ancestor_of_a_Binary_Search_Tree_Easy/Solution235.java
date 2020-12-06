package com.leetcode.leetcode_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree_Easy;

import java.util.ArrayList;
import java.util.List;

public class Solution235 {
    public TreeNode lowestCommonAncestor_1(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = findAncestors(root, p);
        List<TreeNode> qAncestors = findAncestors(root, q);
        int commonLen = Math.min(pAncestors.size(), qAncestors.size());
        for (int i = commonLen - 1; i >= 0; i--) {
            if (pAncestors.get(i).val == qAncestors.get(i).val) {
                return pAncestors.get(i);
            }
        }
        return root;
    }

    private List<TreeNode> findAncestors(TreeNode root, TreeNode node) {
        List<TreeNode> res = new ArrayList<>();
        res.add(root);
        TreeNode cmp = root;
        while (cmp.val != node.val) {
            cmp = cmp.val > node.val ? cmp.left : cmp.right;
            res.add(cmp);
        }
        return res;
    }

    public TreeNode lowestCommonAncestor_2(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val <= root.val && root.val <= q.val)
            || (q.val <= root.val && root.val <= p.val)) {
            return root;
        }
        if (p.val > root.val) {
            return lowestCommonAncestor_2(root.right, p, q);
        } else {
            return lowestCommonAncestor_2(root.left, p, q);
        }
    }

    public TreeNode lowestCommonAncestor_3(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor_3(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor_3(root.right, p, q);
        } else {
            return root;
        }
    }

    public TreeNode lowestCommonAncestor_4(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = root.val > p.val ? root.left : root.right;
        }
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return ((root.val - p.val) * (root.val - q.val) <= 0) ? root
            : lowestCommonAncestor(root.val > p.val ? root.left : root.right, p, q);
    }

    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
