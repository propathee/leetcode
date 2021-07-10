package com.leetcode.leetcode_210_Course_Schedule_II_Medium;

import java.util.*;

abstract class Solution210 {
    public abstract int[] findOrder(int numCourses, int[][] prerequisites);

    static Solution210 newSolution() {
        return new S2();
    }

    private static class S1 extends Solution210 {
        @Override
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Course[] courses = initCourses(numCourses, prerequisites);
            Stack<Course> stack = new Stack<>();
            for (Course course : courses) {
                if (course.requisiteNum == 0) {
                    stack.push(course);
                }
            }
            int[] order = new int[numCourses];
            int index = 0;
            while (!stack.isEmpty()) {
                Course course = stack.pop();
                order[index++] = course.id;
                for (Course nextCourse : course.nextCourses) {
                    nextCourse.requisiteNum--;
                    if (nextCourse.requisiteNum == 0) {
                        stack.push(nextCourse);
                    }
                }
            }
            return index == numCourses ? order : new int[0];
        }

        private Course[] initCourses(int numCourses, int[][] prerequisites) {
            Course[] courses = new Course[numCourses];
            for (int i = 0; i < numCourses; i++) {
                courses[i] = new Course(i);
            }
            for (int[] requisite : prerequisites) {
                int post = requisite[0], pre = requisite[1];
                courses[post].requisiteNum++;
                courses[pre].nextCourses.add(courses[post]);
            }
            return courses;
        }

        private static class Course {
            private int id;
            private int requisiteNum;
            private List<Course> nextCourses = new ArrayList<>();

            private Course(int id) {
                this.id = id;
            }
        }
    }

    private static class S2 extends Solution210 {
        @Override
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] requisiteNum = new int[numCourses];
            for (int[] requisite : prerequisites) {
                requisiteNum[requisite[0]]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < requisiteNum.length; i++) {
                if (requisiteNum[i] == 0) {
                    queue.offer(i);
                }
            }
            int[] order = new int[numCourses];
            int index = 0;
            while (!queue.isEmpty()) {
                int course = queue.poll();
                order[index++] = course;
                for (int[] requisite : prerequisites) {
                    if (requisite[1] == course) {
                        if (--requisiteNum[requisite[0]] == 0) {
                            queue.offer(requisite[0]);
                        }
                    }
                }
            }
            return index == numCourses ? order : new int[0];
        }
    }
}
