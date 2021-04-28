package com.leetcode.leetcode_142_Linked_List_Cycle_II_Medium;

import com.leetcode.utils.ListNode;

import java.util.HashSet;
import java.util.Set;

abstract class Solution142 {
    public abstract ListNode detectCycle(ListNode head);

    static Solution142 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution142 {
        @Override
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            while (head != null) {
                if (!set.add(head)) {
                    return head;
                }
                head = head.next;
            }
            return null;
        }
    }

    // A + B + n*C = 2*A + 2*B
    private static class S2 extends Solution142 {
        @Override
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    ListNode slow2 = head;
                    while (slow != slow2) {
                        slow = slow.next;
                        slow2 = slow2.next;
                    }
                    return slow;
                }
            }
            return null;
        }
    }
}
