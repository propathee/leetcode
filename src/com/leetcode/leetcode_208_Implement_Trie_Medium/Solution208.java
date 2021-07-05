package com.leetcode.leetcode_208_Implement_Trie_Medium;

import java.util.HashMap;
import java.util.Map;

abstract class Solution208 {
    static abstract class Trie {
        /** Inserts a word into the trie. */
        public abstract void insert(String word);

        /** Returns if the word is in the trie. */
        public abstract boolean search(String word);

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public abstract boolean startsWith(String prefix);
    }

    static Trie newTrie() {
        return new Trie2();
    }

    private static class Trie1 extends Trie {
        private Node root;

        public Trie1() {
            root = new Node();
        }

        @Override
        public void insert(String word) {
            Node node = root;
            for (char c : word.toCharArray()) {
                Node child;
                if (node.children.containsKey(c)) {
                    child = node.children.get(c);
                } else {
                    child = new Node();
                    node.children.put(c, child);
                }
                node = child;
            }
            node.isEnd = true;
        }

        @Override
        public boolean search(String word) {
            Node node = findWordStartsWith(word);
            return node != null && node.isEnd;
        }

        @Override
        public boolean startsWith(String prefix) {
            Node node = findWordStartsWith(prefix);
            return node != null;
        }

        private Node findWordStartsWith(String prefix) {
            Node node = root;
            for (int i = 0; i < prefix.length() && node != null; i++) {
                char c = prefix.charAt(i);
                node = node.children.get(c);
            }
            return node;
        }

        private static class Node {
            private Map<Character, Node> children = new HashMap<>();
            private boolean isEnd;
        }
    }

    private static class Trie2 extends Trie {
        private Node root;

        public Trie2() {
            root = new Node();
        }

        @Override
        public void insert(String word) {
            Node node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new Node();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        @Override
        public boolean search(String word) {
            Node node = findWordStartsWith(word);
            return node != null && node.isWord;
        }

        @Override
        public boolean startsWith(String prefix) {
            Node node = findWordStartsWith(prefix);
            return node != null;
        }

        private Node findWordStartsWith(String prefix) {
            Node node = root;
            for (int i = 0; i < prefix.length() && node != null; i++) {
                char c = prefix.charAt(i);
                node = node.children[c - 'a'];
            }
            return node;
        }

        private static class Node {
            private Node[] children = new Node[26];
            private boolean isWord;
        }
    }
}
