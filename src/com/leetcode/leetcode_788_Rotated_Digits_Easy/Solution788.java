package com.leetcode.leetcode_788_Rotated_Digits_Easy;

abstract class Solution788 {
    public abstract int rotatedDigits(int N);

    static Solution788 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution788 {
        private static final int[] MARK = {1,1,2,0,0,2,2,0,1,2};

        @Override
        public int rotatedDigits(int N) {
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (isGood(i)) {
                    cnt++;
                }
            }
            return cnt;
        }

        private boolean isGood(int n) {
            int cnt = 0;
            for (;n > 0; n /= 10) {
                int digit = n % 10;
                if (MARK[digit] == 0) {
                    return false;
                } else if (MARK[digit] == 2) {
                    cnt++;
                }
            }
            return cnt > 0;
        }
    }

    private static class S2 extends Solution788 {
        private static final int[] MARK = {1,1,2,0,0,2,2,0,1,2};

        @Override
        public int rotatedDigits(int N) {
            int cnt = 0;
            char[] chars = String.valueOf(N).toCharArray();
            boolean anyGood = false;
            boolean anyBad = false;
            for (int i = 0; i < chars.length; i++) {
                int digit = chars[i] - '0';
                for (int j = 0; j < digit; j++) {
                    if (MARK[j] > 0) {
                        cnt += Math.pow(7, chars.length - i - 1);
                        if (!anyGood && MARK[j] == 1) {
                            cnt -= Math.pow(3, chars.length - i - 1);
                        }
                    }
                }
                if (MARK[digit] == 0) {
                    anyBad = true;
                    break;
                } else if (MARK[digit] == 2) {
                    anyGood = true;
                }
            }
            return cnt + (!anyBad && anyGood ? 1 : 0);
        }
    }

    private static class S3 extends Solution788 {
        private static final int[] MARK = {1,1,2,0,0,2,2,0,1,2};

        @Override
        public int rotatedDigits(int N) {
            int cnt = 0;
            int[] dp = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                if (i < 10) {
                    if (MARK[i] == 2) {
                        dp[i] = 2;
                        cnt++;
                    } else if (MARK[i] == 1) {
                        dp[i] = 1;
                    }
                } else {
                    int a = dp[i / 10], b = dp[i % 10];
                    if (a == 1 && b == 1) {
                        dp[i] = 1;
                    } else if (a >= 1 && b >= 1) {
                        dp[i] = 2;
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }
}
