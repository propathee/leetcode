package com.leetcode.leetcode_234_Palindrome_Linked_List_Easy;

import java.util.ArrayList;
import java.util.List;

public class Solution234 {
    public boolean isPalindrome_1(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome_2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode pre = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        ListNode head1 = head;
        ListNode head2 = pre;
        while (head2 != null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

    public boolean isPalindrome_3(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode head1 = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            head1.next = pre;
            pre = head1;
            head1 = slow;
        }
        ListNode head2 = fast == null ? slow : slow.next;
        head1 = pre;
        while (head1!= null) {
            if (head1.val != head2.val) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return true;
    }

    private ListNode ref;

    public boolean isPalindrome(ListNode head) {
        ref = head;
        return check(head);
    }

    private boolean check(ListNode node) {
        if (node == null) {
            return true;
        }
        if (!check(node.next)) {
            return false;
        }
        if (ref.val != node.val) {
            return false;
        } else {
            ref = ref.next;
            return true;
        }
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
