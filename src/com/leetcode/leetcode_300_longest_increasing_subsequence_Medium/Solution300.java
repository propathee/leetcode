package com.leetcode.leetcode_300_longest_increasing_subsequence_Medium;

abstract class Solution300 {
    public abstract int lengthOfLIS(int[] nums);

    static Solution300 newSolution() {
        return new S6();
    }

    private static class S1 extends Solution300 {
        @Override
        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            int max = 0;
            for (int len : dp) {
                max = Math.max(max, len);
            }
            return max;
        }
    }

    private static class S2 extends Solution300 {
        @Override
        public int lengthOfLIS(int[] nums) {
            int[] tails = new int[nums.length];
            int maxLen = 0;
            for (int num : nums) {
                if (maxLen == 0 || num > tails[maxLen - 1]) {
                    tails[maxLen] = num;
                    maxLen++;
                } else {
                    for (int j = 0; j < maxLen; j++) {
                        if (num <= tails[j]) {
                            tails[j] = num;
                            break;
                        }
                    }
                }
            }
            return maxLen;
        }
    }

    private static class S3 extends Solution300 {
        @Override
        public int lengthOfLIS(int[] nums) {
            int[] tails = new int[nums.length];
            int maxLen = 0;
            for (int num : nums) {
                int j = 0;
                for (; j < maxLen; j++) {
                    if (num <= tails[j]) {
                        tails[j] = num;
                        break;
                    }
                }
                if (j == maxLen) {
                    tails[maxLen] = num;
                    maxLen++;
                }
            }
            return maxLen;
        }
    }

    private static class S4 extends Solution300 {
        @Override
        public int lengthOfLIS(int[] nums) {
            int[] tails = new int[nums.length];
            int maxLen = 0;
            for (int num : nums) {
                int l = 0, r = maxLen - 1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (tails[mid] < num) {
                        l = mid + 1;
                    } else if (tails[mid] > num) {
                        r = mid - 1;
                    } else {
                        l = mid;
                        break;
                    }
                }
                tails[l] = num;
                if (l == maxLen) {
                    maxLen++;
                }
            }
            return maxLen;
        }
    }

    private static class S5 extends Solution300 {
        @Override
        public int lengthOfLIS(int[] nums) {
            int[] tails = new int[nums.length];
            int maxLen = 0;
            for (int num : nums) {
                int l = 0, r = maxLen - 1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (tails[mid] < num) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                tails[l] = num;
                if (l == maxLen) {
                    maxLen++;
                }
            }
            return maxLen;
        }
    }

    private static class S6 extends Solution300 {
        @Override
        public int lengthOfLIS(int[] nums) {
            int[] tails = new int[nums.length];
            int maxLen = 0;
            for (int num : nums) {
                int l = 0, r = maxLen;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (tails[mid] < num) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                tails[l] = num;
                if (l == maxLen) {
                    maxLen++;
                }
            }
            return maxLen;
        }
    }
}
