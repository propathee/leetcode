package com.leetcode.leetcode_643_Maximum_Average_Subarray_I_Easy;

abstract class Solution643 {
    public abstract double findMaxAverage(int[] nums, int k);

    static Solution643 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution643 {
        @Override
        public double findMaxAverage(int[] nums, int k) {
            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            double res = (double) sum / k;
            for (int i = 0, j = k; j < nums.length; i++, j++) {
                sum = sum + nums[j] - nums[i];
                res = Math.max(res, (double) sum / k);
            }
            return res;
        }
    }

    private static class S2 extends Solution643 {
        @Override
        public double findMaxAverage(int[] nums, int k) {
            long sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            long max = sum;
            for (int i = 0, j = k; j < nums.length; i++, j++) {
                sum = sum + nums[j] - nums[i];
                max = Math.max(max, sum);
            }
            return (double) max / k;
        }
    }

    private static class S3 extends Solution643 {
        @Override
        public double findMaxAverage(int[] nums, int k) {
            long sum = 0, max = Long.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (i < k) {
                    sum += nums[i];
                } else {
                    max = Math.max(max, sum);
                    sum = sum + nums[i] - nums[i - k];
                }
            }
            max = Math.max(max, sum);
            return (double) max / k;
        }
    }

    private static class S4 extends Solution643 {
        @Override
        public double findMaxAverage(int[] nums, int k) {
            long sum = 0, max = Long.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (i >= k) {
                    sum -= nums[i - k];
                }
                if ( i >= k - 1) {
                    max = Math.max(max, sum);
                }
            }
            return (double) max / k;
        }
    }
}
