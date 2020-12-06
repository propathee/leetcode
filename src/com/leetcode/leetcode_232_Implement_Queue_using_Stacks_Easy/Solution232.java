package com.leetcode.leetcode_232_Implement_Queue_using_Stacks_Easy;

import java.util.Stack;

public class Solution232 {
    class MyQueue1 {
        private Stack<Integer> s1 = new Stack<>();
        private Stack<Integer> s2 = new Stack<>();

        public void push(int x) {
            if (s1.isEmpty()) {
                s1.push(x);
            } else {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                s1.push(x);
                while (!s2.isEmpty()) {
                    s1.push(s2.pop());
                }
            }
        }

        public int pop() {
            return s1.pop();
        }

        public int peek() {
            return s1.peek();
        }

        public boolean empty() {
            return s1.isEmpty();
        }
    }

    class MyQueue2 {
        private final Stack<Integer> in = new Stack<>();
        private final Stack<Integer> out = new Stack<>();

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            peek();
            return out.pop();
        }

        public int peek() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }
}
