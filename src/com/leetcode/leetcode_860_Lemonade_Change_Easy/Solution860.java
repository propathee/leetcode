package com.leetcode.leetcode_860_Lemonade_Change_Easy;

abstract class Solution860 {
    public abstract boolean lemonadeChange(int[] bills);

    static Solution860 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution860 {
        @Override
        public boolean lemonadeChange(int[] bills) {
            int[] incomes = new int[21];
            for (int bill : bills) {
                if (bill == 10) {
                    if (--incomes[5] < 0) {
                        return false;
                    }
                } else if (bill == 20) {
                    if (incomes[10] > 0) {
                        incomes[10]--;
                        incomes[5]--;
                    } else {
                        incomes[5] -= 3;
                    }
                    if (incomes[5] < 0) {
                        return false;
                    }
                }
                incomes[bill]++;
            }
            return true;
        }
    }

    private static class S2 extends Solution860 {
        @Override
        public boolean lemonadeChange(int[] bills) {
            int[] incomes = new int[3];
            for (int bill : bills) {
                if (bill == 10) {
                    if (--incomes[0] < 0) {
                        return false;
                    }
                    incomes[1]++;
                } else if (bill == 20) {
                    if (incomes[1] > 0) {
                        incomes[1]--;
                        incomes[0]--;
                    } else {
                        incomes[0] -= 3;
                    }
                    if (incomes[0] < 0) {
                        return false;
                    }
                    incomes[2]++;
                } else {
                    incomes[0]++;
                }
            }
            return true;
        }
    }

    private static class S3 extends Solution860 {
        @Override
        public boolean lemonadeChange(int[] bills) {
            int five = 0, ten = 0;
            for (int bill : bills) {
                if (bill == 5) {
                    five++;
                } else if (bill == 10) {
                    ten++;
                    five--;
                } else {
                    if (ten > 0) {
                        ten--;
                        five--;
                    } else {
                        five -= 3;
                    }
                }
                if (five < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
