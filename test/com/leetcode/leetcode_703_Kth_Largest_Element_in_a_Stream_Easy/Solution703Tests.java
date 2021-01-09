package com.leetcode.leetcode_703_Kth_Largest_Element_in_a_Stream_Easy;

import com.leetcode.leetcode_703_Kth_Largest_Element_in_a_Stream_Easy.Solution703.KthLargest;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution703Tests {
    @Test
    public void should_pass_1() {
        int k = 3;
        int[] nums = new int[] {4,5,8,2};
        KthLargest obj = Solution703.newObj(k, nums);
        assertEquals(4, obj.add(3));
        assertEquals(5, obj.add(5));
        assertEquals(5, obj.add(10));
        assertEquals(8, obj.add(9));
        assertEquals(8, obj.add(4));
    }

    @Test
    public void should_pass_2() {
        int k = 2;
        int[] nums = new int[] {0};
        KthLargest obj = Solution703.newObj(k, nums);
        assertEquals(-1, obj.add(-1));
        assertEquals(0, obj.add(1));
        assertEquals(0, obj.add(-2));
        assertEquals(0, obj.add(-4));
        assertEquals(1, obj.add(3));
    }
}