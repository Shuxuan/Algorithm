package test.study.algorithm.Array;

import main.study.algorithm.Array.TrappingRainWater_42;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainWater_42Test {

    @Test
    void trap() {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        TrappingRainWater_42 mytest = new TrappingRainWater_42();
        int rst = mytest.trap(nums);
        System.out.println(rst);
        int expected = 6;
        assertEquals(expected, rst);
    }

    @Test
    void trap2() {
        int[] nums = {4,2,3};
        TrappingRainWater_42 mytest = new TrappingRainWater_42();
        int rst = mytest.trap(nums);
        System.out.println(rst);
        int expected = 1;
        assertEquals(expected, rst);
    }
}