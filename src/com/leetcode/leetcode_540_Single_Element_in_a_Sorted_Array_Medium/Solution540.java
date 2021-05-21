package com.leetcode.leetcode_540_Single_Element_in_a_Sorted_Array_Medium;

abstract class Solution540 {
    public abstract int singleNonDuplicate(int[] nums);

    static Solution540 newSolution() {
        return new S8();
    }

    private static class S1 extends Solution540 {
        @Override
        public int singleNonDuplicate(int[] nums) {
            int res = 0;
            for (int num : nums) {
                res ^= num;
            }
            return res;
        }
    }

    private static class S2 extends Solution540 {
        @Override
        public int singleNonDuplicate(int[] nums) {
            for (int i = 0; i < nums.length - 1; i += 2) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
            return nums[nums.length - 1];
        }
    }

    private static class S3 extends Solution540 {
        @Override
        public int singleNonDuplicate(int[] nums) {
            int low = 0, high = nums.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == nums[mid + 1]) {
                    if (mid % 2 == 0) {
                        low = mid + 2;
                    } else {
                        high = mid - 1;
                    }
                } else {
                    if ((mid + 1) % 2 == 0) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
            }
            return nums[low];
        }
    }

    private static class S4 extends Solution540 {
        @Override
        public int singleNonDuplicate(int[] nums) {
            int low = 0, high = nums.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (mid % 2 == 1) {
                    mid--;
                }
                if (nums[mid] == nums[mid + 1]) {
                    low = mid + 2;
                } else {
                    high = mid;
                }
            }
            return nums[low];
        }
    }

    private static class S5 extends Solution540 {
        @Override
        public int singleNonDuplicate(int[] nums) {
            int low = 0, high = nums.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (mid % 2 == 0) {
                    mid++;
                }
                if (nums[mid] == nums[mid - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return nums[low];
        }
    }

    private static class S6 extends Solution540 {
        @Override
        public int singleNonDuplicate(int[] nums) {
            int low = 0, high = nums.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return nums[low];
        }
    }

    private static class S7 extends Solution540 {
        @Override
        public int singleNonDuplicate(int[] nums) {
            int low = 0, high = nums.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == nums[mid ^ 1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return nums[low];
        }
    }

    private static class S8 extends Solution540 {
        @Override
        public int singleNonDuplicate(int[] nums) {
            int low = 0, high = nums.length / 2;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (nums[mid * 2] == nums[mid * 2 + 1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return nums[low * 2];
        }
    }
}
