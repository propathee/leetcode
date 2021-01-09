package com.leetcode.leetcode_703_Kth_Largest_Element_in_a_Stream_Easy;

import java.util.PriorityQueue;

abstract class Solution703 {
    static abstract class KthLargest {
        public abstract int add(int val);
    }

    static KthLargest newObj(int k, int[] nums) {
        return new KthLargest4(k, nums);
    }

    private static class KthLargest1 extends KthLargest {
        private PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        private int k;

        public KthLargest1(int k, int[] nums) {
            this.k = k;
            for (int n : nums) {
                add(n);
            }
        }

        @Override
        public int add(int val) {
            pQueue.offer(val);
            if (pQueue.size() > k) {
                pQueue.poll();
            }
            return pQueue.peek();
        }
    }

    private static class KthLargest2 extends KthLargest {
        private PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        private int k;

        public KthLargest2(int k, int[] nums) {
            this.k = k;
            for (int n : nums) {
                add(n);
            }
        }

        @Override
        public int add(int val) {
            if (pQueue.size() < k) {
                pQueue.offer(val);
            } else {
                if (val > pQueue.peek()) {
                    pQueue.poll();
                    pQueue.offer(val);
                }
            }
            return pQueue.peek();
        }
    }

    private static class KthLargest3 extends KthLargest {
        private int tail;
        private int[] array;

        public KthLargest3(int k, int[] nums) {
            tail = k - 1;
            array = new int[k];
            for (int i = 0; i < k; i++) {
                array[i] = Integer.MIN_VALUE;
            }
            for (int n : nums) {
                add(n);
            }
        }

        @Override
        public int add(int val) {
            if (val > array[tail]) {
                int i = findInsertPos(val);
                System.arraycopy(array, i, array, i + 1, tail - i);
                array[i] = val;
            }
            return array[tail];
        }

        private int findInsertPos(int val) {
            int l = 0, r = tail;
            while (l < r) {
                int m = (l + r) / 2;
                if (array[m] == val) {
                    return m;
                } else if (array[m] > val) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            return array[l] <= val ? l : l + 1;
        }
    }

    private static class KthLargest4 extends KthLargest {
        private int tail;
        private int[] array;
        private int cursor;

        public KthLargest4(int k, int[] nums) {
            tail = k - 1;
            array = new int[k];
            array[0] = Integer.MIN_VALUE;
            for (int n : nums) {
                add(n);
            }
        }

        @Override
        public int add(int val) {
            if (val > array[cursor]) {
                int i = findInsertPos(val, cursor);
                if (cursor < tail) {
                    System.arraycopy(array, i, array, i + 1, ++cursor - i);
                } else {
                    System.arraycopy(array, i, array, i + 1, tail - i);
                }
                array[i] = val;
            } else if (cursor < tail) {
                array[++cursor] = val;
            }
            return array[cursor];
        }

        private int findInsertPos(int val, int r) {
            int l = 0;
            while (l < r) {
                int m = (l + r) / 2;
                if (array[m] == val) {
                    return m;
                } else if (array[m] > val) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            return array[l] <= val ? l : l + 1;
        }
    }
}
