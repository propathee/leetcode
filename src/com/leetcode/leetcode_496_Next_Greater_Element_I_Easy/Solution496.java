package com.leetcode.leetcode_496_Next_Greater_Element_I_Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

abstract class Solution496 {
    /**
     * All elements in nums1 and nums2 are unique.
     * The length of both nums1 and nums2 would not exceed 1000.
     */
    public abstract int[] nextGreaterElement(int[] nums1, int[] nums2);

    static Solution496 newSolution() {
        return new S1();
    }

    // the stack stores numbers that haven't find "nextGreater"
    // it can be observed that the numbers in stack are stored in descent order
    private static class S1 extends Solution496 {
        @Override
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>(nums2.length);
            Stack<Integer> stack = new Stack<>();
            for (int n : nums2) {
                while (!stack.isEmpty() && stack.peek() < n) {
                    map.put(stack.pop(), n);
                }
                stack.push(n);
            }
            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.getOrDefault(nums1[i], -1);
            }
            return res;
        }
    }
}
