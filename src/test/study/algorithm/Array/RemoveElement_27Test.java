package test.study.algorithm.Array;

import main.study.algorithm.Array.RemoveElement_27;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveElement_27Test {

    @Test
    void removeElement() {
        int[] nums = {3,2,2,3};
        int val = 3;
        RemoveElement_27 myclass = new RemoveElement_27();
        int rst = myclass.removeElement(nums, val);
        assertEquals(2, rst);
    }

    @org.junit.jupiter.api.Test
    void removeElement1() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        RemoveElement_27 myclass = new RemoveElement_27();
        int rst = myclass.removeElement(nums, val);
        assertEquals(5, rst);
    }
}