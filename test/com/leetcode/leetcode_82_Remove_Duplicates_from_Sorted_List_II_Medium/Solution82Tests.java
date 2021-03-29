package com.leetcode.leetcode_82_Remove_Duplicates_from_Sorted_List_II_Medium;

import org.junit.Test;

import static org.junit.Assert.*;

import com.leetcode.leetcode_82_Remove_Duplicates_from_Sorted_List_II_Medium.Solution82.ListNode;

public class Solution82Tests {
    private Solution82 solution = Solution82.newSolution();

    @Test
    public void should_pass_1() {
        ListNode actual = solution.deleteDuplicates(makeList(1,2,3,3,4,4,5));
        ListNode expect = makeList(1,2,5);
        assertPass(expect, actual);
    }

    @Test
    public void should_pass_2() {
        ListNode actual = solution.deleteDuplicates(makeList(1,1,1,2,3));
        ListNode expect = makeList(2,3);
        assertPass(expect, actual);
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