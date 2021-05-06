package com.leetcode.leetcode_147_Insertion_Sort_List_Medium;

import com.leetcode.utils.ListNode;
import org.junit.Test;

import static com.leetcode.utils.ListNodeTests.assertLinkedListEquals;
import static com.leetcode.utils.ListNodeTests.makeLinkedList;
import static org.junit.Assert.*;

public class Solution147Tests {
    private Solution147 solution = Solution147.newSolution();

    @Test
    public void should_pass_1() {
        ListNode head = makeLinkedList(4,2,1,3);
        ListNode sortedHead = makeLinkedList(1,2,3,4);
        assertLinkedListEquals(sortedHead, solution.insertionSortList(head));
    }

    @Test
    public void should_pass_2() {
        ListNode head = makeLinkedList(-1,5,3,4,0);
        ListNode sortedHead = makeLinkedList(-1,0,3,4,5);
        assertLinkedListEquals(sortedHead, solution.insertionSortList(head));
    }

    @Test
    public void should_pass_3() {
        ListNode head = makeLinkedList(0);
        ListNode sortedHead = makeLinkedList(0);
        assertLinkedListEquals(sortedHead, solution.insertionSortList(head));
    }

    @Test
    public void should_pass_4() {
        ListNode head = makeLinkedList(2,1,0,3,2);
        ListNode sortedHead = makeLinkedList(0,1,2,2,3);
        assertLinkedListEquals(sortedHead, solution.insertionSortList(head));
    }
}