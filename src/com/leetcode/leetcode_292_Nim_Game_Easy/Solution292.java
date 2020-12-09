package com.leetcode.leetcode_292_Nim_Game_Easy;

public class Solution292 {
    /**
     * if i'd be failed when i got n:
     *   then i'd win when I got n+1/n+2/n+3;
     *   and i'd be failed again when I got n+4;
     * since i'd be failed when i got 0;
     * we can conclude that i'd be failed when n is 4s;
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
