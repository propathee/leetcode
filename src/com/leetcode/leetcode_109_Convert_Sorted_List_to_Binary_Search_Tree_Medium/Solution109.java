package com.leetcode.leetcode_109_Convert_Sorted_List_to_Binary_Search_Tree_Medium;

import com.leetcode.utils.ListNode;
import com.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

abstract class Solution109 {
    public abstract TreeNode sortedListToBST(ListNode head);

    static Solution109 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution109 {
        @Override
        public TreeNode sortedListToBST(ListNode head) {
            List<Integer> values = new ArrayList<>();
            for (; head != null; head = head.next) {
                values.add(head.val);
            }
            return sortedListToBST(values);
        }

        private TreeNode sortedListToBST(List<Integer> values) {
            if (values.size() == 0) {
                return null;
            }
            int midIdx = values.size() / 2;
            TreeNode root = new TreeNode(values.get(midIdx));
            root.left = sortedListToBST(values.subList(0, midIdx));
            root.right = sortedListToBST(values.subList(midIdx + 1, values.size()));
            return root;
        }
    }

    private static class S2 extends Solution109 {
        @Override
        public TreeNode sortedListToBST(ListNode head) {
            List<Integer> values = new ArrayList<>();
            for (; head != null; head = head.next) {
                values.add(head.val);
            }
            return sortedListToBST(values, 0, values.size());
        }

        private TreeNode sortedListToBST(List<Integer> values, int l, int r) {
            if (l == r) {
                return null;
            }
            int midIdx = (l + r) / 2;
            TreeNode root = new TreeNode(values.get(midIdx));
            root.left = sortedListToBST(values, l, midIdx);
            root.right = sortedListToBST(values, midIdx + 1, r);
            return root;
        }
    }

    private static class S3 extends Solution109 {
        @Override
        public TreeNode sortedListToBST(ListNode head) {
            return sortedListToBST(head, null);
        }

        private TreeNode sortedListToBST(ListNode head, ListNode tail) {
            if (head == tail) {
                return null;
            }
            ListNode fast = head, slow = head;
            while (fast != tail && fast.next != tail) {
                fast = fast.next.next;
                slow = slow.next;
            }
            TreeNode root = new TreeNode(slow.val);
            root.left = sortedListToBST(head, slow);
            root.right = sortedListToBST(slow.next, tail);
            return root;
        }
    }

    private static class S4 extends Solution109 {
        private ListNode curNode;

        @Override
        public TreeNode sortedListToBST(ListNode head) {
            curNode = head;
            int len = 0;
            for (ListNode node = head; node != null; node = node.next) {
                len++;
            }
            return sortedListToBST(0, len);
        }

        private TreeNode sortedListToBST(int l, int r) {
            if (l == r) {
                return null;
            }
            int mid = (l + r) / 2;
            TreeNode leftChild = sortedListToBST(l, mid);
            TreeNode root = new TreeNode(curNode.val);
            root.left = leftChild;
            curNode = curNode.next;
            root.right = sortedListToBST(mid + 1, r);
            return root;
        }
    }

    private static class S5 extends Solution109 {
        @Override
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return new TreeNode(head.val);
            }
            ListNode fast = head.next.next, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode midNode = slow.next;
            slow.next = null;
            TreeNode root = new TreeNode(midNode.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(midNode.next);
            return root;
        }
    }
}
