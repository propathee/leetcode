package com.leetcode.leetcode_720_Longest_Word_in_Dictionary_Easy;

import java.util.*;

abstract class Solution720 {
    public abstract String longestWord(String[] words);

    static Solution720 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution720 {
        @Override
        public String longestWord(String[] words) {
            Set<String> set = new HashSet<>();
            for (String w : words) {
                set.add(w);
            }
            int maxLen = 1;
            List<String> candidates = new ArrayList<>();
            for (String w : words) {
                if (w.length() >= maxLen) {
                    boolean flag = true;
                    for (int i = 1; i < w.length(); i++) {
                        if (!set.contains(w.substring(0, i))) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        if (w.length() > maxLen) {
                            candidates.clear();
                        }
                        candidates.add(w);
                        maxLen = w.length();
                    }
                }
            }
            if (candidates.isEmpty()) {
                return "";
            } else if (candidates.size() == 1) {
                return candidates.get(0);
            } else {
                Collections.sort(candidates);
                return candidates.get(0);
            }
        }
    }

    private static class S2 extends Solution720 {
        @Override
        public String longestWord(String[] words) {
            Arrays.sort(words);
            Set<String> set = new HashSet<>();
            for (String w : words) {
                set.add(w);
            }
            String winner = "";
            for (String w : words) {
                if (w.length() > winner.length()) {
                    boolean flag = true;
                    for (int i = 1; i < w.length(); i++) {
                        if (!set.contains(w.substring(0, i))) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        winner = w;
                    }
                }
            }
            return winner;
        }
    }

    private static class S3 extends Solution720 {
        @Override
        public String longestWord(String[] words) {
            Arrays.sort(words);
            Set<String> set = new HashSet<>();
            for (String w : words) {
                set.add(w);
            }
            String winner = "";
            Set<String> candidates = new HashSet<>();
            candidates.add("");
            for (String w : words) {
                if (candidates.contains(w.substring(0, w.length() - 1))) {
                    candidates.add(w);
                    if (w.length() > winner.length()) {
                        winner = w;
                    }
                }
            }
            return winner;
        }
    }

    private static class S4 extends Solution720 {
        @Override
        public String longestWord(String[] words) {
            TrieNode root = new TrieNode();
            root.word = "";
            for (String w : words) {
                insert(root, w);
            }
            return dfs(root, "");
        }

        private void insert(TrieNode root, String word) {
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int i = c - 'a';
                if (root.children[i] == null) {
                    root.children[i] = new TrieNode();
                }
                root = root.children[i];
            }
            root.word = word;
        }

        private String dfs(TrieNode root, String winner) {
            String res = getWinner(root.word, winner);
            for (TrieNode node : root.children) {
                if (node != null && node.word != null) {
                    res = dfs(node, res);
                }
            }
            return res;
        }

        private String getWinner(String w1, String w2) {
            if (w1.length() > w2.length()) {
                return w1;
            } else if (w1.length() < w2.length()) {
                return w2;
            } else {
                return w1.compareTo(w2) < 0 ? w1 : w2;
            }
        }

        private static class TrieNode {
            private String word;
            private TrieNode[] children = new TrieNode[26];
        }
    }

    private static class S5 extends Solution720 {
        @Override
        public String longestWord(String[] words) {
            TrieNode root = new TrieNode();
            root.word = "";
            for (String w : words) {
                insert(root, w);
            }
            return bfs(root);
        }

        private void insert(TrieNode root, String word) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int j = chars[i] - 'a';
                if (root.children[j] == null) {
                    root.children[j] = new TrieNode();
                }
                root = root.children[j];
            }
            root.word = word;
        }

        private String bfs(TrieNode root) {
            String winner = "";
            Queue<TrieNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TrieNode node = q.poll();
                    winner = node.word;
                    for (int j = 25; j >= 0; j--) {
                        if (node.children[j] != null && node.children[j].word != null) {
                            q.offer(node.children[j]);
                        }
                    }
                }
            }
            return winner;
        }

        private static class TrieNode {
            private String word;
            private TrieNode[] children = new TrieNode[26];
        }
    }

    private static class S6 extends Solution720 {
        private String winner = "";

        @Override
        public String longestWord(String[] words) {
            TrieNode root = new TrieNode();
            Arrays.sort(words);
            for (String w : words) {
                insert(root, w);
            }
            return winner;
        }

        private void insert(TrieNode root, String word) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int j = chars[i] - 'a';
                if (root.children[j] != null) {
                    root = root.children[j];
                } else {
                    if (i < chars.length - 1) {
                        return;
                    }
                    root.children[j] = new TrieNode();
                    root = root.children[j];
                    if (word.length() > winner.length()) {
                        winner = word;
                    }
                }
            }
        }

        private static class TrieNode {
            private TrieNode[] children = new TrieNode[26];
        }
    }
}
