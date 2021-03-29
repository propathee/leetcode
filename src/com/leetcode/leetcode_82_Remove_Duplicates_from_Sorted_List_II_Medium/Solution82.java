package com.leetcode.leetcode_82_Remove_Duplicates_from_Sorted_List_II_Medium;

abstract class Solution82 {
    public abstract ListNode deleteDuplicates(ListNode head);

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static Solution82 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution82 {
        @Override
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(-200, head), p = dummy, q = head;
            while (q != null) {
                int cnt = 0;
                while (q.next != null && q.next.val == q.val) {
                    q = q.next;
                    cnt++;
                }
                q = q.next;
                if (cnt == 0) {
                    p = p.next;
                } else {
                    p.next = q;
                }
            }
            return dummy.next;
        }
    }

    private static class S2 extends Solution82 {
        private int cnt = 0;

        @Override
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(-200, head), p = dummy, q = head;
            while (q != null) {
                q = findNextNonDuplicated(q);
                if (hasDuplicate()) {
                    p.next = q;
                } else {
                    p = p.next;
                }
            }
            return dummy.next;
        }

        private ListNode findNextNonDuplicated(ListNode node) {
            cnt = 0;
            while (node.next != null && node.next.val == node.val) {
                node = node.next;
                cnt++;
            }
            return node.next;
        }

        private boolean hasDuplicate() {
            return cnt > 0;
        }
    }

    private static class S3 extends Solution82 {
        @Override
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(-200, head), p = dummy, q = head;
            while (q != null) {
                while (q.next != null && q.next.val == q.val) {
                    q = q.next;
                }
                if (p.next == q) {
                    p = p.next;
                } else {
                    p.next = q.next;
                }
                q = q.next;
            }
            return dummy.next;
        }
    }

    private static class S4 extends Solution82 {
        @Override
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next != null && head.next.val == head.val) {
                while (head.next != null && head.next.val == head.val) {
                    head = head.next;
                }
                return deleteDuplicates(head.next);
            } else {
                head.next = deleteDuplicates(head.next);
                return head;
            }
        }
    }
}
