package com.leetcode.leetcode_4_Median_of_Two_Sorted_Arrays_Hard;

abstract class Solution4 {
    public abstract double findMedianSortedArrays(int[] nums1, int[] nums2);

    static Solution4 newSolution() {
        return new S7();
    }

    private static class S1 extends Solution4 {
        @Override
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int mid = (nums1.length + nums2.length) / 2;
            int[] nums = new int[nums1.length + nums2.length];
            for (int i = 0, j = 0, k = 0; k <= mid; k++) {
                if (i >= nums1.length) {
                    nums[i + j] = nums2[j++];
                } else if (j >= nums2.length) {
                    nums[i + j] = nums1[i++];
                } else {
                    if (nums1[i] < nums2[j]) {
                        nums[i + j] = nums1[i++];
                    } else {
                        nums[i + j] = nums2[j++];
                    }
                }
            }
            if (nums.length % 2 == 0) {
                return (nums[mid - 1] + nums[mid]) / 2.;
            } else {
                return nums[mid];
            }
        }
    }

    private static class S2 extends Solution4 {
        @Override
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int low = 0, high = m - 1;
            while (low <= high) {
                int i = low + (high - low) / 2;
                int j = (m + n) / 2 - i;
                // it is impossible for i < 0 or i >= m
                if (j > n || (j > 0 && nums2[j - 1] > nums1[i])) {
                    low = i + 1;
                } else {
                    high = i - 1;
                }
            }
            int i = low, j = (m + n - 2 * i) / 2;
            if ((m + n) % 2 == 0) {
                return (maxOfLeftPart(nums1, i - 1, nums2, j - 1) + minOfRightPart(nums1, i, nums2, j)) / 2.;
            } else {
                return minOfRightPart(nums1, i, nums2, j);
            }
        }

        private int maxOfLeftPart(int[] nums1, int i1, int[] nums2, int i2) {
            if (i1 < 0) {
                return nums2[i2];
            } else if (i2 < 0) {
                return nums1[i1];
            } else {
                return Math.max(nums1[i1], nums2[i2]);
            }
        }

        private int minOfRightPart(int[] nums1, int i1, int[] nums2, int i2) {
            if (i1 >= nums1.length) {
                return nums2[i2];
            } else if (i2 >= nums2.length) {
                return nums1[i1];
            } else {
                return Math.min(nums1[i1], nums2[i2]);
            }
        }
    }

    private static class S3 extends Solution4 {
        @Override
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                int[] tmp = nums1;
                nums1 = nums2;
                nums2 = tmp;
            }
            int m = nums1.length, n = nums2.length;
            int imin = 0, imax = m;
            while (imin <= imax) {
                int i = imin + (imax - imin) / 2;
                int j = (m + n + 1) / 2 - i;
                if (i < m && nums2[j - 1] > nums1[i]) {
                    imin = i + 1;
                } else if (i > 0 && nums1[i - 1] > nums2[j]) {
                    imax = i - 1;
                } else {
                    if ((m + n) % 2 != 0) {
                        return maxOfLeftPart(nums1, i - 1, nums2, j - 1);
                    } else {
                        return (maxOfLeftPart(nums1, i - 1, nums2, j - 1) + minOfRightPart(nums1, i, nums2, j)) / 2.;
                    }
                }
            }
            return -1;
        }

        private int maxOfLeftPart(int[] nums1, int i1, int[] nums2, int i2) {
            if (i1 < 0) {
                return nums2[i2];
            } else if (i2 < 0) {
                return nums1[i1];
            } else {
                return Math.max(nums1[i1], nums2[i2]);
            }
        }

        private int minOfRightPart(int[] nums1, int i1, int[] nums2, int i2) {
            if (i1 >= nums1.length) {
                return nums2[i2];
            } else if (i2 >= nums2.length) {
                return nums1[i1];
            } else {
                return Math.min(nums1[i1], nums2[i2]);
            }
        }
    }

    private static class S4 extends Solution4 {
        @Override
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }
            int m = nums1.length, n = nums2.length;
            int imin = 0, imax = m;
            while (imin <= imax) {
                int i = imin + (imax - imin) / 2;
                int j = (m + n + 1) / 2 - i;
                if (i < m && nums2[j - 1] > nums1[i]) {
                    imin = i + 1;
                } else {
                    imax = i - 1;
                }
            }
            int i = imin, j = (m + n + 1) / 2 - i;
            if ((m + n) % 2 == 1) {
                return maxOfLeftPart(nums1, i - 1, nums2, j - 1);
            } else {
                return (maxOfLeftPart(nums1, i - 1, nums2, j - 1) + minOfRightPart(nums1, i, nums2, j)) / 2.;
            }
        }

        private int maxOfLeftPart(int[] nums1, int i1, int[] nums2, int i2) {
            if (i1 < 0) {
                return nums2[i2];
            } else if (i2 < 0) {
                return nums1[i1];
            } else {
                return Math.max(nums1[i1], nums2[i2]);
            }
        }

        private int minOfRightPart(int[] nums1, int i1, int[] nums2, int i2) {
            if (i1 >= nums1.length) {
                return nums2[i2];
            } else if (i2 >= nums2.length) {
                return nums1[i1];
            } else {
                return Math.min(nums1[i1], nums2[i2]);
            }
        }
    }

    private static class S5 extends Solution4 {
        @Override
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }
            int m = nums1.length, n = nums2.length;
            int imin = 0, imax = m;
            while (imin < imax) {
                int i = imin + (imax - imin) / 2;
                int j = (m + n - 1) / 2 - i;
                if (nums2[j] > nums1[i]) {
                    imin = i + 1;
                } else {
                    imax = i;
                }
            }
            int i = imin, j = (m + n - 1) / 2 - i;
            if ((m + n) % 2 == 1) {
                return maxOfLeftPart(nums1, i-1, nums2, j);
            } else {
                return (maxOfLeftPart(nums1, i-1, nums2, j) + minOfRightPart(nums1, i, nums2, j+1)) / 2.;
            }
        }

        private int maxOfLeftPart(int[] nums1, int i1, int[] nums2, int i2) {
            if (i1 < 0) {
                return nums2[i2];
            } else if (i2 < 0) {
                return nums1[i1];
            } else {
                return Math.max(nums1[i1], nums2[i2]);
            }
        }

        private int minOfRightPart(int[] nums1, int i1, int[] nums2, int i2) {
            if (i1 >= nums1.length) {
                return nums2[i2];
            } else if (i2 >= nums2.length) {
                return nums1[i1];
            } else {
                return Math.min(nums1[i1], nums2[i2]);
            }
        }
    }

    private static class S6 extends Solution4 {
        @Override
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }
            int m = nums1.length, n = nums2.length;
            int imin = 0, imax = 2 * m;
            while (imin < imax) {
                int c1 = imin + (imax - imin) / 2;
                int c2 = m + n - c1;
                int l2 = lastNumOfLeftPart(nums2, c2);
                int r1 = firstNumOfRightPart(nums1, c1);
                if (l2 > r1) {
                    imin = c1 + 1;
                } else {
                    imax = c1;
                }
            }
            int c1 = imin, c2 = m + n - c1;
            return (Math.max(lastNumOfLeftPart(nums1, c1), lastNumOfLeftPart(nums2, c2))
                + Math.min(firstNumOfRightPart(nums1, c1), firstNumOfRightPart(nums2, c2))) / 2.;
        }

        private int lastNumOfLeftPart(int[] nums, int cutPosition) {
            return cutPosition == 0 ? Integer.MIN_VALUE : nums[(cutPosition - 1) / 2];
        }

        private int firstNumOfRightPart(int[] nums, int cutPosition) {
            return cutPosition == 2 * nums.length ? Integer.MAX_VALUE : nums[cutPosition / 2];
        }
    }

    private static class S7 extends Solution4 {
        @Override
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int mid1 = (m + n + 1) / 2, mid2 = (m + n + 2) / 2;
            return (getKth(nums1, 0, nums2, 0, mid1)
                + getKth(nums1, 0, nums2, 0, mid2)) / 2.;
        }

        private double getKth(int[] nums1, int aStart, int[] nums2, int bStart, int k) {
            if (aStart == nums1.length) {
                return nums2[bStart + k - 1];
            } else if (bStart == nums2.length) {
                return nums1[aStart + k - 1];
            } else if (k == 1) {
                return Math.min(nums1[aStart], nums2[bStart]);
            } else {
                int aEnd = aStart + k / 2 - 1, bEnd = bStart + k / 2 - 1;
                int aVal = aEnd >= nums1.length ? Integer.MAX_VALUE : nums1[aEnd];
                int bVal = bEnd >= nums2.length ? Integer.MAX_VALUE : nums2[bEnd];
                if (aVal < bVal) {
                    return getKth(nums1, aEnd + 1, nums2, bStart, k - k / 2);
                } else {
                    return getKth(nums1, aStart, nums2, bEnd + 1, k - k / 2);
                }
            }
        }
    }
}
