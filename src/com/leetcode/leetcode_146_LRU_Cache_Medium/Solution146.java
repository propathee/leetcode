package com.leetcode.leetcode_146_LRU_Cache_Medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

abstract class Solution146 {
    static abstract class LRUCache {
        public abstract int get(int key);

        public abstract void put(int key, int value);
    }

    static LRUCache newCache(int capacity) {
        return new LRUCache4(capacity);
    }

    private static class LRUCache1 extends LRUCache {
        private int capacity;
        private LinkedHashMap<Integer, Integer> linkedHashMap;

        public LRUCache1(int capacity) {
            this.capacity = capacity;
            linkedHashMap = new LinkedHashMap<>();
        }

        @Override
        public int get(int key) {
            Integer value = linkedHashMap.remove(key);
            if (value == null) {
                return -1;
            } else {
                linkedHashMap.put(key, value);
                return value;
            }
        }

        @Override
        public void put(int key, int value) {
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
            if (linkedHashMap.size() > capacity) {
                linkedHashMap.remove(linkedHashMap.keySet().iterator().next());
            }
        }
    }

    private static class LRUCache2 extends LRUCache {
        private LinkedHashMap<Integer, Integer> linkedHashMap;

        public LRUCache2(int capacity) {
            linkedHashMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry eldest) {
                    return size() > capacity;
                }
            };
        }

        @Override
        public int get(int key) {
            return linkedHashMap.getOrDefault(key, -1);
        }

        @Override
        public void put(int key, int value) {
            linkedHashMap.put(key, value);
        }
    }

    private static class LRUCache3 extends LRUCache {
        private static class Node {
            private int key;
            private int value;
            private Node next;
            private Node prev;
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer, Node> map = new HashMap<>();
        private Node head;
        private Node tail;
        private int capacity;

        public LRUCache3(int capacity) {
            this.capacity = capacity;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        @Override
        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            } else {
                put(key, node.value);
                return node.value;
            }
        }

        @Override
        public void put(int key, int value) {
            Node node = new Node(key, value);
            if (!map.containsKey(key)) {
                addAtTail(node);
                removeHeadIfExceedCapacity();
            } else {
                remove(map.get(key));
                addAtTail(node);
            }
        }

        private void addAtTail(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            map.put(node.key, node);
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            map.remove(node.key);
        }

        private void removeHeadIfExceedCapacity() {
            if (map.size() > capacity) {
                remove(head.next);
            }
        }
    }

    private static class LRUCache4 extends LRUCache {
        private static class Node {
            private int key;
            private int value;
            private Node next;
            private Node prev;
            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer, Node> map = new HashMap<>();
        private Node head;
        private Node tail;
        private int capacity;

        public LRUCache4(int capacity) {
            this.capacity = capacity;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        @Override
        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            } else {
                put(key, node.value);
                return node.value;
            }
        }

        @Override
        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                addAtTail(new Node(key, value));
                if (map.size() > capacity) {
                    remove(head.next);
                }
            } else {
                Node node = map.get(key);
                remove(node);
                node.value = value;
                addAtTail(node);
            }
        }

        private void addAtTail(Node node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
            map.put(node.key, node);
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            map.remove(node.key);
        }
    }
}
