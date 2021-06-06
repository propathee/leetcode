package com.leetcode.leetcode_150_Evaluate_Reverse_Polish_Notation_Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

abstract class Solution150 {
    public abstract int evalRPN(String[] tokens);

    static Solution150 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution150 {
        @Override
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token : tokens) {
                if (Character.isDigit(token.charAt(token.length() - 1))) {
                    stack.push(Integer.parseInt(token));
                } else {
                    int n2 = stack.pop();
                    int n1 = stack.pop();
                    stack.push(eval(n1, n2, token));
                }
            }
            return stack.peek();
        }

        private int eval(int n1, int n2, String op) {
            switch (op) {
                case "+":
                    return n1 + n2;
                case "-":
                    return n1 - n2;
                case "*":
                    return n1 * n2;
                default:
                    return n1 / n2;
            }
        }
    }

    private static class S2 extends Solution150 {
        @Override
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token : tokens) {
                if ("+".equals(token)) {
                    stack.push(stack.pop() + stack.pop());
                } else if ("-".equals(token)) {
                    stack.push(-stack.pop() + stack.pop());
                } else if ("*".equals(token)) {
                    stack.push(stack.pop() * stack.pop());
                } else if ("/".equals(token)) {
                    int n2 = stack.pop();
                    int n1 = stack.pop();
                    stack.push(n1 / n2);
                } else {
                    stack.push(Integer.parseInt(token));
                }
            }
            return stack.peek();
        }
    }

    private static class S3 extends Solution150 {
        private static Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();

        static {
            map.put("+", (x, y) -> x + y);
            map.put("-", (x, y) -> x - y);
            map.put("*", (x, y) -> x * y);
            map.put("/", (x, y) -> x / y);
        }

        @Override
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token : tokens) {
                if (map.containsKey(token)) {
                    int n2 = stack.pop();
                    int n1 = stack.pop();
                    stack.push(map.get(token).apply(n1, n2));
                } else {
                    stack.push(Integer.parseInt(token));
                }
            }
            return stack.peek();
        }
    }
}
