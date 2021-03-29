package com.leetcode.leetcode_86_Partition_List_Medium;

abstract class Solution86 {
    public abstract ListNode partition(ListNode head, int x);

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static Solution86 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution86 {
        @Override
        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(), head1 = dummy1;
            ListNode dummy2 = new ListNode(), head2 = dummy2;
            for (; head != null; head = head.next) {
                if (head.val < x) {
                    head1.next = head;
                    head1 = head;
                } else {
                    head2.next = head;
                    head2 = head;
                }
            }
            head1.next = dummy2.next;
            head2.next = null;
            return dummy1.next;
        }
    }

    private static class S2 extends Solution86 {
        @Override
        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(), head1 = dummy1;
            ListNode dummy2 = new ListNode(), head2 = dummy2;
            for (; head != null; head = head.next) {
                if (head.val < x) {
                    head1.next = head;
                    head1 = head;
                } else {
                    head2.next = head;
                    head2 = head;
                }
            }
            head1.next = dummy2.next;
            head2.next = null;
            return dummy1.next;
        }
    }
}
