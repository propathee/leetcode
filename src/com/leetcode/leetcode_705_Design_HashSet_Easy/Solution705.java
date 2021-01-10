package com.leetcode.leetcode_705_Design_HashSet_Easy;

import java.util.Arrays;

abstract class Solution705 {
    /**
     * All values will be in the range of [0, 1000000]
     */
    static abstract class MyHashSet {
        public MyHashSet() {
        }

        public abstract void add(int key);

        public abstract void remove(int key);

        public abstract boolean contains(int key);
    }

    static MyHashSet newSet() {
        return new MyHashSet2();
    }

    private static class MyHashSet1 extends MyHashSet {
        private boolean[] dict = new boolean[1000001];

        public MyHashSet1() {
        }

        @Override
        public void add(int key) {
            dict[key] = true;
        }

        @Override
        public void remove(int key) {
            dict[key] = false;
        }

        @Override
        public boolean contains(int key) {
            return dict[key];
        }
    }

    private static class MyHashSet2 extends MyHashSet {
        private boolean[] dict = new boolean[100];

        public MyHashSet2() {
        }

        @Override
        public void add(int key) {
            if (key >= dict.length) {
                extend(key);
            }
            dict[key] = true;
        }

        @Override
        public void remove(int key) {
            if (key < dict.length) {
                dict[key] = false;
            }
        }

        @Override
        public boolean contains(int key) {
            return key < dict.length && dict[key];
        }

        private void extend(int key) {
            int len = dict.length;
            while (len <= key) {
                len *= 2;
            }
            dict = Arrays.copyOf(dict, len);
        }
    }
}
