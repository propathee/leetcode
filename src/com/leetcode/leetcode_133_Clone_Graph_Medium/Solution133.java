package com.leetcode.leetcode_133_Clone_Graph_Medium;

import java.util.*;

abstract class Solution133 {
    public abstract Node cloneGraph(Node node);

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    static Solution133 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution133 {
        private Map<Node, Node> map = new HashMap<>();

        @Override
        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            Node newNode = map.get(node);
            if (newNode!= null) {
                return newNode;
            }
            newNode = new Node(node.val, new ArrayList<>());
            map.put(node, newNode);
            List<Node> newNeighbors = new ArrayList<>();
            for (Node neighbor : node.neighbors) {
                newNode.neighbors.add(cloneGraph(neighbor));
            }
            return newNode;
        }
    }

    private static class S2 extends Solution133 {
        @Override
        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            Map<Node, Node> clonedMap = new HashMap<>();
            Node newNode = new Node(node.val, new ArrayList<>());
            clonedMap.put(node, newNode);
            Stack<Node> stack = new Stack<>();
            stack.push(node);
            while (!stack.isEmpty()) {
                Node n = stack.pop();
                for (Node neighbor : n.neighbors) {
                    if (!clonedMap.containsKey(neighbor)) {
                        clonedMap.put(neighbor, new Node(neighbor.val));
                        stack.add(neighbor);
                    }
                    clonedMap.get(n).neighbors.add(clonedMap.get(neighbor));
                }
            }
            return newNode;
        }
    }

    private static class S3 extends Solution133 {
        @Override
        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            Map<Node, Node> clonedMap = new HashMap<>();
            Node newNode = new Node(node.val, new ArrayList<>());
            clonedMap.put(node, newNode);
            Queue<Node> queue = new LinkedList<>();
            queue.offer(node);
            while (!queue.isEmpty()) {
                Node n = queue.poll();
                for (Node neighbor : n.neighbors) {
                    if (!clonedMap.containsKey(neighbor)) {
                        clonedMap.put(neighbor, new Node(neighbor.val));
                        queue.offer(neighbor);
                    }
                    clonedMap.get(n).neighbors.add(clonedMap.get(neighbor));
                }
            }
            return newNode;
        }
    }
}
