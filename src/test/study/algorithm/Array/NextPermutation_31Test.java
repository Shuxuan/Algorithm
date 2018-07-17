package test.study.algorithm.Array;

import main.study.algorithm.Array.NextPermutation_31;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NextPermutation_31Test {

    @Test
    void nextPermutation() {
        int[] nums = {1,2,3};
        NextPermutation_31 myclass = new NextPermutation_31();
        myclass.nextPermutation(nums);
        List<Integer> expected = Arrays.asList(1,3,2);
        List<Integer> rst = Arrays.asList(nums[0], nums[1], nums[2]);
        assertEquals(expected, rst);
    }

    @Test
    void nextPermutation1() {

        int[] nums = {1,5,8,4,7,6,5,4,3,1};
        NextPermutation_31 myclass = new NextPermutation_31();
        myclass.nextPermutation(nums);
        List<Integer> expected = Arrays.asList(1, 5, 8, 5, 1, 3, 4, 4, 6, 7);
        List<Integer> rst = new ArrayList<>();
        for (int item : nums) {
            rst.add(item);
        }
        assertEquals(expected, rst);
    }

    @Test
    void nextPermutation3() {
        int[] nums = {1,1};
        NextPermutation_31 myclass = new NextPermutation_31();
        myclass.nextPermutation(nums);
        List<Integer> expected = Arrays.asList(1,1);
        List<Integer> rst = Arrays.asList(nums[0], nums[1]);
        assertEquals(expected, rst);
    }

    @Test
    void nextPermutation4() {
        int[] nums = {1,1};
        NextPermutation_31 myclass = new NextPermutation_31();
        myclass.nextPermutation(nums);
        List<Integer> expected = Arrays.asList(1);
        List<Integer> rst = Arrays.asList(nums[0]);
        assertEquals(expected, rst);
    }

    @Test
    void nextPermutation5() {

        int[] nums = {1,3,2};
        NextPermutation_31 myclass = new NextPermutation_31();
        myclass.nextPermutation(nums);
        List<Integer> expected = Arrays.asList(2,1,3);
        List<Integer> rst = new ArrayList<>();
        for (int item : nums) {
            rst.add(item);
        }
        assertEquals(expected, rst);
    }


    @Test
    void nextPermutation6() {

        int[] nums = {3,2,1};
        NextPermutation_31 myclass = new NextPermutation_31();
        myclass.nextPermutation(nums);
        List<Integer> expected = Arrays.asList(1,2,3);
        List<Integer> rst = new ArrayList<>();
        for (int item : nums) {
            rst.add(item);
        }
        assertEquals(expected, rst);
    }

    @Test
    void nextPermutation7() {

        int[] nums = {2,3,1,3,3};
        NextPermutation_31 myclass = new NextPermutation_31();
        myclass.nextPermutation(nums);
        List<Integer> expected = Arrays.asList(2,3,3,1,3);
        List<Integer> rst = new ArrayList<>();
        for (int item : nums) {
            rst.add(item);
        }
        assertEquals(expected, rst);
    }
}