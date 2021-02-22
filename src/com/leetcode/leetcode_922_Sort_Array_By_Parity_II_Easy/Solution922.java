package com.leetcode.leetcode_922_Sort_Array_By_Parity_II_Easy;

abstract class Solution922 {
    public abstract int[] sortArrayByParityII(int[] A);

    static Solution922 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution922 {
        @Override
        public int[] sortArrayByParityII(int[] A) {
            int[] res = new int[A.length];
            int evenIndex = 0, oddIndex = 1;
            for (int num : A) {
                if (num % 2 == 0) {
                    res[evenIndex] = num;
                    evenIndex += 2;
                } else {
                    res[oddIndex] = num;
                    oddIndex += 2;
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution922 {
        @Override
        public int[] sortArrayByParityII(int[] A) {
            for (int i = 0, oddIdx = A.length - 1, evenIdx = A.length - 2; i < A.length;) {
                if (i % 2 == 0) {
                    if (A[i] % 2 == 0) {
                        i++;
                    } else {
                        swap(A, i, oddIdx);
                        oddIdx -= 2;
                    }
                } else {
                    if (A[i] % 2 != 0) {
                        i++;
                    } else {
                        swap(A, i, evenIdx);
                        evenIdx -= 2;
                    }
                }
            }
            return A;
        }

        private void swap(int[] array, int i, int j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    private static class S3 extends Solution922 {
        @Override
        public int[] sortArrayByParityII(int[] A) {
            for (int evenIdx = 0, oddIdx = A.length - 1; evenIdx < A.length && oddIdx > 0;) {
                if (A[evenIdx] % 2 == 0) {
                    evenIdx += 2;
                } else {
                    swap(A, evenIdx, oddIdx);
                    oddIdx -= 2;
                }
            }
            return A;
        }

        private void swap(int[] array, int i, int j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    private static class S4 extends Solution922 {
        @Override
        public int[] sortArrayByParityII(int[] A) {
            for (int evenIdx = 0, oddIdx = 1; evenIdx < A.length && oddIdx < A.length;) {
                if (A[evenIdx] % 2 == 0) {
                    evenIdx += 2;
                } else {
                    swap(A, evenIdx, oddIdx);
                    oddIdx += 2;
                }
            }
            return A;
        }

        private void swap(int[] array, int i, int j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    private static class S5 extends Solution922 {
        @Override
        public int[] sortArrayByParityII(int[] A) {
            for (int evenIdx = 0, oddIdx = 1; evenIdx < A.length && oddIdx < A.length;) {
                if (A[evenIdx] % 2 == 0) {
                    evenIdx += 2;
                } else if (A[oddIdx] % 2 != 0) {
                    oddIdx += 2;
                } else {
                    swap(A, evenIdx, oddIdx);
                    evenIdx += 2;
                    oddIdx += 2;
                }
            }
            return A;
        }

        private void swap(int[] array, int i, int j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }
}
