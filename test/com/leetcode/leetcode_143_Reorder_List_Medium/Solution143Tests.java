package com.leetcode.leetcode_143_Reorder_List_Medium;

import com.leetcode.utils.ListNode;
import org.junit.Test;

import static com.leetcode.utils.ListNodeTests.assertLinkedListEquals;
import static com.leetcode.utils.ListNodeTests.makeList;
import static org.junit.Assert.*;

public class Solution143Tests {
    private Solution143 solution = Solution143.newSolution();

    @Test
    public void should_pass_1() {
        ListNode head = makeList(1,2,3,4);
        ListNode expect = makeList(1,4,2,3);
        solution.reorderList(head);
        assertLinkedListEquals(expect, head);
    }

    @Test
    public void should_pass_2() {
        ListNode head = makeList(1,2,3,4,5);
        ListNode expect = makeList(1,5,2,4,3);
        solution.reorderList(head);
        assertLinkedListEquals(expect, head);
    }

    @Test
    public void should_pass_3() {
        ListNode head = makeList(1,2,3,4,5,6);
        ListNode expect = makeList(1,6,2,5,3,4);
        solution.reorderList(head);
        assertLinkedListEquals(expect, head);
    }

    @Test
    public void should_pass_4() {
        ListNode head = makeList(1,2,3,4,5,6,7);
        ListNode expect = makeList(1,7,2,6,3,5,4);
        solution.reorderList(head);
        assertLinkedListEquals(expect, head);
    }

    @Test
    public void should_pass_5() {
        ListNode head = makeList(1);
        ListNode expect = makeList(1);
        solution.reorderList(head);
        assertLinkedListEquals(expect, head);
    }
}