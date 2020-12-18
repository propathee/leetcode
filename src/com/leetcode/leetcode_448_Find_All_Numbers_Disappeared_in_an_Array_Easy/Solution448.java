package com.leetcode.leetcode_448_Find_All_Numbers_Disappeared_in_an_Array_Easy;

import java.util.ArrayList;
import java.util.List;

public abstract class Solution448 {
    /**
     * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
     * some elements appear twice and others appear once.
     * <p>
     * Find all the elements of [1, n] inclusive that do not appear in this array.
     * <p>
     * Could you do it without extra space and in O(n) runtime?
     * You may assume the returned list does not count as extra space.
     */
    public abstract List<Integer> findDisappearedNumbers(int[] nums);

    static Solution448 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution448 {
        @Override
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int idx = Math.abs(nums[i]) - 1;
                if (nums[idx] > 0) {
                    nums[idx] = -nums[idx];
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    res.add(i + 1);
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution448 {
        @Override
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                    int tmp = nums[i];
                    nums[i] = nums[tmp - 1];
                    nums[tmp - 1] = tmp;
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) {
                    res.add(i + 1);
                }
            }
            return res;
        }
    }
}
