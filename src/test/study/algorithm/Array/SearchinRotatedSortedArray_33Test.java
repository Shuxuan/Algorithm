package test.study.algorithm.Array;

import main.study.algorithm.Array.SearchinRotatedSortedArray_33;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchinRotatedSortedArray_33Test {

    @Test
    void search1() {

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        SearchinRotatedSortedArray_33 myclass = new SearchinRotatedSortedArray_33();
        int rst = myclass.search(nums, target);
        int expected = 4;
        assertEquals(expected, rst);
    }

    @Test
    void search2() {

        int[] nums = {4,5,6,7,0,1,2};
        int target = 3;
        SearchinRotatedSortedArray_33 myclass = new SearchinRotatedSortedArray_33();
        int rst = myclass.search(nums, target);
        int expected = -1;
        assertEquals(expected, rst);
    }

    @Test
    void search3() {

        int[] nums = {1,3};
        int target = 2;
        SearchinRotatedSortedArray_33 myclass = new SearchinRotatedSortedArray_33();
        int rst = myclass.search(nums, target);
        int expected = -1;
        assertEquals(expected, rst);
    }

    @Test
    void search4() {

        int[] nums = {3,1};
        int target = 1;
        SearchinRotatedSortedArray_33 myclass = new SearchinRotatedSortedArray_33();
        int rst = myclass.search(nums, target);
        int expected = 1;
        assertEquals(expected, rst);
    }
}