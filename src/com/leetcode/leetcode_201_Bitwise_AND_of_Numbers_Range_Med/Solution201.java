package com.leetcode.leetcode_201_Bitwise_AND_of_Numbers_Range_Med;

abstract class Solution201 {
    public abstract int rangeBitwiseAnd(int left, int right);

    static Solution201 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution201 {
        @Override
        public int rangeBitwiseAnd(int left, int right) {
            int bitLen = computeBitLength(right);
            int commonLen = 0;
            for (int maskLen = bitLen - 1; maskLen >= 0; maskLen--) {
                int l = left >>> maskLen, r = right >>> maskLen;
                if (l == r) {
                    commonLen++;
                } else {
                    break;
                }
            }
            int maskLen = bitLen - commonLen;
            return right >> maskLen << maskLen;
        }

        private int computeBitLength(int num) {
            int len = 0;
            while (num != 0) {
                num >>>= 1;
                len++;
            }
            return len;
        }
    }

    private static class S2 extends Solution201 {
        @Override
        public int rangeBitwiseAnd(int left, int right) {
            int bitLen = computeBitLength(right);
            int maskLen;
            for (maskLen = bitLen - 1; maskLen >= 0; maskLen--) {
                int l = left >>> maskLen, r = right >>> maskLen;
                if (l != r) {
                    break;
                }
            }
            maskLen++;
            return right >> maskLen << maskLen;
        }

        private int computeBitLength(int num) {
            int len = 0;
            while (num != 0) {
                num >>>= 1;
                len++;
            }
            return len;
        }
    }

    private static class S3 extends Solution201 {
        @Override
        public int rangeBitwiseAnd(int left, int right) {
            int maskLen = 0;
            while (left != right) {
                left >>>= 1;
                right >>>= 1;
                maskLen++;
            }
            return left << maskLen;
        }
    }

    private static class S4 extends Solution201 {
        @Override
        public int rangeBitwiseAnd(int left, int right) {
            return left < right ? (rangeBitwiseAnd(left >> 1, right >> 1) << 1) : left;
        }
    }

    private static class S5 extends Solution201 {
        @Override
        public int rangeBitwiseAnd(int left, int right) {
            while (left < right) {
                right &= (right - 1);
            }
            return right;
        }
    }
}
