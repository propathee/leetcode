package com.leetcode.leetcode_148_Sort_List_Medium;

import com.leetcode.utils.ListNode;

abstract class Solution148 {
    public abstract ListNode sortList(ListNode head);

    static Solution148 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution148 {
        @Override
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode midHead = findMiddleAndCutOff(head);
            ListNode head1 = sortList(head);
            ListNode head2 = sortList(midHead);
            return merge(head1, head2);
        }

        private ListNode findMiddleAndCutOff(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode mid = slow.next;
            slow.next = null;
            return mid;
        }

        private ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummy = new ListNode(0), node = dummy;
            while (head1 != null && head2 != null) {
                if (head1.val < head2.val) {
                    node.next = head1;
                    head1 = head1.next;
                } else {
                    node.next = head2;
                    head2 = head2.next;
                }
                node = node.next;
            }
            if (head1 != null) {
                node.next = head1;
            } else {
                node.next = head2;
            }
            return dummy.next;
        }
    }
}
