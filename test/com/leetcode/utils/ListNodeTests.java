package com.leetcode.utils;

import static org.junit.Assert.*;

public class ListNodeTests {
    public static ListNode makeList(int... values) {
        ListNode dummy = new ListNode(), node = dummy;
        for (int val : values) {
            node.next = new ListNode(val);
            node = node.next;
        }
        return dummy.next;
    }
}