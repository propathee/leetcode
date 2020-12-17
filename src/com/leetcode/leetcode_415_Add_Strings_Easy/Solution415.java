package com.leetcode.leetcode_415_Add_Strings_Easy;

public abstract class Solution415 {
    /**
     * Given two non-negative integers num1 and num2 represented as string,
     * return the sum of num1 and num2.
     * <ul>
     * <li>The length of both num1 and num2 is < 5100.</li>
     * <li>Both num1 and num2 contains only digits 0-9.</li>
     * <li>Both num1 and num2 does not contain any leading zero.</li>
     * <li>You must not use any built-in BigInteger library or convert the inputs to integer directly.</li>
     * </ul>
     */
    public abstract String addStrings(String num1, String num2);

    static Solution415 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution415 {
        @Override
        public String addStrings(String num1, String num2) {
            StringBuilder sBuilder = new StringBuilder();
            boolean plusOne = false;
            for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
                int sum = 0;
                if (i >= 0) {
                    sum += Integer.parseInt(String.valueOf(num1.charAt(i)));
                }
                if (j >= 0) {
                    sum += Integer.parseInt(String.valueOf(num2.charAt(j)));
                }
                if (plusOne) {
                    sum++;
                }
                if (sum >= 10) {
                    plusOne = true;
                    sBuilder.append(sum - 10);
                } else {
                    plusOne = false;
                    sBuilder.append(sum);
                }
            }
            if (plusOne) {
                sBuilder.append("1");
            }
            return sBuilder.reverse().toString();
        }
    }

    private static class S2 extends Solution415 {
        @Override
        public String addStrings(String num1, String num2) {
            StringBuilder sBuilder = new StringBuilder();
            int carry = 0;
            for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--) {
                int x = i >= 0 ? num1.charAt(i) - '0' : 0;
                int y = j >= 0 ? num2.charAt(j) - '0' : 0;
                sBuilder.append((x + y + carry) % 10);
                carry = (x + y + carry) / 10;
            }
            return sBuilder.reverse().toString();
        }
    }
}
