package com.leetcode.leetcode_143_Reorder_List_Medium;

import com.leetcode.utils.ListNode;

abstract class Solution143 {
    public abstract void reorderList(ListNode head);

    static Solution143 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution143 {
        @Override
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
            ListNode head2 = cutFromMiddle(head);
            head2 = reverse(head2);
            merge(head, head2);
        }

        private ListNode cutFromMiddle(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode head2 = slow.next;
            slow.next = null;
            return head2;
        }

        private ListNode reverse(ListNode head) {
            if (head.next == null) {
                return head;
            }
            ListNode reversedHead = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return reversedHead;
        }

        private void merge(ListNode head1, ListNode head2) {
            while (head2 != null) {
                ListNode next2 = head2.next;
                head2.next = head1.next;
                head1.next = head2;
                head1 = head2.next;
                head2 = next2;
            }
        }
    }

    private static class S2 extends Solution143 {
        @Override
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) {
                return;
            }
            ListNode head2 = cutFromMiddle(head);
            head2 = reverse(head2);
            merge(head, head2);
        }

        private ListNode cutFromMiddle(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode head2 = slow.next;
            slow.next = null;
            return head2;
        }

        private ListNode reverse(ListNode head) {
            ListNode pre = null, cur = head, next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

        private void merge(ListNode head1, ListNode head2) {
            while (head2 != null) {
                ListNode next2 = head2.next;
                head2.next = head1.next;
                head1.next = head2;
                head1 = head2.next;
                head2 = next2;
            }
        }
    }
}
