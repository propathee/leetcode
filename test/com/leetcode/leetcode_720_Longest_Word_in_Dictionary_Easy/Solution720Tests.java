package com.leetcode.leetcode_720_Longest_Word_in_Dictionary_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution720Tests {
    private Solution720 solution = Solution720.newSolution();

    @Test
    public void should_pass_1() {
        String[] words = {"w","wo","wor","worl", "world"};
        assertEquals("world", solution.longestWord(words));
    }

    @Test
    public void should_pass_2() {
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        assertEquals("apple", solution.longestWord(words));
    }

    @Test
    public void should_pass_3() {
        String[] words = {"a", "b", "app"};
        assertEquals("a", solution.longestWord(words));
    }

    @Test
    public void should_pass_4() {
        String[] words = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        assertEquals("yodn", solution.longestWord(words));
    }

    @Test
    public void should_pass_5() {
        String[] words = {"ts","e","x","pbhj","opto","xhigy","erikz","pbh","opt","erikzb","eri","erik","xlye","xhig","optoj","optoje","xly","pb","xhi","x","o"};
        assertEquals("e", solution.longestWord(words));
    }

    @Test
    public void should_pass_6() {
        String[] words = {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
        assertEquals("latte", solution.longestWord(words));
    }

    @Test
    public void print() {
        System.out.println((char) ('z' + 1));
    }
}