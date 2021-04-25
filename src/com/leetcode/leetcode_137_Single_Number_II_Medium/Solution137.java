package com.leetcode.leetcode_137_Single_Number_II_Medium;

abstract class Solution137 {
    public abstract int singleNumber(int[] nums);

    static Solution137 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution137 {
        @Override
        public int singleNumber(int[] nums) {
            int x1 = 0, x2 = 0, mask = 0;
            for (int num : nums) {
                x2 ^= (x1 & num);
                x1 ^= num;
                mask = ~(x1 & x2);
                x2 &= mask;
                x1 &= mask;
            }
            return x1;
        }
    }

    private static class S2 extends Solution137 {
        @Override
        public int singleNumber(int[] nums) {
            int ones = 0, twice = 0;
            for (int num : nums) {
                ones = (ones ^ num) & ~twice;
                twice = (twice ^ num) & ~ones;
            }
            return ones;
        }
    }

    private static class S3 extends Solution137 {
        @Override
        public int singleNumber(int[] nums) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                int cnt = 0;
                for (int num : nums) {
                    if (((num >> i) & 1) == 1) {
                        cnt++;
                        if (cnt == 3) {
                            cnt = 0;
                        }
                    }
                }
                if (cnt != 0) {
                    ans |= (cnt << i);
                }
            }
            return ans;
        }
    }

    private static class S4 extends Solution137 {
        @Override
        public int singleNumber(int[] nums) {
            int a = 0, b = 0;
            for (int num : nums) {
                int tmp = (a&~b&~num) | (~a&b&num);
                b = (~a&b&~num) | (~a&~b&num);
                a = tmp;
            }
            return a | b;
        }
    }
}
