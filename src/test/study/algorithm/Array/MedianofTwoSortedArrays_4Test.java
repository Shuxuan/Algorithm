package test.study.algorithm.Array;

import main.study.algorithm.Array.MedianofTwoSortedArrays_4;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianofTwoSortedArrays_4Test {

    @Test
    void findMedianSortedArrays() {
        int[] nums1 = {1,3};
        int[] nums2 = {2};

        MedianofTwoSortedArrays_4 median = new MedianofTwoSortedArrays_4();
        double rst = median.findMedianSortedArrays(nums1, nums2);
        System.out.println(rst);
        assertEquals(2, rst);
    }
}