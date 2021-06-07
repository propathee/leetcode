package com.leetcode.leetcode_173_Binary_Search_Tree_Iterator_Medium;

import com.leetcode.leetcode_173_Binary_Search_Tree_Iterator_Medium.Solution173.BSTIterator;
import com.leetcode.utils.TreeNode;
import org.junit.Test;

import static com.leetcode.utils.TreeTests.makeTree;
import static org.junit.Assert.*;

public class Solution173Tests {
    @Test
    public void should_pass_1() {
        TreeNode root = makeTree(7, 3, 15, null, null, 9, 20);
        BSTIterator iter = Solution173.iterator(root);
        assertEquals(3, iter.next());
        assertEquals(7, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(9, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(15, iter.next());
        assertTrue(iter.hasNext());
        assertEquals(20, iter.next());
        assertFalse(iter.hasNext());
    }
}