package test.study.algorithm.Array;

import main.study.algorithm.Array.SearchinRotatedSortedArrayII_81;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchinRotatedSortedArrayII_81Test {

    @Test
    void search1() {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        boolean expected = true;

        SearchinRotatedSortedArrayII_81 myclass = new SearchinRotatedSortedArrayII_81();
        boolean rst = myclass.search(nums, target);
        assertEquals(expected, rst);
    }


    @Test
    void search2() {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 3;
        boolean expected = false;

        SearchinRotatedSortedArrayII_81 myclass = new SearchinRotatedSortedArrayII_81();
        boolean rst = myclass.search(nums, target);
        assertEquals(expected, rst);
    }

}