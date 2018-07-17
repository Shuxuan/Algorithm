package test.study.algorithm.Array;

import main.study.algorithm.Array.RemoveDuplicatesfromSortedArray_26;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesfromSortedArray_26Test {

    @Test
    void removeDuplicates() {
        int[] nums = {1, 1, 2};
        RemoveDuplicatesfromSortedArray_26 myclass = new RemoveDuplicatesfromSortedArray_26();
        int rst = myclass.removeDuplicates(nums);
        assertEquals(2, rst);
    }

    @Test
    void removeDuplicates1() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesfromSortedArray_26 myclass = new RemoveDuplicatesfromSortedArray_26();
        int rst = myclass.removeDuplicates(nums);
        assertEquals(5, rst);
    }
}