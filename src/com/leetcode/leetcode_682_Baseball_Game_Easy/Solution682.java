package com.leetcode.leetcode_682_Baseball_Game_Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

abstract class Solution682 {
    public abstract int calPoints(String[] ops);

    static Solution682 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution682 {
        @Override
        public int calPoints(String[] ops) {
            List<Integer> scores = new ArrayList<>();
            for (String op : ops) {
                switch (op) {
                    case "C":
                        scores.remove(scores.size() - 1);
                        break;
                    case "D":
                        scores.add(scores.get(scores.size() - 1) * 2);
                        break;
                    case "+":
                        scores.add(scores.get(scores.size() - 1) + scores.get(scores.size() - 2));
                        break;
                    default:
                        scores.add(Integer.parseInt(op));
                }
            }
            int sum = 0;
            for (int score : scores) {
                sum += score;
            }
            return sum;
        }
    }

    private static class S2 extends Solution682 {
        @Override
        public int calPoints(String[] ops) {
            int sum = 0;
            LinkedList<Integer> scores = new LinkedList<>();
            for (String op : ops) {
                switch (op) {
                    case "C":
                        sum -= scores.removeLast();
                        break;
                    case "D":
                        scores.add(scores.peekLast() * 2);
                        sum += scores.peekLast();
                        break;
                    case "+":
                        int n1 = scores.removeLast();
                        int n2 = scores.peekLast();
                        scores.add(n1);
                        scores.add(n1 + n2);
                        sum += scores.peekLast();
                        break;
                    default:
                        scores.add(Integer.parseInt(op));
                        sum += scores.peekLast();
                }
            }
            return sum;
        }
    }

    private static class S3 extends Solution682 {
        @Override
        public int calPoints(String[] ops) {
            int sum = 0;
            List<Integer> scores = new ArrayList<>();
            for (String op : ops) {
                switch (op) {
                    case "C":
                        sum -= scores.remove(scores.size() - 1);
                        break;
                    case "D":
                        scores.add(scores.get(scores.size() - 1) * 2);
                        sum += scores.get(scores.size() - 1);
                        break;
                    case "+":
                        scores.add(scores.get(scores.size() - 1) + scores.get(scores.size() - 2));
                        sum += scores.get(scores.size() - 1);
                        break;
                    default:
                        scores.add(Integer.parseInt(op));
                        sum += scores.get(scores.size() - 1);
                }
            }
            return sum;
        }
    }

    private static class S4 extends Solution682 {
        @Override
        public int calPoints(String[] ops) {
            int sum = 0;
            Stack<Integer> scores = new Stack<>();
            for (String op : ops) {
                switch (op) {
                    case "C":
                        sum -= scores.pop();
                        break;
                    case "D":
                        scores.push(scores.peek() * 2);
                        sum += scores.peek();
                        break;
                    case "+":
                        int n1 = scores.pop();
                        int n2 = n1 + scores.peek();
                        scores.push(n1);
                        scores.push(n2);
                        sum += n2;
                        break;
                    default:
                        scores.push(Integer.parseInt(op));
                        sum += scores.peek();
                }
            }
            return sum;
        }
    }
}
