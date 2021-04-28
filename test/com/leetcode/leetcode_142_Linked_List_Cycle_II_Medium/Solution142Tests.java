package com.leetcode.leetcode_142_Linked_List_Cycle_II_Medium;

import com.leetcode.utils.ListNode;
import org.junit.Test;

import static com.leetcode.utils.ListNodeTests.makeList;
import static org.junit.Assert.*;

public class Solution142Tests {
    private Solution142 solution = Solution142.newSolution();

    @Test
    public void should_pass_1() {
        ListNode head = makeList(3,2,0,-4);
        ListNode cycleHead = joinAndGetCycleHead(head, 1);
        assertSame(cycleHead, solution.detectCycle(head));
    }

    @Test
    public void should_pass_2() {
        ListNode head = makeList(1,2);
        ListNode cycleHead = joinAndGetCycleHead(head, 0);
        assertSame(cycleHead, solution.detectCycle(head));
    }

    @Test
    public void should_pass_3() {
        ListNode head = makeList(1);
        ListNode cycleHead = joinAndGetCycleHead(head, -1);
        assertSame(cycleHead, solution.detectCycle(head));
    }

    private ListNode joinAndGetCycleHead(ListNode head, int pos) {
        if (pos < 0) {
            return null;
        }
        int idx = 0;
        ListNode cycleHead = null;
        while (head.next != null) {
            if (idx == pos) {
                cycleHead = head;
            }
            head = head.next;
            idx++;
        }
        head.next = cycleHead;
        return cycleHead;
    }
}