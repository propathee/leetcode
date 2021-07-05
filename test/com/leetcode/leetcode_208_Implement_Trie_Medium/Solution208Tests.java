package com.leetcode.leetcode_208_Implement_Trie_Medium;

import static org.junit.Assert.*;

import com.leetcode.leetcode_208_Implement_Trie_Medium.Solution208.Trie;
import org.junit.Test;

public class Solution208Tests {
    private Trie trie = Solution208.newTrie();

    @Test
    public void should_pass() {
        String[] methods = {"insert", "search", "search", "startsWith", "insert", "search"};
        String[] args = {"apple", "apple", "app", "app", "app", "app"};
        Boolean[] results = {null, true, false, true, null, true};
        assertPass(methods, args, results);
    }

    private void assertPass(String[] methods, String[] args, Boolean[] results) {
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].equals("insert")) {
                trie.insert(args[i]);
            } else if (methods[i].equals("search")) {
                assertEquals(results[i], trie.search(args[i]));
            } else {
                assertEquals(results[i], trie.startsWith(args[i]));
            }
        }
    }
}