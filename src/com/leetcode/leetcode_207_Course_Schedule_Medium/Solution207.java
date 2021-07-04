package com.leetcode.leetcode_207_Course_Schedule_Medium;

import java.util.*;

abstract class Solution207 {
    public abstract boolean canFinish(int numCourses, int[][] prerequisites);

    static Solution207 newSolution() {
        return new S4();
    }

    private static class S1 extends Solution207 {
        @Override
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Course[] courses = initCourses(numCourses, prerequisites);
            Stack<Course> stack = new Stack<>();
            for (Course course : courses) {
                if (course.prerequisiteNum == 0) {
                    stack.push(course);
                }
            }
            int finishedCourses = 0;
            while (!stack.isEmpty()) {
                Course course = stack.pop();
                finishedCourses++;
                for (Course nextCourse : course.subsequentCourses) {
                    nextCourse.prerequisiteNum--;
                    if (nextCourse.prerequisiteNum == 0) { // may less than 0
                        stack.push(nextCourse);
                    }
                }
            }
            return finishedCourses == numCourses;
        }

        private Course[] initCourses(int numCourses, int[][] prerequisites) {
            Course[] courses = new Course[numCourses];
            for (int i = 0; i < numCourses; i++) {
                courses[i] = new Course();
            }
            for (int[] requisite : prerequisites) {
                int from = requisite[0], to = requisite[1];
                courses[to].prerequisiteNum++;
                courses[from].subsequentCourses.add(courses[to]);
            }
            return courses;
        }

        private static class Course {
            private int prerequisiteNum;
            private List<Course> subsequentCourses = new ArrayList<>();
        }
    }

    private static class S2 extends Solution207 {
        @Override
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Course[] courses = initCourses(numCourses, prerequisites);
            Queue<Course> queue = new LinkedList<>();
            for (Course course : courses) {
                if (course.prerequisiteNum == 0) {
                    queue.offer(course);
                }
            }
            int finishedCourses = 0;
            while (!queue.isEmpty()) {
                Course course = queue.poll();
                finishedCourses++;
                for (Course nextCourse : course.subsequentCourses) {
                    nextCourse.prerequisiteNum--;
                    if (nextCourse.prerequisiteNum == 0) { // may less than 0
                        queue.offer(nextCourse);
                    }
                }
            }
            return finishedCourses == numCourses;
        }

        private Course[] initCourses(int numCourses, int[][] prerequisites) {
            Course[] courses = new Course[numCourses];
            for (int i = 0; i < numCourses; i++) {
                courses[i] = new Course();
            }
            for (int[] requisite : prerequisites) {
                int from = requisite[0], to = requisite[1];
                courses[to].prerequisiteNum++;
                courses[from].subsequentCourses.add(courses[to]);
            }
            return courses;
        }

        private static class Course {
            private int prerequisiteNum;
            private List<Course> subsequentCourses = new ArrayList<>();
        }
    }

    private static class S3 extends Solution207 {
        private int[] state;
        private List<Integer>[] graph;

        @Override
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            state = new int[numCourses];
            graph = new List[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList<>();
            }
            for (int[] requisite : prerequisites) {
                graph[requisite[0]].add(requisite[1]);
            }

            for (int i = 0; i < numCourses; i++) {
                if (hasCycle(i)) {
                    return false;
                }
            }
            return true;
        }

        private boolean hasCycle(int v) {
            if (state[v] == 1) {
                return false;
            } else if (state[v] == -1) {
                return true;
            } else {
                state[v] = -1;
                for (int next : graph[v]) {
                    if (hasCycle(next)) {
                        return true;
                    }
                }
                state[v] = 1;
                return false;
            }
        }
    }

    private static class S4 extends Solution207 {
        @Override
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Course[] courses = initCourses(numCourses, prerequisites);
            Stack<Course> stack = new Stack<>();
            for (Course course : courses) {
                if (course.subsequentCourseNum == 0) {
                    stack.push(course);
                }
            }
            int finishedCourses = 0;
            while (!stack.isEmpty()) {
                Course course = stack.pop();
                finishedCourses++;
                for (Course requiredCourse : course.requiredCourses) {
                    requiredCourse.subsequentCourseNum--;
                    if (requiredCourse.subsequentCourseNum == 0) {
                        stack.push(requiredCourse);
                    }
                }
            }
            return finishedCourses == numCourses;
        }

        private Course[] initCourses(int numCourses, int[][] prerequisites) {
            Course[] courses = new Course[numCourses];
            for (int i = 0; i < numCourses; i++) {
                courses[i] = new Course();
            }
            for (int[] requisite : prerequisites) {
                int from = requisite[0], to = requisite[1];
                courses[from].subsequentCourseNum++;
                courses[to].requiredCourses.add(courses[from]);
            }
            return courses;
        }

        private static class Course {
            private int subsequentCourseNum;
            private List<Course> requiredCourses = new ArrayList<>();
        }
    }
}
