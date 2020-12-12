package com.leetcode.leetcode_374_Guess_Number_Higher_or_Lower_Easy;

public abstract class Solution374 {
    private int pick;
    public Solution374(int pick) { this.pick = pick; }

    /**
     * 1 <= pick <= n
     * @param n 1 <= n <= 2^31 - 1
     */
    public abstract int guessNumber(int n);

    /**
     * @return -1: The number I picked is lower than your guess (i.e. pick < num).
     *          1: The number I picked is higher than your guess (i.e. pick > num).
     *          0: The number I picked is equal to your guess (i.e. pick == num).
     */
    protected int guess(int num) {
        return Integer.compare(pick, num);
    }

    public static Solution374 newSolution(int pick) {
        return new S2(pick);
    }

    private static class S1 extends Solution374 {
        public S1(int pick) { super(pick); }

        @Override
        public int guessNumber(int n) {
            int low = 1;
            int high = n;
            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                int res = guess(mid);
                if (res > 0) {
                    low = mid + 1;
                } else if (res < 0){
                    high = mid - 1; // or high = mid;
                } else {
                    return mid;
                }
            }
            return 0;
        }
    }

    private static class S2 extends Solution374 {
        public S2(int pick) { super(pick); }

        @Override
        public int guessNumber(int n) {
            int low = 1;
            int high = n;
            while (low < high) {
                int mid = low + ((high - low) >> 1);
                int res = guess(mid);
                if (res > 0) {
                    low = mid + 1;
                } else if (res < 0) {
                    high = mid - 1; // or high = mid;
                } else {
                    return mid;
                }
            }
            return low;
        }
    }
}
