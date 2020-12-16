package com.leetcode.leetcode_414_Third_Maximum_Number_Easy;

import java.util.*;

public abstract class Solution414 {
    /**
     * Given a <b>non-empty</b> array of integers,
     * return the <b>third</b> maximum number in this array.
     * If it does not exist, return the maximum number.
     * The time complexity must be in O(n).
     */
    public abstract int thirdMax(int[] nums);

    static Solution414 newSolution() {
        return new S6();
    }

    private static class S1 extends Solution414 {
        @Override
        public int thirdMax(int[] nums) {
            int first = nums[0];
            Integer second = null;
            Integer third = null;
            for (int n : nums) {
                if (n > first) {
                    third = second;
                    second = first;
                    first = n;
                } else if (n == first) {
                    continue;
                } else if (second == null) {
                    second = n;
                } else if (n > second) {
                    third = second;
                    second = n;
                } else if (n == second) {
                    continue;
                } else if (third == null) {
                    third = n;
                } else if (n > third) {
                    third = n;
                }
            }
            return third == null ? first : third;
        }
    }

    private static class S2 extends Solution414 {
        @Override
        public int thirdMax(int[] nums) {
            Integer first = null;
            Integer second = null;
            Integer third = null;
            for (Integer n : nums) {
                if (n.equals(first) || n.equals(second) || n.equals(third)) {
                    continue;
                }
                if (first == null || n > first) {
                    third = second;
                    second = first;
                    first = n;
                } else if (second == null || n > second) {
                    third = second;
                    second = n;
                } else if (third == null || n > third) {
                    third = n;
                }
            }
            return third == null ? first : third;
        }
    }

    private static class S3 extends Solution414 {
        @Override
        public int thirdMax(int[] nums) {
            long first = Long.MIN_VALUE;
            long second = Long.MIN_VALUE;
            long third = Long.MIN_VALUE;
            for (int n : nums) {
                if (n == first || n == second || n == third) {
                    continue;
                }
                if (n > first) {
                    third = second;
                    second = first;
                    first = n;
                } else if (n > second) {
                    third = second;
                    second = n;
                } else if (n > third) {
                    third = n;
                }
            }
            return (int) (third == Long.MIN_VALUE ? first : third);
        }
    }

    private static class S4 extends Solution414 {
        @Override
        public int thirdMax(int[] nums) {
            List<Integer> list = new LinkedList<>();
            list.add(nums[0]);
            out: for (int num : nums) {
                int i;
                for (i = 0; i < 3 && i < list.size(); i++) {
                    int n = list.get(i);
                    if (num == n) {
                        continue out;
                    }
                    if (num > n) {
                        break;
                    }
                }
                list.add(i, num);
            }
            return list.size() > 2 ? list.get(2) : list.get(0);
        }
    }

    private static class S5 extends Solution414 {
        @Override
        public int thirdMax(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int n : nums) {
                set.add(n);
                if (set.size() > 3) {
                    set.remove(Collections.min(set));
                }
            }
            return set.size() > 2 ? Collections.min(set) : Collections.max(set);
        }
    }

    private static class S6 extends Solution414 {
        @Override
        public int thirdMax(int[] nums) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            Set<Integer> set = new HashSet<>();
            for (int n : nums) {
                if (!set.contains(n)) {
                    set.add(n);
                    pq.offer(n);
                    if (set.size() > 3) {
                        set.remove(pq.poll());
                    }
                }
            }
            if (pq.size() < 3) {
                while (pq.size() > 1) {
                    pq.poll();
                }
            }
            return pq.poll();
        }
    }
}
