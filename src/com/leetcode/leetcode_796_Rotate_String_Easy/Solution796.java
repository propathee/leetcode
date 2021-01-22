package com.leetcode.leetcode_796_Rotate_String_Easy;

abstract class Solution796 {
    public abstract boolean rotateString(String A, String B);

    static Solution796 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution796 {
        @Override
        public boolean rotateString(String A, String B) {
            if (A.length() != B.length()) {
                return false;
            }
            if (A.equals(B)) {
                return true;
            }
            char[] charsA = A.toCharArray();
            char[] charsB = B.toCharArray();
            out: for (int i = 1; i < charsA.length; i++) {
                for (int p = i, q = 0; p < charsA.length; p++, q++) {
                    if (charsA[p] != charsB[q]) {
                        continue out;
                    }
                }
                for (int p = 0, q = charsA.length - i; q < charsA.length; p++, q++) {
                    if (charsA[p] != charsB[q]) {
                        continue out;
                    }
                }
                return true;
            }
            return false;
        }
    }

    private static class S2 extends Solution796 {
        @Override
        public boolean rotateString(String A, String B) {
            return A.length() == B.length() && (A + A).contains(B);
        }
    }
}
