package test.study.algorithm.Array;

import main.study.algorithm.Array.JumpGame_55;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpGame_55Test {

    @Test
    void canJump() {

        int[] nums = {2,3,1,1,4};
        JumpGame_55 myObject = new JumpGame_55();
        boolean rst = myObject.canJump(nums);
        System.out.println(rst);
        boolean expected = true;
        assertEquals(expected,rst);
    }

    @Test
    void canJump2() {

        int[] nums = {3,2,1,0,4};
        JumpGame_55 myObject = new JumpGame_55();
        boolean rst = myObject.canJump(nums);
        System.out.println(rst);
        boolean expected = false;
        assertEquals(expected, rst);
    }
}