package test.study.algorithm.DynamicProgramming;

import main.study.algorithm.DynamicProgramming.DecodeWays_91;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecodeWays_91Test {

    @Test
    void numberDecoding() {
            String s = "226";
            DecodeWays_91 myObj = new DecodeWays_91();
            int rst = myObj.numDecodings(s);
            System.out.println(rst);
            assertEquals(3, rst);
    }

    @Test
    void numberDecoding2() {
        String s = "12";
        DecodeWays_91 myObj = new DecodeWays_91();
        int rst = myObj.numDecodings(s);
        System.out.println(rst);
        assertEquals(2, rst);
    }

    @Test
    void numberDecoding3() {
        String s = "0";
        DecodeWays_91 myObj = new DecodeWays_91();
        int rst = myObj.numDecodings(s);
        System.out.println(rst);
        assertEquals(0, rst);
    }
}