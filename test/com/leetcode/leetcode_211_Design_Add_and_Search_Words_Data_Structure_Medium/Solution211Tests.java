package com.leetcode.leetcode_211_Design_Add_and_Search_Words_Data_Structure_Medium;

import org.junit.Test;
import com.leetcode.leetcode_211_Design_Add_and_Search_Words_Data_Structure_Medium.Solution211.WordDictionary;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Solution211Tests {
    private WordDictionary dict = Solution211.newDictionary();

    @Test
    public void should_pass_1() {
        List<String> methods = Arrays.asList("addWord","addWord","addWord","search","search","search","search");
        List<String> args = Arrays.asList("bad","dad","mad","pad","bad",".ad","b..");
        List<Boolean> outputs = Arrays.asList(null,null,null,false,true,true,true);

        assertEquals(methods.size(), args.size());
        assertEquals(methods.size(), outputs.size());

        for (int i = 0; i < methods.size(); i++) {
            String method = methods.get(i);
            String word = args.get(i);

            System.out.println(method + "(" + word + ")");
            if ("addWord".equals(method)) {
                dict.addWord(word);
            } else {
                assertEquals(outputs.get(i), dict.search(word));
            }
        }
    }
}