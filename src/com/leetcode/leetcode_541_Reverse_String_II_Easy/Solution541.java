package com.leetcode.leetcode_541_Reverse_String_II_Easy;

abstract class Solution541 {
    /**
     * Given a string and an integer k, you need to reverse the first k characters
     * for every 2k characters counting from the start of the string.
     * If there are less than k characters left, reverse all of them.
     * If there are less than 2k but greater than or equal to k characters,
     * then reverse the first k characters and left the other as original.
     * @param s consists of lower English letters only.
     * @param k Length of the given string and k will in the range [1, 10000]
     */
    public abstract String reverseStr(String s, int k);

    static Solution541 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution541 {
        @Override
        public String reverseStr(String s, int k) {
            StringBuilder sBuilder = new StringBuilder();
            int n = s.length();
            for (int i = 0; i <= n / k; i += 2) {
                int start = i * k;
                if (start < n) {
                    int end = Math.min(start + k, n);
                    for (int j = end - 1; j >= start; j--) {
                        sBuilder.append(s.charAt(j));
                    }
                    start = end;
                }
                if (start < n) {
                    int end = Math.min(start + k, n);
                    for (int j = start; j < end; j++) {
                        sBuilder.append(s.charAt(j));
                    }
                }
            }
            return sBuilder.toString();
        }
    }

    private static class S2 extends Solution541 {
        @Override
        public String reverseStr(String s, int k) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.length(); i += 2 * k) {
                for (int l = i, r = Math.min(i + k, s.length()) - 1;l < r ;l++, r--) {
                    char tmp = chars[l];
                    chars[l] = chars[r];
                    chars[r] = tmp;
                }
            }
            return new String(chars);
        }
    }

    private static class S3 extends Solution541 {
        @Override
        public String reverseStr(String s, int k) {
            StringBuilder sBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if ((i % (2 * k)) < k) {
                    sBuilder.insert(i - i % k, s.charAt(i));
                } else {
                    sBuilder.append(s.charAt(i));
                }
            }
            return sBuilder.toString();
        }
    }

    private static class S4 extends Solution541 {
        @Override
        public String reverseStr(String s, int k) {
            StringBuilder sBuilder = new StringBuilder();
            int start = 0, end = 0;
            while (start < s.length()) {
                end = Math.min(start + k, s.length());
                sBuilder.append(new StringBuilder(s.substring(start, end)).reverse());
                if (end >= s.length()) {
                    break;
                }
                start = end;
                end = Math.min(start + k, s.length());
                sBuilder.append(s, start, end);
                start = end;
            }
            return sBuilder.toString();
        }
    }
}
