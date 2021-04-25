package com.leetcode.leetcode_138_Copy_List_with_Random_Pointer_Medium;

import com.leetcode.leetcode_138_Copy_List_with_Random_Pointer_Medium.Solution138.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Solution138Tests {
    private Solution138 solution = Solution138.newSolution();

    @Test
    public void should_pass_1() {
        Node input = makeList("[7,null],[13,0],[11,4],[10,2],[1,0]");
        Node output = solution.copyRandomList(input);
        assertPass(input, output);
    }

    @Test
    public void should_pass_2() {
        Node input = makeList("[1,1],[2,1]");
        Node output = solution.copyRandomList(input);
        assertPass(input, output);
    }

    @Test
    public void should_pass_3() {
        Node input = makeList("[3,null],[3,0],[3,null]");
        Node output = solution.copyRandomList(input);
        assertPass(input, output);
    }

    @Test
    public void should_pass_4() {
        Node input = null;
        Node output = solution.copyRandomList(input);
        assertPass(input, output);
    }

    private Node makeList(String s) {
        Node dummy = new Node(0);
        Node cur = dummy;
        List<Node> list = new ArrayList<>();
        Integer[][] templates = parseNodeTemplates(s);
        for (Integer[] temp : templates) {
            Node node = new Node(temp[0]);
            cur.next = node;
            cur = node;
            list.add(node);
        }
        cur = dummy.next;
        for (Integer[] temp : templates) {
            if (temp[1] != null) {
                cur.random = list.get(temp[1]);
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    private Integer[][] parseNodeTemplates(String s) {
        s = s.substring(1, s.length() - 1).replace("[", "");
        return Arrays.stream(s.split("],"))
            .map(this::parseNode)
            .collect(Collectors.toList())
            .toArray(new Integer[0][]);
    }

    private Integer[] parseNode(String s) {
        Integer[] res = new Integer[2];
        String[] pair = s.split(",");
        res[0] = Integer.parseInt(pair[0]);
        if (!"null".equals(pair[1])) {
            res[1] = Integer.parseInt(pair[1]);
        }
        return res;
    }

    private void assertPass(Node oldNode, Node newNode) {
        if (oldNode == null) {
            assertNull(newNode);
            return;
        }
        assertEquals(oldNode.val, newNode.val);
        assertNotSame(oldNode, newNode);
        if (oldNode.random != null) {
            assertEquals(oldNode.random.val, newNode.random.val);
            assertNotSame(oldNode.random, newNode.random);
        }
        assertPass(oldNode.next, newNode.next);
    }
}