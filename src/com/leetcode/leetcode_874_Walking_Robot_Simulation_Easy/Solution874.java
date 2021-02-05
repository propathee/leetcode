package com.leetcode.leetcode_874_Walking_Robot_Simulation_Easy;

import java.util.HashSet;
import java.util.Set;

abstract class Solution874 {
    public abstract int robotSim(int[] commands, int[][] obstacles);

    static Solution874 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution874 {
        @Override
        public int robotSim(int[] commands, int[][] obstacles) {
            Set<String> set = new HashSet<>();
            for (int[] point : obstacles) {
                set.add(point[0] + "," + point[1]);
            }
            int x = 0, y = 0, res = 0, d = 0;
            int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            for (int cmd : commands) {
                if (cmd == -2) {
                    if (--d < 0) {
                        d = 3;
                    }
                } else if (cmd == -1) {
                    if (++d > 3) {
                        d = 0;
                    }
                } else {
                    int[] move = moves[d];
                    for (; cmd > 0; cmd--) {
                        x += move[0];
                        y += move[1];
                        if (set.contains(x + "," + y)) {
                            x -= move[0];
                            y -= move[1];
                            break;
                        }
                    }
                    res = Math.max(res, x * x + y * y);
                }
            }
            return res;
        }
    }
}
