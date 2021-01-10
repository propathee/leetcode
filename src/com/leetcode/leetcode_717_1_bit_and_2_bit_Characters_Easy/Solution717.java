package com.leetcode.leetcode_717_1_bit_and_2_bit_Characters_Easy;

abstract class Solution717 {
    public abstract boolean isOneBitCharacter(int[] bits);

    static Solution717 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution717 {
        @Override
        public boolean isOneBitCharacter(int[] bits) {
            int increment = 0;
            for (int i = 0; i < bits.length; i += increment) {
                increment = bits[i] == 0 ? 1 : 2;
            }
            return increment == 1;
        }
    }

    private static class S2 extends Solution717 {
        @Override
        public boolean isOneBitCharacter(int[] bits) {
            return helper(bits, bits.length - 2);
        }

        private boolean helper(int[] bits, int i) {
            return i < 0 || bits[i] == 0 || !helper(bits, i - 1);
        }
    }

    private static class S3 extends Solution717 {
        @Override
        public boolean isOneBitCharacter(int[] bits) {
            int i = 0;
            while (i < bits.length - 1) {
                i += (bits[i] == 0 ? 1 : 2);
            }
            return i == bits.length - 1;
        }
    }

    private static class S4 extends Solution717 {
        @Override
        public boolean isOneBitCharacter(int[] bits) {
            int ones = 0;
            for (int i = bits.length - 2; i >= 0 && bits[i] != 0; i--) {
                ones++;
            }
            return ones % 2 == 0;
        }
    }

    private static class S5 extends Solution717 {
        @Override
        public boolean isOneBitCharacter(int[] bits) {
            boolean res = true;
            for (int i = bits.length - 2; i >= 0 && bits[i] != 0; i--) {
                res = !res;
            }
            return res;
        }
    }
}
