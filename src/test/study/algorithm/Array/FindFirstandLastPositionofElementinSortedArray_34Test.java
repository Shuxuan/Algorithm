package test.study.algorithm.Array;

import main.study.algorithm.Array.FindFirstandLastPositionofElementinSortedArray_34;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FindFirstandLastPositionofElementinSortedArray_34Test {

    @Test
    void searchRange1() {

        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        FindFirstandLastPositionofElementinSortedArray_34 myclass = new FindFirstandLastPositionofElementinSortedArray_34();
        int[] rst = myclass.searchRange(nums, target);
        assertEquals(Arrays.asList(3,4), Arrays.asList(rst[0], rst[1]));
    }

    @Test
    void searchRange2() {

        int[] nums = {0,0,0,0,0};
        int target = 0;
        FindFirstandLastPositionofElementinSortedArray_34 myclass = new FindFirstandLastPositionofElementinSortedArray_34();
        int[] rst = myclass.searchRange(nums, target);
        assertEquals(Arrays.asList(0,4), Arrays.asList(rst[0], rst[1]));
    }
}