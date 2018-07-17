package test.study.algorithm.Array;

import main.study.algorithm.Array.ThreeSumClosest_16;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreeSumClosest_16Test {

    @Test
    void threeSumClosest1() {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        ThreeSumClosest_16 threeSumClosest_16 = new ThreeSumClosest_16();
        int rst = threeSumClosest_16.threeSumClosest(nums, target);
        assertEquals(2, rst);
    }

    @Test
    void threeSumClosest2() {
        int[] nums = {-3, -2, -5, 3,-4};
        int target = -1;

        ThreeSumClosest_16 threeSumClosest_16 = new ThreeSumClosest_16();
        int rst = threeSumClosest_16.threeSumClosest(nums, target);
        assertEquals(-2, rst);
    }
}