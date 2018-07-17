package test.study.algorithm.Array;

import main.study.algorithm.Array.ThreeSum_15;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSum_15Test {

    @Test
    void threeSum1() {

        /*
        test case 1
         */
        int[] nums = {-1, 0, 1, 2, -1, -4};

        ThreeSum_15 threeSum = new ThreeSum_15();
        List<List<Integer>> rst = threeSum.threeSum(nums);
        assertEquals(2, rst.size());
        List<Integer> ans1 = Arrays.asList(-1, -1, 2);
        assertEquals(ans1, rst.get(0));
        List<Integer> ans2 = Arrays.asList(-1, 0, 1);
        assertEquals(ans2, rst.get(1));

    }

    @Test
    void threeSum2() {



        ThreeSum_15 threeSum = new ThreeSum_15();

        /*
        test case 2
         */

        int[] nums2 = {0,0,0,0};
        List<List<Integer>> rst2 = threeSum.threeSum(nums2);

        assertEquals(1, rst2.size());
        assertEquals(Arrays.asList(0,0,0), rst2.get(0));

    }

    @Test
    void threeSum3() {


        ThreeSum_15 threeSum = new ThreeSum_15();


        /*
        test case 3
         */
        int[] nums3 = {1,-1,-1,0};
        List<List<Integer>> rst3 = threeSum.threeSum(nums3);

        assertEquals(1, rst3.size());
        assertEquals(Arrays.asList(-1,0,1), rst3.get(0));

    }

    @Test
    void threeSum4() {



        ThreeSum_15 threeSum = new ThreeSum_15();


        /*
        test case 4
         */

        int[] nums4 = {-2,-4,-2};
        List<List<Integer>> rst4 = threeSum.threeSum(nums4);
        assertEquals(0, rst4.size());
    }

}