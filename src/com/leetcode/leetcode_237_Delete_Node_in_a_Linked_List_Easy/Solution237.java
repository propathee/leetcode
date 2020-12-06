package com.leetcode.leetcode_237_Delete_Node_in_a_Linked_List_Easy;

public class Solution237 {
    public void deleteNode_1(ListNode node) {
        while (node.next != null && node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
