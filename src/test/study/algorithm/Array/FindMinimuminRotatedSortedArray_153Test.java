package test.study.algorithm.Array;

import main.study.algorithm.Array.FindMinimuminRotatedSortedArray_153;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinimuminRotatedSortedArray_153Test {

    @Test
    void findMin1() {
        int[] nums = {3,4,5,1,2};
        int expected = 1;
        FindMinimuminRotatedSortedArray_153 myclass = new FindMinimuminRotatedSortedArray_153();
        int rst = myclass.findMin(nums);
        assertEquals(expected, rst);
    }

    @Test
    void findMin2() {
        int[] nums = {4,5,6,7,0,1,2};
        int expected = 0;
        FindMinimuminRotatedSortedArray_153 myclass = new FindMinimuminRotatedSortedArray_153();
        int rst = myclass.findMin(nums);
        assertEquals(expected, rst);
    }

    @Test
    void findMin3() {
        int[] nums = {1,2};
        int expected = 1;
        FindMinimuminRotatedSortedArray_153 myclass = new FindMinimuminRotatedSortedArray_153();
        int rst = myclass.findMin(nums);
        assertEquals(expected, rst);
    }

    @Test
    void findMin4() {
        int[] nums = {2,1};
        int expected = 1;
        FindMinimuminRotatedSortedArray_153 myclass = new FindMinimuminRotatedSortedArray_153();
        int rst = myclass.findMin(nums);
        assertEquals(expected, rst);
    }

    @Test
    void findMin5() {
        int[] nums = {1};
        int expected = 1;
        FindMinimuminRotatedSortedArray_153 myclass = new FindMinimuminRotatedSortedArray_153();
        int rst = myclass.findMin(nums);
        assertEquals(expected, rst);
    }
}