package com.leetcode.leetcode_628_Maximum_Product_of_Three_Numbers_Easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

abstract class Solution628 {
    public abstract int maximumProduct(int[] nums);

    static Solution628 newSolution() {
        return new S7();
    }

    private static class S1 extends Solution628 {
        @Override
        public int maximumProduct(int[] nums) {
            if (nums.length == 3) {
                return nums[0] * nums[1] * nums[2];
            }
            Arrays.sort(nums);
            int n = nums.length - 1;
            int max = nums[n] * nums[n - 1] * nums[n - 2];
            max = Math.max(max, nums[n] * nums[n - 1] * nums[0]);
            max = Math.max(max, nums[n] * nums[0] * nums[1]);
            max = Math.max(max, nums[0] * nums[1] * nums[2]);
            return max;
        }
    }

    private static class S2 extends Solution628 {
        @Override
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length - 1;
            int max = nums[n] * nums[n - 1] * nums[n - 2];
            max = Math.max(max, nums[n] * nums[n - 1] * nums[0]);
            max = Math.max(max, nums[n] * nums[0] * nums[1]);
            max = Math.max(max, nums[0] * nums[1] * nums[2]);
            return max;
        }
    }

    private static class S3 extends Solution628 {
        @Override
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length - 1;
            return Math.max(nums[n] * nums[n - 1] * nums[n - 2], nums[0] * nums[1] * nums[n]);
        }
    }

    private static class S4 extends Solution628 {
        @Override
        public int maximumProduct(int[] nums) {
            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            for (int n : nums) {
                if (n > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = n;
                } else if (n > max2) {
                    max3 = max2;
                    max2 = n;
                } else if (n > max3) {
                    max3 = n;
                }
                if (n < min1) {
                    min2 = min1;
                    min1 = n;
                } else if (n < min2) {
                    min2 = n;
                }
            }
            return Math.max(max1 * max2 * max3, min1 * min2 * max1);
        }
    }

    private static class S5 extends Solution628 {
        @Override
        public int maximumProduct(int[] nums) {
            PriorityQueue<Integer> q1 = new PriorityQueue<>();
            PriorityQueue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());
            for (int n : nums) {
                q1.offer(n);
                q2.offer(n);
                if (q1.size() > 3) {
                    q1.poll();
                }
                if (q2.size() > 2) {
                    q2.poll();
                }
            }
            int res = q1.poll() * q1.poll() * q1.peek();
            return Math.max(res, q1.peek() * q2.poll() * q2.poll());
        }
    }

    private static class S6 extends Solution628 {
        @Override
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            if (nums[nums.length - 1] * nums[0] >= 0) {
                return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
            }
            int l = 0, r = nums.length - 1;
            int cnt = 3;
            int product = 1;
            while (cnt > 0) {
                if (cnt % 2 == 1) {
                    product *= nums[r--];
                    cnt--;
                } else {
                    if (nums[r] * nums[r - 1] > nums[l] * nums[l + 1]) {
                        product *= (nums[r--] * nums[r--]);
                    } else {
                        product *= (nums[l++] * nums[l++]);
                    }
                    cnt -= 2;
                }
            }
            return product;
        }
    }

    private static class S7 extends Solution628 {
        @Override
        public int maximumProduct(int[] nums) {
            int[][] dp = new int[2][4];
            dp[0][0] = 1;
            dp[1][0] = 1;
            for (int i = 1; i < 4; i ++) {
                dp[0][i] = Integer.MIN_VALUE;
                dp[1][i] = Integer.MAX_VALUE;
            }
            for (int n : nums) {
                for (int j = 3; j > 0; j--) {
                    if (dp[0][j - 1] == Integer.MIN_VALUE) {
                        continue;
                    }
                    dp[0][j] = Math.max(dp[0][j], Math.max(dp[0][j - 1] * n, dp[1][j - 1] * n));
                    dp[1][j] = Math.min(dp[1][j], Math.min(dp[0][j - 1] * n, dp[1][j - 1] * n));
                }
            }
            return dp[0][3];
        }
    }
}
