package com.leetcode.leetcode_925_Long_Pressed_Name_Easy;

abstract class Solution925 {
    public abstract boolean isLongPressedName(String name, String typed);

    static Solution925 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution925 {
        @Override
        public boolean isLongPressedName(String name, String typed) {
            int i = 0, j = 0;
            while (i < name.length() && j < typed.length()) {
                if (name.charAt(i) != typed.charAt(j)) {
                    return false;
                }
                int repeat1 = 0, repeat2 = 0;
                for (i++; i < name.length() && name.charAt(i) == name.charAt(i - 1); i++, repeat1++);
                for (j++; j < typed.length() && typed.charAt(j) == typed.charAt(j - 1); j++, repeat2++);
                if (repeat1 > repeat2) {
                    return false;
                }
            }
            return i == name.length() && j == typed.length();
        }
    }

    private static class S2 extends Solution925 {
        @Override
        public boolean isLongPressedName(String name, String typed) {
            int i = 0;
            for (int j = 0; j < typed.length(); j++) {
                if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                    i++;
                } else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
                    return false;
                }
            }
            return i == name.length();
        }
    }

    private static class S3 extends Solution925 {
        @Override
        public boolean isLongPressedName(String name, String typed) {
            int i = 0, j = 0;
            while (i < name.length() && j < typed.length()) {
                int need = 1;
                char c = name.charAt(i);
                for (i++; i < name.length() && name.charAt(i) == c; i++, need++);
                for (; j < typed.length() && typed.charAt(j) == c; j++, need--);
                if (need > 0) {
                    return false;
                }
            }
            return i == name.length() && j == typed.length();
        }
    }
}
