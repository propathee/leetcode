package com.leetcode.leetcode_824_Goat_Latin_Easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution824Tests {
    private Solution824 solution = Solution824.newSolution();

    @Test
    public void should_pass_1() {
        String input = "I speak Goat Latin";
        String output = "Imaa peaksmaaa oatGmaaaa atinLmaaaaa";
        assertEquals(output, solution.toGoatLatin(input));
    }

    @Test
    public void should_pass_2() {
        String input = "The quick brown fox jumped over the lazy dog";
        String output = "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa";
        assertEquals(output, solution.toGoatLatin(input));
    }

    @Test
    public void should_pass_3() {
        String input = "Each word consists of lowercase and uppercase letters only";
        String output = "Eachmaa ordwmaaa onsistscmaaaa ofmaaaaa owercaselmaaaaaa andmaaaaaaa uppercasemaaaaaaaa etterslmaaaaaaaaa onlymaaaaaaaaaa";
        assertEquals(output, solution.toGoatLatin(input));
    }
}