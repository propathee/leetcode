package com.leetcode.leetcode_86_Partition_List_Medium;

import org.junit.Test;

import com.leetcode.leetcode_86_Partition_List_Medium.Solution86.ListNode;

import static org.junit.Assert.*;

public class Solution86Tests {
    private Solution86 solution = Solution86.newSolution();

    @Test
    public void should_pass_1() {
        ListNode input = makeList(1,4,3,2,5,2);
        ListNode output = makeList(1,2,2,4,3,5);
        assertPass(output, solution.partition(input, 3));
    }

    @Test
    public void should_pass_2() {
        ListNode input = makeList(2,1);
        ListNode output = makeList(1,2);
        assertPass(output, solution.partition(input, 2));
    }

    private ListNode makeList(int... values) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        for (int val : values) {
            node.next = new ListNode(val);
            node = node.next;
        }
        return dummy.next;
    }

    private void assertPass(ListNode expect, ListNode actual) {
        while (expect != null) {
            assertEquals(expect.val, actual.val);
            expect = expect.next;
            actual = actual.next;
        }
        assertNull(actual);
    }
}