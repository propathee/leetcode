package com.leetcode.leetcode_690_Employee_Importance_Easy;

import java.util.*;

import static java.util.stream.Collectors.toMap;

abstract class Solution690 {
    /**
     * One employee has at most one direct leader and may have several subordinates.
     */
    public abstract int getImportance(List<Employee> employees, int id);

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    static Solution690 newSolution() {
        return new S3();
    }

    private static class S1 extends Solution690 {
        private Map<Integer, Employee> map = new HashMap<>();

        @Override
        public int getImportance(List<Employee> employees, int id) {
            for (Employee e : employees) {
                map.put(e.id, e);
            }
            return helper(map.get(id));
        }

        private int helper(Employee employee) {
            int res = employee.importance;
            if (employee.subordinates != null) {
                for (Integer id : employee.subordinates) {
                    res += helper(map.get(id));
                }
            }
            return res;
        }
    }

    private static class S2 extends Solution690 {
        @Override
        public int getImportance(List<Employee> employees, int id) {
            Map<Integer, Employee> map = new HashMap<>();
            for (Employee e : employees) {
                map.put(e.id, e);
            }
            int res = 0;
            Queue<Employee> queue = new LinkedList<>();
            queue.offer(map.get(id));
            while (!queue.isEmpty()) {
                Employee e = queue.poll();
                res += e.importance;
                if (e.subordinates != null) {
                    for (int i : e.subordinates) {
                        queue.offer(map.get(i));
                    }
                }
            }
            return res;
        }
    }

    private static class S3 extends Solution690 {
        @Override
        public int getImportance(List<Employee> employees, int id) {
            Map<Integer, Employee> map = employees.stream().collect(toMap(e -> e.id, e -> e));
            int res = 0;
            Stack<Employee> stack = new Stack<>();
            stack.push(map.get(id));
            while (!stack.isEmpty()) {
                Employee e = stack.pop();
                res += e.importance;
                if (e.subordinates != null && !e.subordinates.isEmpty()) {
                    for (int i : e.subordinates) {
                        stack.push(map.get(i));
                    }
                }
            }
            return res;
        }
    }
}
