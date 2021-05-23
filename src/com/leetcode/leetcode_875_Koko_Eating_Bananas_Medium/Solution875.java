package com.leetcode.leetcode_875_Koko_Eating_Bananas_Medium;

abstract class Solution875 {
    public abstract int minEatingSpeed(int[] piles, int h);

    static Solution875 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution875 {
        @Override
        public int minEatingSpeed(int[] piles, int h) {
            int low = 1, high = piles[0];
            for (int pile : piles) {
                low = Math.min(low, pile);
                high = Math.max(high, pile);
            }
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (canEatAllInTime(piles, mid, h)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        private boolean canEatAllInTime(int[] piles, int speed, int time) {
            int costTime = 0;
            for (int pile : piles) {
                costTime += (pile / speed);
                if (pile % speed != 0) {
                    costTime++;
                }
                if (costTime > time) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class S2 extends Solution875 {
        @Override
        public int minEatingSpeed(int[] piles, int h) {
            int low = 1, high = piles[0];
            for (int pile : piles) {
                low = Math.min(low, pile);
                high = Math.max(high, pile);
            }
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (canEatAllInTime(piles, mid, h)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

        private boolean canEatAllInTime(int[] piles, int speed, int time) {
            int costTime = 0;
            for (int pile : piles) {
                costTime += (pile / speed);
                if (pile % speed != 0) {
                    costTime++;
                }
                if (costTime > time) {
                    return false;
                }
            }
            return true;
        }
    }

    private static class S3 extends Solution875 {
        @Override
        public int minEatingSpeed(int[] piles, int h) {
            int low = 1, high = 1000000000;
            while (low < high) {
                int mid = low + (high - low) / 2;
                int total = 0;
                for (int p : piles) {
                    total += (p + mid - 1) / mid;
                }
                if (total > h) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
}
