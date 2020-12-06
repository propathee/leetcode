package com.leetcode.leetcode_368_largest_divisible_subset_Med;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] count = new int[n];
        int[] pre = new int[n];
        int max = 0;
        int index = -1;

        for (int i = 0; i < n; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (count[j] + 1 > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }
            if (count[i] > max) {
                max = count[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while (index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }

    public List<Integer> largestDivisibleSubset_1(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<Integer>();
        Arrays.sort(nums);
        ArrayList<Integer>[] dp = (ArrayList<Integer>[]) new ArrayList[nums.length];
        int maxSize;
        int maxIndex;
        int finalSize = 0;
        int finalIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            maxSize = 0;
            maxIndex = 0;
            dp[i] = new ArrayList<>();
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j].size() > maxSize) {
                        maxSize = dp[j].size();
                        maxIndex = j;
                    }
                }
            }
            if (maxSize != 0)
                dp[i].addAll(dp[maxIndex]);
            dp[i].add(nums[i]);
            if (dp[i].size() > finalSize) {
                finalSize = dp[i].size();
                finalIndex = i;
            }
        }
        return dp[finalIndex];
    }
}