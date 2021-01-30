package com.leetcode.leetcode_844_Backspace_String_Compare_Easy;

import java.util.Stack;

abstract class Solution844 {
    public abstract boolean backspaceCompare(String S, String T);

    static Solution844 newSolution() {
        return new S5();
    }

    private static class S1 extends Solution844 {
        @Override
        public boolean backspaceCompare(String S, String T) {
            return getTypedString(S).equals(getTypedString(T));
        }

        private String getTypedString(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c != '#') {
                    sb.append(c);
                } else if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            return sb.toString();
        }
    }

    private static class S2 extends Solution844 {
        @Override
        public boolean backspaceCompare(String S, String T) {
            Stack<Character> stack1 = toStack(S);
            Stack<Character> stack2 = toStack(T);
            if (stack1.size() != stack2.size()) {
                return false;
            } else {
                while (!stack1.isEmpty()) {
                    if (!stack1.pop().equals(stack2.pop())) {
                        return false;
                    }
                }
            }
            return true;
        }

        private Stack<Character> toStack(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c != '#') {
                    stack.push(c);
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            return stack;
        }
    }

    private static class S3 extends Solution844 {
        @Override
        public boolean backspaceCompare(String S, String T) {
            int p = findPrevIndex(S, S.length());
            int q = findPrevIndex(T, T.length());
            while (p >= 0 || q >= 0) {
                if (p < 0 || q < 0 || S.charAt(p) != T.charAt(q)) {
                    return false;
                }
                p = findPrevIndex(S, p);
                q = findPrevIndex(T, q);
            }
            return true;
        }

        private int findPrevIndex(String s, int curIndex) {
            int backspaces = 0;
            int idx = curIndex - 1;
            while (idx >= 0) {
                if (s.charAt(idx) == '#') {
                    idx--;
                    backspaces++;
                } else {
                    if (backspaces == 0) {
                        return idx;
                    } else {
                        idx--;
                        backspaces--;
                    }
                }
            }
            return idx;
        }
    }

    private static class S4 extends Solution844 {
        @Override
        public boolean backspaceCompare(String S, String T) {
            int p = findPrevIndex(S, S.length());
            int q = findPrevIndex(T, T.length());
            while (p >= 0 || q >= 0) {
                if (p < 0 || q < 0 || S.charAt(p) != T.charAt(q)) {
                    return false;
                }
                p = findPrevIndex(S, p);
                q = findPrevIndex(T, q);
            }
            return true;
        }

        private int findPrevIndex(String s, int curIndex) {
            for (int i = curIndex - 1, backspaces = 0; i >= 0; i--) {
                if (s.charAt(i) == '#') {
                    backspaces++;
                } else {
                    if (backspaces == 0) {
                        return i;
                    } else {
                        backspaces--;
                    }
                }
            }
            return -1;
        }
    }

    private static class S5 extends Solution844 {
        @Override
        public boolean backspaceCompare(String S, String T) {
            int p = S.length() - 1, q = T.length() - 1, backspaces = 0;
            while (true) {
                while (p >= 0 && (S.charAt(p) == '#' || backspaces > 0)) {
                    backspaces += (S.charAt(p) == '#' ? 1 : -1);
                    p--;
                }
                backspaces = 0;
                while (q >= 0 && (T.charAt(q) == '#' || backspaces > 0)) {
                    backspaces += (T.charAt(q) == '#' ? 1 : -1);
                    q--;
                }
                if (p >= 0 && q >= 0 && S.charAt(p) == T.charAt(q)) {
                    p--;
                    q--;
                } else {
                    break;
                }
            }
            return p == -1 && q == -1;
        }
    }
}
