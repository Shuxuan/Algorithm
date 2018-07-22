package test.study.algorithm.Array;

import main.study.algorithm.Array.FirstMissingPositive_41;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstMissingPositive_41Test {

    @Test
    void firstMissingPositive1() {

        int[] nums = {1,2,0};
        FirstMissingPositive_41 mytest = new FirstMissingPositive_41();
        int rst = mytest.firstMissingPositive(nums);
        System.out.println(rst);
        int expected = 3;
        assertEquals(expected, rst);
    }

    @Test
    void firstMissingPositive2() {

        int[] nums = {3,4,-1,1};
        FirstMissingPositive_41 mytest = new FirstMissingPositive_41();
        int rst = mytest.firstMissingPositive(nums);
        System.out.println(rst);
        int expected = 2;
        assertEquals(expected, rst);
    }

    @Test
    void firstMissingPositive3() {

        int[] nums = {7,8,9,11,12};
        FirstMissingPositive_41 mytest = new FirstMissingPositive_41();
        int rst = mytest.firstMissingPositive(nums);
        System.out.println(rst);
        int expected = 1;
        assertEquals(expected, rst);
    }

    @Test
    void firstMissingPositive4() {

        int[] nums = {1,1};
        FirstMissingPositive_41 mytest = new FirstMissingPositive_41();
        int rst = mytest.firstMissingPositive(nums);
        System.out.println(rst);
        int expected = 2;
        assertEquals(expected, rst);
    }
}