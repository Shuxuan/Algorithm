package test.study.algorithm.Array;

import main.study.algorithm.Array.TwoSumII_167;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumII_167Test {

    @Test
    void twoSum() {
        TwoSumII_167 twoSum = new TwoSumII_167();
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] expected = {0,1};

        int[] rst = twoSum.twoSum(nums, target);

        assertEquals(rst[0], expected[0]);
        assertEquals(rst[1], expected[1]);
    }
}