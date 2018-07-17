package test.study.algorithm.Array;

import main.study.algorithm.Array.FourSumII_454;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FourSumII_454Test {

    @Test
    void fourSumCount1() {

        int[] A = {1,2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        FourSumII_454 myclass = new FourSumII_454();
        int rst = myclass.fourSumCount(A, B, C, D);
        assertEquals(2, rst);
    }

    @Test
    void fourSumCount2() {

        int[] A = {-1, -1};
        int[] B = {-1, 1};
        int[] C = {-1, 1};
        int[] D = {1, -1};

        FourSumII_454 myclass = new FourSumII_454();
        int rst = myclass.fourSumCount(A, B, C, D);
        assertEquals(6, rst);


    }

    @Test
    void fourSumCount3() {

        int[] A = {0};
        int[] B = {0};
        int[] C = {0};
        int[] D = {0};

        FourSumII_454 myclass = new FourSumII_454();
        int rst = myclass.fourSumCount(A, B, C, D);
        assertEquals(1, rst);


    }
}