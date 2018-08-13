package test.study.algorithm.DynamicProgramming;

import main.study.algorithm.DynamicProgramming.MaximumProductSubarray_152;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumProductSubarray_152Test {

    @Test
    void maxProduct() {
        int[] nums = {2,3,-2,4};
        MaximumProductSubarray_152 myObj = new MaximumProductSubarray_152();
        int rst = myObj.maxProduct(nums);
        System.out.println(rst);
        assertEquals(6, rst);
    }

    @Test
    void maxProduct2() {
        int[] nums = {-2,0,-1};
        MaximumProductSubarray_152 myObj = new MaximumProductSubarray_152();
        int rst = myObj.maxProduct(nums);
        System.out.println(rst);
        assertEquals(0, rst);
    }

    @Test
    void maxProduct3() {
        int[] nums = {-2,3,-4};
        MaximumProductSubarray_152 myObj = new MaximumProductSubarray_152();
        int rst = myObj.maxProduct(nums);
        System.out.println(rst);
        assertEquals(24, rst);
    }
}