package com.leetcode.leetcode_237_Delete_Node_in_a_Linked_List_Easy;

import com.leetcode.leetcode_237_Delete_Node_in_a_Linked_List_Easy.Solution237.ListNode;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class Solution237Tests {
    private Solution237 solution = new Solution237();

    @Test
    public void should_pass_1() {
        List<ListNode> nodes = makeNodes(4, 5, 1, 9);
        ListNode delNode = nodes.get(1);
        ListNode actual = join(nodes);
        ListNode expect = makeList(4, 1, 9);

        solution.deleteNode(delNode);

        assertPass(expect, actual);
    }

    @Test
    public void should_pass_2() {
        List<ListNode> nodes = makeNodes(4, 5, 1, 9);
        ListNode delNode = nodes.get(2);
        ListNode actual = join(nodes);
        ListNode expect = makeList(4, 5, 9);

        solution.deleteNode(delNode);

        assertPass(expect, actual);
    }

    @Test
    public void should_pass_3() {
        List<ListNode> nodes = makeNodes(1, 2, 3, 4);
        ListNode delNode = nodes.get(2);
        ListNode actual = join(nodes);
        ListNode expect = makeList(1, 2, 4);

        solution.deleteNode(delNode);

        assertPass(expect, actual);
    }

    @Test
    public void should_pass_4() {
        List<ListNode> nodes = makeNodes(0, 1);
        ListNode delNode = nodes.get(0);
        ListNode actual = join(nodes);
        ListNode expect = makeList(1);

        solution.deleteNode(delNode);

        assertPass(expect, actual);
    }

    private List<ListNode> makeNodes(int... values) {
        return IntStream.of(values)
            .mapToObj(ListNode::new)
            .collect(Collectors.toList());
    }

    private ListNode join(List<ListNode> nodes) {
        ListNode dummy = new ListNode(-1);
        ListNode cursor = dummy;
        for (ListNode node : nodes) {
            cursor.next = node;
            cursor = cursor.next;
        }
        return dummy.next;
    }

    private ListNode makeList(int... values) {
        return join(makeNodes(values));
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