package com.leetcode.leetcode_434_Number_of_Segments_in_a_String_Easy;

public abstract class Solution434 {
    /**
     * You are given a string s, return the number of segments in the string.
     * <p>
     * A segment is defined to be a contiguous sequence of non-space characters.
     * <ul>
     * <li>0 <= s.length <= 300</li>
     * <li>s consists of lower-case and upper-case English letters, digits
     * or one of the following characters "!@#$%^&*()_+-=',.:".</li>
     * <li>The only space character in s is ' '.</li>
     * </ul>
     */
    public abstract int countSegments(String s);

    static Solution434 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution434 {
        @Override
        public int countSegments(String s) {
            int cnt = 0;
            boolean isBlank = true;
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    isBlank = true;
                } else if (isBlank) {
                    cnt++;
                    isBlank = false;
                }
            }
            return cnt;
        }
    }

    private static class S2 extends Solution434 {
        @Override
        public int countSegments(String s) {
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

    private static class S3 extends Solution434 {
        @Override
        public int countSegments(String s) {
            s = " " + s;
            int cnt = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != ' ' && s.charAt(i - 1) == ' ') {
                    cnt++;
                }
            }
            return cnt;
        }
    }

    private static class S4 extends Solution434 {
        @Override
        public int countSegments(String s) {
            s = s.trim();
            return s.isEmpty() ? 0 : s.split("\\s+").length;
        }
    }
}
