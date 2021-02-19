package com.leetcode.leetcode_905_Sort_Array_By_Parity_Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

abstract class Solution905 {
    public abstract int[] sortArrayByParity(int[] A);

    static Solution905 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution905 {
        @Override
        public int[] sortArrayByParity(int[] A) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int num : A) {
                if (num % 2 == 0) {
                    list.addFirst(num);
                } else {
                    list.addLast(num);
                }
            }
            int[] res = new int[list.size()];
            int index = 0;
            for (int num : list) {
                res[index++] = num;
            }
            return res;
        }
    }

    private static class S2 extends Solution905 {
        @Override
        public int[] sortArrayByParity(int[] A) {
            List<Integer> list = new ArrayList<>();
            for (int num : A) {
                if (num % 2 == 0) {
                    list.add(0, num);
                } else {
                    list.add(num);
                }
            }
            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

    private static class S3 extends Solution905 {
        @Override
        public int[] sortArrayByParity(int[] A) {
            int[] res = new int[A.length];
            int p = 0, q = A.length - 1;
            for (int num : A) {
                if (num % 2 == 0) {
                    res[p++] = num;
                } else {
                    res[q--] = num;
                }
            }
            return res;
        }
    }

    private static class S4 extends Solution905 {
        @Override
        public int[] sortArrayByParity(int[] A) {
            int p = 0, q = A.length - 1;
            while (p < q) {
                if (A[p] % 2 == 0) {
                    p++;
                } else {
                    int tmp = A[q];
                    A[q] = A[p];
                    A[p] = tmp;
                    q--;
                }
            }
            return A;
        }
    }

    // there's no even number between p and p
    private static class S5 extends Solution905 {
        @Override
        public int[] sortArrayByParity(int[] A) {
            for (int p = 0, q = 0; q < A.length; q++) {
                if (A[q] % 2 == 0) {
                    int tmp = A[p];
                    A[p++] = A[q];
                    A[q] = tmp;
                }
            }
            return A;
        }
    }
}
