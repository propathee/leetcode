package com.leetcode.leetcode_92_Reverse_Linked_List_II_Medium;

import org.junit.Test;
import com.leetcode.leetcode_92_Reverse_Linked_List_II_Medium.Solution92.ListNode;

import static org.junit.Assert.*;

public class Solution92Tests {
    private Solution92 solution = Solution92.newSolution();

    @Test
    public void should_pass_1() {
        ListNode input = makeList(1,2,3,4,5);
        ListNode output = makeList(1,4,3,2,5);
        assertPass(output, solution.reverseBetween(input, 2, 4));
    }

    @Test
    public void should_pass_2() {
        ListNode input = makeList(5);
        ListNode output = makeList(5);
        assertPass(output, solution.reverseBetween(input, 1, 1));
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