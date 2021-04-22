package com.leetcode.leetcode_134_Gas_Station_Medium;

abstract class Solution134 {
    public abstract int canCompleteCircuit(int[] gas, int[] cost);

    static Solution134 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution134 {
        @Override
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int totalGas = 0;
            for (int i = 0; i < gas.length; i++) {
                for (int j = i, k = 0; k < gas.length; j++, k++) {
                    int idx = j % gas.length;
                    totalGas += (gas[idx] - cost[idx]);
                    if (totalGas < 0) {
                        break;
                    }
                }
                if (totalGas >= 0) {
                    return i;
                } else {
                    totalGas = 0;
                }
            }
            return -1;
        }
    }

    private static class S2 extends Solution134 {
        @Override
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int tank = 0;
            int start = 0;
            int curStation = 0;
            int stationCnt = 0;
            while (stationCnt < gas.length) {
                tank += (gas[curStation] - cost[curStation]);
                stationCnt++;
                while (tank < 0 && start < gas.length) {
                    tank -= (gas[start] - cost[start]);
                    start++;
                    stationCnt--;
                }
                curStation = (curStation + 1) % gas.length;
            }
            return tank >= 0 ? start : -1;
        }
    }

    private static class S3 extends Solution134 {
        @Override
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int tank = 0, total = 0, start = 0;
            for (int i = 0; i < gas.length; i++) {
                int delta = gas[i] - cost[i];
                total += delta;
                tank += delta;
                if (tank < 0) {
                    start = i + 1;
                    tank = 0;
                }
            }
            return total >= 0 ? start : -1;
        }
    }
}
