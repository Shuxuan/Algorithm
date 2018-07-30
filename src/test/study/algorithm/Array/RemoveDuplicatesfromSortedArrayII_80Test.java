package test.study.algorithm.Array;

import main.study.algorithm.Array.RemoveDuplicatesfromSortedArrayII_80;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RemoveDuplicatesfromSortedArrayII_80Test {

    @Test
    void removeDuplicates() {
        int[] nums = {1,1,1,2,2,3};
        RemoveDuplicatesfromSortedArrayII_80 myObj = new RemoveDuplicatesfromSortedArrayII_80();
        myObj.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    void removeDuplicates2() {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        RemoveDuplicatesfromSortedArrayII_80 myObj = new RemoveDuplicatesfromSortedArrayII_80();
        myObj.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}