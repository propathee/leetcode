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

    public static void assertLinkedListEquals(ListNode expect, ListNode actual) {
        if (expect == null) {
            assertNull(actual);
        } else {
            assertEquals(expect.val, actual.val);
            assertLinkedListEquals(expect.next, actual.next);
        }
    }
}