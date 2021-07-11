package com.leetcode.leetcode_211_Design_Add_and_Search_Words_Data_Structure_Medium;

import java.util.*;
import java.util.regex.Pattern;

abstract class Solution211 {
    static abstract class WordDictionary {
        public WordDictionary() {
        }

        public abstract void addWord(String word);

        public abstract boolean search(String word);
    }

    static WordDictionary newDictionary() {
        return new WordDictionary5();
    }

    private static class WordDictionary1 extends WordDictionary {
        private TrieNode root;

        public WordDictionary1() {
            root = new TrieNode();
        }

        @Override
        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        @Override
        public boolean search(String word) {
            return search(root, word, 0);
        }

        private boolean search(TrieNode node, String word, int charIndex) {
            if (node == null) {
                return false;
            }
            if (charIndex == word.length()) {
                return node.isWord;
            }
            char c = word.charAt(charIndex);
            if (c != '.') {
                return search(node.children[c - 'a'], word, charIndex + 1);
            } else {
                for (TrieNode childNode : node.children) {
                    if (search(childNode, word, charIndex + 1)) {
                        return true;
                    }
                }
                return false;
            }
        }

        private static class TrieNode {
            private TrieNode[] children = new TrieNode[27];
            private boolean isWord;
        }
    }

    private static class WordDictionary2 extends WordDictionary {
        private TrieNode root = new TrieNode();

        @Override
        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        @Override
        public boolean search(String word) {
            return search(root, word.toCharArray(), 0);
        }

        private boolean search(TrieNode node, char[] chars, int charIndex) {
            if (charIndex == chars.length) {
                return node.isWord;
            }
            char c = chars[charIndex];
            if (c != '.') {
                return node.children[c - 'a'] != null
                    && search(node.children[c - 'a'], chars, charIndex + 1);
            } else {
                for (TrieNode childNode : node.children) {
                    if (childNode != null && search(childNode, chars, charIndex + 1)) {
                        return true;
                    }
                }
                return false;
            }
        }

        private static class TrieNode {
            private TrieNode[] children = new TrieNode[27];
            private boolean isWord;
        }
    }

    // exceed time limit
    private static class WordDictionary3 extends WordDictionary {
        private TrieNode root;

        public WordDictionary3() {
            root = new TrieNode();
        }

        @Override
        public void addWord(String word) {
            Queue<TrieNode> queue = new LinkedList<>();
            queue.offer(root);
            for (char c : word.toCharArray()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TrieNode node = queue.poll();
                    if (node.children[c - 'a'] == null) {
                        node.children[c - 'a'] = new TrieNode();
                    }
                    if (node.children[26] == null) {
                        node.children[26] = new TrieNode();
                    }
                    queue.offer(node.children[c - 'a']);
                    queue.offer(node.children[26]);
                }
            }
            while (!queue.isEmpty()) {
                TrieNode node = queue.poll();
                node.isWord = true;
            }
        }

        @Override
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (c == '.') {
                    node = node.children[26];
                } else {
                    node = node.children[c - 'a'];
                }
                if (node == null) {
                    return false;
                }
            }
            return node.isWord;
        }

        private static class TrieNode {
            private TrieNode[] children = new TrieNode[27];
            private boolean isWord;
        }
    }

    private static class WordDictionary4 extends WordDictionary {
        private String words = "#";

        @Override
        public void addWord(String word) {
            words += word + "#";
        }

        @Override
        public boolean search(String word) {
            return Pattern.matches(".*#" + word + "#.*", words);
        }
    }

    private static class WordDictionary5 extends WordDictionary {
        private Map<Integer, List<String>> words = new HashMap<>();

        @Override
        public void addWord(String word) {
            if (!words.containsKey(word.length())) {
                words.put(word.length(), new ArrayList<>());
            }
            words.get(word.length()).add(word);
        }

        @Override
        public boolean search(String word) {
            if (!words.containsKey(word.length())) {
                return false;
            }
            for (String w : words.get(word.length())) {
                if (isEquals(word, w)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isEquals(String w1, String w2) {
            for (int i = 0; i < w1.length(); i++) {
                if (w1.charAt(i) != '.' && w1.charAt(i) != w2.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
