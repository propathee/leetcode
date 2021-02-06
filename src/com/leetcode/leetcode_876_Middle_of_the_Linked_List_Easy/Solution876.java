package com.leetcode.leetcode_876_Middle_of_the_Linked_List_Easy;

abstract class Solution876 {
    public abstract ListNode middleNode(ListNode head);

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static Solution876 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution876 {
        @Override
        public ListNode middleNode(ListNode head) {
            int len = 0;
            for (ListNode node = head; node != null; node = node.next) {
                len++;
            }
            for (int i = len / 2; i > 0; i--) {
                head = head.next;
            }
            return head;
        }
    }

    private static class S2 extends Solution876 {
        @Override
        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
