package com.leetcode.leetcode_605_Can_Place_Flowers_Easy;

abstract class Solution605 {
    public abstract boolean canPlaceFlowers(int[] flowerbed, int n);

    static Solution605 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution605 {
        @Override
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int i = 0;
            while (n > 0 && i < flowerbed.length) {
                if (flowerbed[i] == 1) {
                    i += 2;
                } else {
                    if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1) {
                        i++;
                    } else {
                        n--;
                        flowerbed[i] = 1;
                    }
                }
            }
            return n == 0;
        }
    }

    private static class S2 extends Solution605 {
        @Override
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            for (int i = 0; i < flowerbed.length && n > 0; i++) {
                if (flowerbed[i] == 0) {
                    int prev = i == 0 ? 0 : flowerbed[i - 1];
                    int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
                    if (prev == 0 && next == 0) {
                        flowerbed[i] = 1;
                        n--;
                    }
                }
            }
            return n == 0;
        }
    }

    private static class S3 extends Solution605 {
        @Override
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int cnt = 0;
            int[] flowers = new int[flowerbed.length + 2];
            System.arraycopy(flowerbed, 0, flowers, 1, flowerbed.length);
            for (int i = 0; i < flowers.length && n > 0; i++) {
                if (flowers[i] == 0) {
                    cnt++;
                } else {
                    cnt = 0;
                }
                if (cnt == 3) {
                    n--;
                    cnt = 1;
                }
            }
            return n == 0;
        }
    }

    private static class S4 extends Solution605 {
        @Override
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int cnt = 1;
            for (int i = 0; i < flowerbed.length && n > 0; i++) {
                if (flowerbed[i] == 0) {
                    cnt++;
                } else {
                    n -= (cnt - 1) / 2;
                    cnt = 0;
                }
            }
            return n <= cnt / 2;
        }
    }
}
