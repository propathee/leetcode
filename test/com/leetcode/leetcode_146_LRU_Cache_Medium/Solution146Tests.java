package com.leetcode.leetcode_146_LRU_Cache_Medium;

import static org.junit.Assert.*;

import com.leetcode.leetcode_146_LRU_Cache_Medium.Solution146.LRUCache;
import org.junit.Test;

import java.util.Arrays;

public class Solution146Tests {

    @Test
    public void should_pass_1() {
        LRUCache cache = Solution146.newCache(2);
        String[] ops = {"put", "put", "get", "put", "get", "put", "get", "get", "get"};
        int[][] keyValues = {{1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}};
        Integer[] results = {null, null, 1, null, -1, null, -1, 3, 4};
        for (int i = 0; i < ops.length; i++) {
            operateThenAssertGet(cache, ops[i], keyValues[i], results[i]);
        }
    }

    @Test
    public void should_pass_2() {
        LRUCache cache = Solution146.newCache(2);
        String[] ops = {"put","put","put","put","get","get"};
        int[][] keyValues = {{2,1},{1,1},{2,3},{4,1},{1},{2}};
        Integer[] results = {null,null,null,null,-1,3};
        for (int i = 0; i < ops.length; i++) {
            operateThenAssertGet(cache, ops[i], keyValues[i], results[i]);
        }
    }

    private void operateThenAssertGet(LRUCache cache, String op, int[] keyValue, Integer result) {
        System.out.format("%s %s %d\n", op, Arrays.toString(keyValue), result);
        if ("put".equals(op)) {
            cache.put(keyValue[0], keyValue[1]);
        } else {
            assertEquals((int) result, cache.get(keyValue[0]));
        }
    }
}