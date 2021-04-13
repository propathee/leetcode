package com.leetcode.leetcode_117_Populating_Next_Right_Pointers_in_Each_Node_II_Medium;

import com.leetcode.utils.Node;
import org.junit.Test;

import static com.leetcode.utils.NodeTests.*;
import static org.junit.Assert.*;

public class Solution117Tests {
    private Solution117 solution = Solution117.newSolution();

    @Test
    public void should_pass_1() {
        Node root = makeRightNeighbourUnconnectedTree(1,2,3,4,5,null,7);
        Node expect = makeRightNeighbourConnectedTree(1,2,3,4,5,null,7);
        assertRightNeighbourConnectedTreeEquals(expect, solution.connect(root));
    }
}