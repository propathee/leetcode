package com.leetcode.leetcode_504_Base_7_Easy;

abstract class Solution504 {
    public abstract String convertToBase7(int num);

    static Solution504 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution504 {
        @Override
        public String convertToBase7(int num) {
            StringBuilder sBuilder = new StringBuilder();
            while (num >= 7) {
                sBuilder.append(Math.abs(num % 7));
                num /= 7;
            }
            return sBuilder.reverse().insert(0, num).toString();
        }
    }

    private static class S2 extends Solution504 {
        @Override
        public String convertToBase7(int num) {
            StringBuilder sBuilder = new StringBuilder();
            boolean isNegative = num < 0;
            num = Math.abs(num);
            while (num >= 7) {
                sBuilder.append(num % 7);
                num /= 7;
            }
            sBuilder.append(num);
            sBuilder.append(isNegative ? "-" : "");
            return sBuilder.reverse().toString();
        }
    }

    private static class S3 extends Solution504 {
        @Override
        public String convertToBase7(int num) {
            if (num < 0) {
                return "-" + convertToBase7(-num);
            }
            if (num < 7) {
                return String.valueOf(num);
            }
            return convertToBase7(num / 7) + num % 7;
        }
    }

    private static class S4 extends Solution504 {
        @Override
        public String convertToBase7(int num) {
            int res = 0;
            int base = 1;
            int flag = num < 0 ? -1 : 1;
            int n = Math.abs(num);
            while (n > 0) {
                res += (n % 7) * base;
                n /= 7;
                base *= 10;
            }
            return String.valueOf(res * flag);
        }
    }
}
