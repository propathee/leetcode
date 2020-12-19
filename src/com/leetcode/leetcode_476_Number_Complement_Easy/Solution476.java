package com.leetcode.leetcode_476_Number_Complement_Easy;

abstract class Solution476 {
    /**
     * Given a positive integer num, output its complement number.
     * The complement strategy is to flip the bits of its binary representation.
     */
    public abstract int findComplement(int num);

    static Solution476 newSolution() {
        return new S7();
    }

    private static class S1 extends Solution476 {
        @Override
        public int findComplement(int num) {
            int shifts = 0;
            while (num > 0) {
                shifts++;
                num <<= 1;
            }
            num = ~num; // or num ^= -1
            num >>>= shifts; // num >>= shifts is wrong
            return num;
        }
    }

    private static class S2 extends Solution476 {
        @Override
        public int findComplement(int num) {
            int mask = -1;
            while ((mask & num) > 0) {
                mask <<= 1;
            }
            return ~mask & ~num;
        }
    }

    private static class S3 extends Solution476 {
        @Override
        public int findComplement(int num) {
            return (Integer.highestOneBit(num) - 1) & ~num;
        }
    }

    private static class S4 extends Solution476 {
        @Override
        public int findComplement(int num) {
            int higherOneBit = 1;
            while (higherOneBit <= num) {
                higherOneBit <<= 1;
            }
            return (higherOneBit - 1) & ~num;
        }
    }

    private static class S5 extends Solution476 {
        @Override
        public int findComplement(int num) {
            int sum = 0;
            int level = 0;
            while (sum < num) {
                sum += Math.pow(2, level++);
            }
            return sum - num;
        }
    }

    // bit by bit reverse
    private static class S6 extends Solution476 {
        @Override
        public int findComplement(int num) {
            for (int mask = 1; mask <= num && mask > 0; mask <<= 1) {
                num ^= mask;
            }
            return num;
        }
    }

    // Spread the highest 1-bit onto all the lower bits. Then xor with that.
    private static class S7 extends Solution476 {
        @Override
        public int findComplement(int num) {
            int mask = num;
            mask |= mask >>= 1;
            mask |= mask >>= 2;
            mask |= mask >>= 4;
            mask |= mask >>= 8;
            mask |= mask >>= 16;
            return mask ^ num;
        }
    }
}
