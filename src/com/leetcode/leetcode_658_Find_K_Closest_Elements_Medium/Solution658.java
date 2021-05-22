package com.leetcode.leetcode_658_Find_K_Closest_Elements_Medium;

import java.util.ArrayList;
import java.util.List;

abstract class Solution658 {
    public abstract List<Integer> findClosestElements(int[] arr, int k, int x);

    static Solution658 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution658 {
        @Override
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> res = new ArrayList<>();
            for (int num : arr) {
                if (res.size() < k) {
                    res.add(num);
                } else {
                    if (res.get(0) >= x) {
                        break;
                    } else {
                        if (num + res.get(0) - 2 * x < 0) {
                            res.remove(0);
                            res.add(num);
                        } else {
                            break;
                        }
                    }
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution658 {
        @Override
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> res = new ArrayList<>();
            for (int num : arr) {
                if (res.size() < k) {
                    res.add(num);
                } else {
                    if (res.get(0) < x && num + res.get(0) - 2 * x < 0) {
                        res.remove(0);
                        res.add(num);
                    } else {
                        break;
                    }
                }
            }
            return res;
        }
    }

    private static class S3 extends Solution658 {
        @Override
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> res = new ArrayList<>();
            int idx = binarySearch(arr, x);
            for (int i = 0; i < k && idx - i >= 0; i++) {
                res.add(0, arr[idx - i]);
            }
            for (int i = idx + 1; i < arr.length; i++) {
                int num = arr[i];
                if (res.size() < k) {
                    res.add(num);
                } else {
                    if (res.get(0) < x && num + res.get(0) - 2 * x < 0) {
                        res.remove(0);
                        res.add(num);
                    } else {
                        break;
                    }
                }
            }
            return res;
        }

        private int binarySearch(int[] arr, int x) {
            int low = 0, high = arr.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] < x) {
                    low = mid + 1;
                } else if (arr[mid] > x){
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
            return high;
        }
    }

    private static class S4 extends Solution658 {
        @Override
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int low = 0, high = arr.length - k;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (x - arr[mid] > arr[mid + k] - x) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int i = low; i < low + k; i++) {
                res.add(arr[i]);
            }
            return res;
        }
    }
}
