package com.leetcode.leetcode_599_Minimum_Index_Sum_of_Two_Lists_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution599Tests {
    private Solution599 solution = Solution599.newSolution();

    @Test
    public void should_pass_1() {
        String[] input1 = new String[] {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] input2 = new String[] {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        String[] expect = new String[] {"Shogun"};
        assertArrayEquals(expect, solution.findRestaurant(input1, input2));
    }

    @Test
    public void should_pass_2() {
        String[] input1 = new String[] {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] input2 = new String[] {"KFC","Shogun","Burger King"};
        String[] expect = new String[] {"Shogun"};
        assertArrayEquals(expect, solution.findRestaurant(input1, input2));
    }

    @Test
    public void should_pass_3() {
        String[] input1 = new String[] {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] input2 = new String[] {"KFC","Burger King","Tapioca Express","Shogun"};
        String[] expect = new String[] {"KFC","Burger King","Tapioca Express","Shogun"};
        assertArrayEquals(expect, solution.findRestaurant(input1, input2));
    }

    @Test
    public void should_pass_4() {
        String[] input1 = new String[] {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] input2 = new String[] {"KNN","KFC","Burger King","Tapioca Express","Shogun"};
        String[] expect = new String[] {"KFC","Burger King","Tapioca Express","Shogun"};
        assertArrayEquals(expect, solution.findRestaurant(input1, input2));
    }

    @Test
    public void should_pass_5() {
        String[] input1 = new String[] {"KFC"};
        String[] input2 = new String[] {"KFC"};
        String[] expect = new String[] {"KFC"};
        assertArrayEquals(expect, solution.findRestaurant(input1, input2));
    }
}