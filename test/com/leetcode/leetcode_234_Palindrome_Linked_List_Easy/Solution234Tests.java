package com.leetcode.leetcode_234_Palindrome_Linked_List_Easy;

import com.leetcode.leetcode_234_Palindrome_Linked_List_Easy.Solution234.ListNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution234Tests {
    private Solution234 solution = new Solution234();

    @Test
    public void should_pass_1() {
        assertFalse(solution.isPalindrome(makeList(1, 2)));
    }

    @Test
    public void should_pass_2() {
        assertTrue(solution.isPalindrome(makeList(1, 2, 2, 1)));
    }

    @Test
    public void should_pass_3() {
        assertTrue(solution.isPalindrome(makeList(1)));
    }

    @Test
    public void should_pass_4() {
        assertTrue(solution.isPalindrome(makeList(-129, -129)));
    }

    @Test
    public void should_pass_5() {
        assertTrue(solution.isPalindrome(makeList(1, 0, 1)));
    }

    private ListNode makeList(int... values) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        for (int v : values) {
            node.next = new ListNode(v);
            node = node.next;
        }
        return dummy.next;
    }
}