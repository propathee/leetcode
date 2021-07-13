package com.leetcode.leetcode_229_Majority_Element_II_Medium;

import java.util.*;

abstract class Solution229 {
    public abstract List<Integer> majorityElement(int[] nums);

    static Solution229 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution229 {
        @Override
        public List<Integer> majorityElement(int[] nums) {
            int minCnt = nums.length / 3 + 1;
            List<Integer> res = new ArrayList<>();
            Map<Integer, Integer> cntMap = new HashMap<>();
            for (int num : nums) {
                int cnt = cntMap.getOrDefault(num, 0) + 1;
                if (cnt == minCnt) {
                    res.add(num);
                }
                cntMap.put(num, cnt);
            }
            return res;
        }
    }

    private static class S2 extends Solution229 {
        @Override
        public List<Integer> majorityElement(int[] nums) {
            int candidate1 = 0, candidate2 = 1, cnt1 = 0, cnt2 = 0;
            for (int num : nums) {
                if (num == candidate1) {
                    cnt1++;
                } else if (num == candidate2) {
                    cnt2++;
                } else if (cnt1 == 0) {
                    candidate1 = num;
                    cnt1 = 1;
                } else if (cnt2 == 0) {
                    candidate2 = num;
                    cnt2 = 1;
                } else {
                    cnt1--;
                    cnt2--;
                }
            }
            List<Integer> candidates = new ArrayList<>();
            if (cnt1 > 0) {
                candidates.add(candidate1);
            }
            if (cnt2 > 0) {
                candidates.add(candidate2);
            }
            List<Integer> res = new ArrayList<>();
            for (int candidate : candidates) {
                int cnt = 0;
                for (int num : nums) {
                    if (num == candidate) {
                        cnt++;
                    }
                }
                if (cnt > nums.length / 3) {
                    res.add(candidate);
                }
            }
            return res;
        }
    }

    private static class S3 extends Solution229 {
        @Override
        public List<Integer> majorityElement(int[] nums) {
            Counter counter = new Counter();
            for (int num : nums) {
                counter.count(num);
                if (counter.size() > 2) {
                    counter.countDown(counter.numbers());
                }
            }
            List<Integer> res = new ArrayList<>();
            for (int candidate : counter.numbers()) {
                int cnt = 0;
                for (int num : nums) {
                    if (num == candidate) {
                        cnt++;
                    }
                }
                if (cnt > nums.length / 3) {
                    res.add(candidate);
                }
            }
            return res;
        }

        private static class Counter {
            private Map<Integer, Integer> map = new HashMap<>();

            void count(int num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            void countDown(Collection<Integer> nums) {
                for (int num : nums) {
                    countDown(num);
                }
            }

            private void countDown(int num) {
                int cnt = map.getOrDefault(num, 0) - 1;
                if (cnt == 0) {
                    map.remove(num);
                } else if (cnt > 0) {
                    map.put(num, cnt);
                }
            }

            int size() {
                return map.size();
            }

            List<Integer> numbers() {
                return new ArrayList<>(map.keySet());
            }
        }
    }
}
