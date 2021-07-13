package com.leetcode.leetcode_227_Basic_Calculator_II_Medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

abstract class Solution227 {
    public abstract int calculate(String s);

    static Solution227 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution227 {
        @Override
        public int calculate(String s) {
            Deque<String> deque = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    if (sb.length() > 0) {
                        deque.offer(sb.toString());
                        sb.setLength(0);
                    }
                } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                    if (sb.length() > 0) {
                        deque.offer(sb.toString());
                        sb.setLength(0);
                    }
                    deque.offer(String.valueOf(c));
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                deque.offer(sb.toString());
            }
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String symbol = deque.poll();
                if ("*".equals(symbol) || "/".equals(symbol)) {
                    int n1 = Integer.parseInt(deque.pollLast());
                    int n2 = Integer.parseInt(deque.pollFirst());
                    int res = "*".equals(symbol) ? n1 * n2 : n1 / n2;
                    deque.offer(String.valueOf(res));
                    i++;
                } else {
                    deque.offer(symbol);
                }
            }
            int res = Integer.parseInt(deque.poll());
            while (!deque.isEmpty()) {
                String op = deque.poll();
                int n2 = Integer.parseInt(deque.poll());
                if ("+".equals(op)) {
                    res += n2;
                } else {
                    res -= n2;
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution227 {
        @Override
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            int num = 0;
            char op = '+';
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    num = num * 10 + c - '0';
                }
                if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                    if (op == '+') {
                        stack.push(num);
                    } else if (op == '-') {
                        stack.push(-num);
                    } else if (op == '*') {
                        stack.push(stack.pop() * num);
                    } else {
                        stack.push(stack.pop() / num);
                    }
                    num = 0;
                    op = c;
                }
            }
            int res = 0;
            while (!stack.isEmpty()) {
                res += stack.pop();
            }
            return res;
        }
    }

    private static class S3 extends Solution227 {
        @Override
        public int calculate(String s) {
            int res = 0, curNum = 0, preNum = 0;
            char op = '+';
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isDigit(c)) {
                    curNum = curNum * 10 + c - '0';
                }
                if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                    if (op == '+') {
                        res += preNum;
                        preNum = curNum;
                    } else if (op == '-') {
                        res += preNum;
                        preNum = -curNum;
                    } else if (op == '*') {
                        preNum *= curNum;
                    } else {
                        preNum /= curNum;
                    }
                    curNum = 0;
                    op = c;
                }
            }
            return res + preNum;
        }
    }
}
