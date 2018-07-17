package test.study.algorithm.Array;

import main.study.algorithm.Array.FourSum_18;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FourSum_18Test {

    @Test
    void fourSum() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        FourSum_18 fourSum_18 = new FourSum_18();
        List<List<Integer>> rst = fourSum_18.fourSum(nums, target);

        assertEquals(3, rst.size());

        assertEquals(Arrays.asList(-2,-1,1,2), rst.get(0));
        assertEquals(Arrays.asList(-2,0,0,2), rst.get(1));
        assertEquals(Arrays.asList(-1,0,0,1), rst.get(2));
    }
}