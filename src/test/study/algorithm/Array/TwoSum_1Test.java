package test.study.algorithm.Array;

import com.sun.tools.javac.util.Assert;
import main.study.algorithm.Array.TwoSum_1;

import static org.junit.jupiter.api.Assertions.assertEquals;


class TwoSum_1Test {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void twoSum() {
        int[] nums = {2,7,11,15};
        int target = 9;

        TwoSum_1 twoSum = new TwoSum_1();
        int[] rst = twoSum.twoSum(nums, target);

        int[] expected = {0,1};

        assertEquals(rst[0], expected[0]);
        assertEquals(rst[1], expected[1]);

        int[] nums2 = {3,3};
        int target2 = 6;
        int[] rst2 = twoSum.twoSum(nums2, target2);
        int[] expected2 = {0,1};

        assertEquals(rst2[0], expected2[0]);
        assertEquals(rst2[1], expected2[1]);
    }
}