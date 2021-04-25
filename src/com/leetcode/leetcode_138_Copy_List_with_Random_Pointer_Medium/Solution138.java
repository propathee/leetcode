package com.leetcode.leetcode_138_Copy_List_with_Random_Pointer_Medium;

import java.util.HashMap;
import java.util.Map;

abstract class Solution138 {
    public abstract Node copyRandomList(Node head);

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static Solution138 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution138 {
        private Map<Node, Node> old2new = new HashMap<>();

        @Override
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node cpHead = copyListIgnoreRandom(head);
            replaceRandom(cpHead);
            return cpHead;
        }

        private Node copyListIgnoreRandom(Node node) {
            Node cpNode = new Node(node.val);
            cpNode.random = node.random;
            old2new.put(node, cpNode);
            if (node.next != null) {
                cpNode.next = copyListIgnoreRandom(node.next);
            }
            return cpNode;
        }

        private void replaceRandom(Node node) {
            if (node.random != null) {
                node.random = old2new.get(node.random);
            }
            if (node.next != null) {
                replaceRandom(node.next);
            }
        }
    }

    private static class S2 extends Solution138 {
        @Override
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Map<Node, Node> old2new = new HashMap<>();
            Node node = head;
            while (node != null) {
                old2new.put(node, new Node(node.val));
                node = node.next;
            }
            node = head;
            while (node != null) {
                old2new.get(node).next = old2new.get(node.next);
                if (node.random != null) {
                    old2new.get(node).random = old2new.get(node.random);
                }
                node = node.next;
            }
            return old2new.get(head);
        }
    }

    private static class S3 extends Solution138 {
        @Override
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Node iter = head;
            while (iter != null) {
                Node copy = new Node(iter.val);
                copy.next = iter.next;
                iter.next = copy;
                iter = copy.next;
            }
            iter = head;
            while (iter != null) {
                if (iter.random != null) {
                    iter.next.random = iter.random.next;
                }
                iter = iter.next.next;
            }
            Node newHead = head.next;
            iter = head;
            while (iter != null) {
                Node copy = iter.next;
                iter.next = copy.next;
                if (copy.next != null) {
                    copy.next = copy.next.next;
                }
                iter = iter.next;
            }
            return newHead;
        }
    }
}
