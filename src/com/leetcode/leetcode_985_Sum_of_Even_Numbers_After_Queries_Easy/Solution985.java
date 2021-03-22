package com.leetcode.leetcode_985_Sum_of_Even_Numbers_After_Queries_Easy;

abstract class Solution985 {
    public abstract int[] sumEvenAfterQueries(int[] A, int[][] queries);

    static Solution985 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution985 {
        @Override
        public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
            int[] res = new int[queries.length];
            int sum = sumOfEvenNums(A);
            for (int i = 0; i < queries.length; i++) {
                int index = queries[i][1];
                if (A[index] % 2 == 0) {
                    sum -= A[index];
                }
                A[index] += queries[i][0];
                if (A[index] % 2 == 0) {
                    sum += A[index];
                }
                res[i] = sum;
            }
            return res;
        }

        private int sumOfEvenNums(int[] A) {
            int sum = 0;
            for (int num : A) {
                if (num % 2 == 0) {
                    sum += num;
                }
            }
            return sum;
        }
    }

    private static class S2 extends Solution985 {
        @Override
        public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
            int[] res = new int[queries.length];
            int sum = 0;
            for (int num : A) {
                sum += (num % 2 == 0 ? num : 0);
            }
            for (int i = 0; i < queries.length; i++) {
                int newValue = A[queries[i][1]] + queries[i][0];
                int oldValue = A[queries[i][1]];
                if (oldValue % 2 == 0) {
                    if (newValue % 2 == 0) {
                        sum += queries[i][0];
                    } else {
                        sum -= oldValue;
                    }
                } else {
                    if (newValue % 2 == 0) {
                        sum += newValue;
                    }
                }
                res[i] = sum;
                A[queries[i][1]] = newValue;
            }
            return res;
        }
    }
}
