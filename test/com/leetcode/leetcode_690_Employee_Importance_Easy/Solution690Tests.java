package com.leetcode.leetcode_690_Employee_Importance_Easy;

import com.leetcode.leetcode_690_Employee_Importance_Easy.Solution690.Employee;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Solution690Tests {
    private Solution690 solution = Solution690.newSolution();

    @Test
    public void should_pass_1() {
        List<Employee> employees = makeEmployees("[1,5,[2,3]]; [2,3,[]]; [3,3,[]]");
        assertEquals(11, solution.getImportance(employees, 1));
    }

    private List<Employee> makeEmployees(String s) {
        List<Employee> res = new ArrayList<>();
        for (String item : s.split("; ")) {
            String[] properties = item.substring(1, item.length() - 1).split(",", 3);
            int id = Integer.parseInt(properties[0]);
            int importance = Integer.parseInt(properties[1]);
            String sub = properties[2].replace("[", "").replace("]", "");
            List<Integer> subordinates = sub.length() == 0 ? new ArrayList<>()
                : Arrays.stream(sub.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            Employee employee = new Employee();
            employee.id = id;
            employee.importance = importance;
            employee.subordinates = subordinates;
            res.add(employee);
        }
        return res;
    }
}