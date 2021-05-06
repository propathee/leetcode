package com.leetcode.leetcode_147_Insertion_Sort_List_Medium;

import com.leetcode.utils.ListNode;

abstract class Solution147 {
    public abstract ListNode insertionSortList(ListNode head);

    static Solution147 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution147 {
        @Override
        public ListNode insertionSortList(ListNode head) {
            ListNode cur = head.next;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            head.next = null;
            while (cur != null) {
                ListNode next = cur.next, cmp = dummy;
                while (true) {
                    if (cmp.next == null || cmp.next.val > cur.val) {
                        cur.next = cmp.next;
                        cmp.next = cur;
                        break;
                    } else {
                        cmp = cmp.next;
                    }
                }
                cur = next;
            }
            return dummy.next;
        }
    }

    private static class S2 extends Solution147 {
        @Override
        public ListNode insertionSortList(ListNode head) {
            ListNode cur = head, dummy = new ListNode(0);
            while (cur != null) {
                ListNode next = cur.next, pre = dummy;
                while (pre.next != null && pre.next.val < cur.val) {
                    pre = pre.next;
                }
                cur.next = pre.next;
                pre.next = cur;
                cur = next;
            }
            return dummy.next;
        }
    }
}
