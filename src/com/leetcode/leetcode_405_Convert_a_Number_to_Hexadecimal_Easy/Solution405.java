package com.leetcode.leetcode_405_Convert_a_Number_to_Hexadecimal_Easy;

public abstract class Solution405 {
    /**
     * Given an integer, write an algorithm to convert it to hexadecimal.
     * For negative integer, two’s complement method is used.
     * @param num The given number is guaranteed to fit within the range of a 32-bit signed integer.
     * @return All letters in hexadecimal (a-f) must be in lowercase.
     */
    public abstract String toHex(int num);

    static Solution405 newSolution() {
        return new S2();
    }

    private static final String[] DICT = new String[] {
        "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
        "a", "b", "c", "d", "e", "f"};

    private static class S1 extends Solution405 {
        @Override
        public String toHex(int num) {
            StringBuilder sBuilder = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                sBuilder.append(DICT[num & 15]);
                num >>>= 4; // num >>= 4 is allowed.
                if (num == 0) {
                    break;
                }
            }
            return sBuilder.reverse().toString();
        }
    }

    private static class S2 extends Solution405 {
        @Override
        public String toHex(int num) {
            StringBuilder sBuilder = new StringBuilder();
            do {
                sBuilder.append(DICT[num & 15]);
                num >>>= 4; // num >>= 4 is wrong!
            } while (num != 0);
            return sBuilder.reverse().toString();
        }
    }
}
