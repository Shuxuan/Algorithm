package test.study.algorithm.DynamicProgramming;

import main.study.algorithm.DynamicProgramming.HouseRobber_198;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobber_198Test {

    @Test
    void rob() {
        int[] nums = {1,2,3,1};
        HouseRobber_198 myObj = new HouseRobber_198();
        int rst = myObj.rob(nums);
        System.out.println(rst);
        assertEquals(4, rst);
    }

    @Test
    void rob2() {
        int[] nums = {2,7,9,3,1};
        HouseRobber_198 myObj = new HouseRobber_198();
        int rst = myObj.rob(nums);
        System.out.println(rst);
        assertEquals(12, rst);
    }
}