package com.leetcode.leetcode_705_Design_HashSet_Easy;

import com.leetcode.leetcode_705_Design_HashSet_Easy.Solution705.MyHashSet;
import org.junit.Test;

import static org.junit.Assert.*;

public class Solution705Tests {
    private MyHashSet set = Solution705.newSet();

    @Test
    public void should_pass_1() {
        set.add(1);
        set.add(2);
        assertTrue(set.contains(1));
        assertFalse(set.contains(3));
        set.add(2);
        assertTrue(set.contains(2));
        set.remove(2);
        assertFalse(set.contains(2));
    }
}