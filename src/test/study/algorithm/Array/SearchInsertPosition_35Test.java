package test.study.algorithm.Array;

import main.study.algorithm.Array.SearchInsertPosition_35;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 */

class SearchInsertPosition_35Test {

    @Test
    void searchInsert1() {
        int[] nums = {1,3,5,6};
        int target = 5;
        SearchInsertPosition_35 myclass = new SearchInsertPosition_35();
        int rst = myclass.searchInsert(nums, target);
        int expected = 2;
        assertEquals(expected, rst);
    }

    @Test
    void searchInsert2() {
        int[] nums = {1,3,5,6};
        int target = 2;
        SearchInsertPosition_35 myclass = new SearchInsertPosition_35();
        int rst = myclass.searchInsert(nums, target);
        int expected = 1;
        assertEquals(expected, rst);
    }

    @Test
    void searchInsert3() {
        int[] nums = {1,3,5,6};
        int target = 7;
        SearchInsertPosition_35 myclass = new SearchInsertPosition_35();
        int rst = myclass.searchInsert(nums, target);
        int expected = 4;
        assertEquals(expected, rst);
    }

    @Test
    void searchInsert4() {
        int[] nums = {1,3,5,6};
        int target = 0;
        SearchInsertPosition_35 myclass = new SearchInsertPosition_35();
        int rst = myclass.searchInsert(nums, target);
        int expected = 0;
        assertEquals(expected, rst);
    }

    @Test
    void searchInsert5() {
        int[] nums = {1,3};
        int target = 2;
        SearchInsertPosition_35 myclass = new SearchInsertPosition_35();
        int rst = myclass.searchInsert(nums, target);
        int expected = 1;
        assertEquals(expected, rst);
    }
}