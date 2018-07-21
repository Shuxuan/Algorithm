package test.study.algorithm.Array;

import main.study.algorithm.Array.FindMinimuminRotatedSortedArrayII_154;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinimuminRotatedSortedArrayII_154Test {

    @Test
    void findMin() {

        int[] nums = {4,5,6,7,0,1,2};
        FindMinimuminRotatedSortedArrayII_154 myclass = new FindMinimuminRotatedSortedArrayII_154();
        int rst = myclass.findMin(nums);
        int expected = 0;
        assertEquals(expected, rst);
    }

    @Test
    void findMin1() {
        int[] nums = {1,3,5};
        FindMinimuminRotatedSortedArrayII_154 myclass = new FindMinimuminRotatedSortedArrayII_154();
        int rst = myclass.findMin(nums);
        int expected = 1;
        assertEquals(expected, rst);
    }

    @Test
    void findMin2() {
        int[] nums = {2,2,2,0,1};
        FindMinimuminRotatedSortedArrayII_154 myclass = new FindMinimuminRotatedSortedArrayII_154();
        int rst = myclass.findMin(nums);
        int expected = 0;
        assertEquals(expected, rst);
    }
}