package com.leetcode.leetcode_482_License_Key_Formatting_Easy;

abstract class Solution482 {
    /**
     * @param S S is non-empty.
     * @param K K is a positive integer.
     */
    public abstract String licenseKeyFormatting(String S, int K);

    static Solution482 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution482 {
        @Override
        public String licenseKeyFormatting(String S, int K) {
            StringBuilder sBuilder = new StringBuilder();
            int cnt = 0;
            for (int i = S.length() - 1; i >= 0; i--) {
                char c = S.charAt(i);
                if (c == '-') {
                    continue;
                }
                sBuilder.append(Character.toUpperCase(c));
                cnt++;
                if (cnt == K) {
                    sBuilder.append('-');
                    cnt = 0;
                }
            }
            if (sBuilder.length() > 0 && sBuilder.charAt(sBuilder.length() - 1) == '-') {
                sBuilder.deleteCharAt(sBuilder.length() - 1);
            }
            return sBuilder.reverse().toString();
        }
    }

    private static class S2 extends Solution482 {
        @Override
        public String licenseKeyFormatting(String S, int K) {
            StringBuilder sBuilder = new StringBuilder();
            for (int i = S.length() - 1; i >= 0; i--) {
                char c = S.charAt(i);
                if (c == '-') {
                    continue;
                }
                if (sBuilder.length() % (K + 1) == K) {
                    sBuilder.append('-');
                }
                sBuilder.append(Character.toUpperCase(c));
            }
            return sBuilder.reverse().toString();
        }
    }
}
