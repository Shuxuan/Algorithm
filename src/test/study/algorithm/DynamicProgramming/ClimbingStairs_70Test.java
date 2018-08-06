package test.study.algorithm.DynamicProgramming;

import main.study.algorithm.DynamicProgramming.ClimbingStairs_70;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairs_70Test {

    @Test
    void climbStairs() {
        int n = 2;
        ClimbingStairs_70 myObj = new ClimbingStairs_70();
        int rst = myObj.climbStairs(n);
        System.out.println(rst);
        assertEquals(2, rst);
    }

    @Test
    void climbStairs2() {
        int n = 3;
        ClimbingStairs_70 myObj = new ClimbingStairs_70();
        int rst = myObj.climbStairs(n);
        System.out.println(rst);
        assertEquals(3, rst);
    }
}