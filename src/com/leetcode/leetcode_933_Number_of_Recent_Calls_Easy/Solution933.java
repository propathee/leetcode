package com.leetcode.leetcode_933_Number_of_Recent_Calls_Easy;

import java.util.LinkedList;

abstract class Solution933 {

    static RecentCounter newCounter() {
        return new RecentCounter1();
    }

    abstract static class RecentCounter {
        public abstract int ping(int t);
    }

    private static class RecentCounter1 extends RecentCounter {
        private LinkedList<Integer> list;

        public RecentCounter1() {
            list = new LinkedList<>();
        }

        @Override
        public int ping(int t) {
            list.add(t);
            removeNumLessThan(t - 3000);
            return list.size();
        }

        private void removeNumLessThan(int min) {
            while (list.getFirst() < min) {
                list.removeFirst();
            }
        }
    }
}
