package com.leetcode.leetcode_748_Shortest_Completing_Word_Easy;

abstract class Solution748 {
    public abstract String shortestCompletingWord(String licensePlate, String[] words);

    static Solution748 newSolution() {
        return new S1();
    }

    private static class S1 extends Solution748 {
        @Override
        public String shortestCompletingWord(String licensePlate, String[] words) {
            int[] licenseChars = toChars(licensePlate);
            String res = null;
            for (String w : words) {
                if (res == null || w.length() < res.length()) {
                    int[] wChars = toChars(w);
                    boolean flag = true;
                    for (int i = 0; i < 26; i++) {
                        if (wChars[i] < licenseChars[i]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        res = w;
                    }
                }
            }
            return res;
        }

        private int[] toChars(String word) {
            int[] res = new int[26];
            for (char c : word.toLowerCase().toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    res[c - 'a']++;
                }
            }
            return res;
        }
    }
}
