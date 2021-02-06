package com.leetcode.leetcode_876_Middle_of_the_Linked_List_Easy;

import static org.junit.Assert.*;

import com.leetcode.leetcode_876_Middle_of_the_Linked_List_Easy.Solution876.ListNode;
import org.junit.Test;

public class Solution876Tests {
    private Solution876 solution = Solution876.newSolution();

    @Test
    public void should_pass_1() {
        ListNode head = makeList(1,2,3,4,5);
        assertEquals(3, solution.middleNode(head).val);
    }

    @Test
    public void should_pass_2() {
        ListNode head = makeList(1,2,3,4,5,6);
        assertEquals(4, solution.middleNode(head).val);
    }

    @Test
    public void should_pass_3() {
        ListNode head = makeList(1);
        assertEquals(1, solution.middleNode(head).val);
    }

    @Test
    public void should_pass_4() {
        ListNode head = makeList(1,2);
        assertEquals(2, solution.middleNode(head).val);
    }

    private ListNode makeList(Integer... values) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        for (int v : values) {
            node.next = new ListNode(v);
            node = node.next;
        }
        return dummy.next;
    }
}