package com.leetcode.leetcode_92_Reverse_Linked_List_II_Medium;

abstract class Solution92 {
    public abstract ListNode reverseBetween(ListNode head, int left, int right);

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static Solution92 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution92 {
        @Override
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(0, head);
            ListNode leftTail = dummy;
            for (int i = 1; i < left; i++) {
                leftTail = leftTail.next;
            }
            ListNode midTail = leftTail.next;
            for (int i = left; i < right; i++) {
                midTail = midTail.next;
            }
            ListNode rightHead = midTail.next;
            midTail.next = null;
            ListNode midHead = reverse(leftTail.next);
            midTail = getTail(midHead, right - left + 1);
            leftTail.next = midHead;
            midTail.next = rightHead;
            return dummy.next;
        }

        private ListNode reverse(ListNode head) {
            ListNode pre = null, cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }

        private ListNode getTail(ListNode head, int len) {
            for (int i = 1; i < len; i++) {
                head = head.next;
            }
            return head;
        }
    }

    private static class S2 extends Solution92 {
        @Override
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(0, head);
            ListNode leftTail = dummy;
            for (int i = 1; i < left; i++) {
                leftTail = leftTail.next;
            }
            ListNode midHead = leftTail.next, midTail = midHead;
            for (int i = left; i < right; i++) {
                midTail = midTail.next;
            }
            ListNode rightHead = midTail.next;
            midTail.next = null;
            reverse(leftTail.next);
            leftTail.next = midTail;
            midHead.next = rightHead;
            return dummy.next;
        }

        private ListNode reverse(ListNode head) {
            ListNode pre = null, cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }

    private static class S3 extends Solution92 {
        @Override
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode(0, head);
            ListNode pre = dummy;
            for (int i = 1; i < left; i++) {
                pre = pre.next;
            }
            ListNode start = pre.next, cur = start.next;
            for (int i = left; i < right; i++) {
                start.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = start.next;
            }
            return dummy.next;
        }
    }
}
