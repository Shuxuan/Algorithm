package test.study.algorithm.DynamicProgramming;

import main.study.algorithm.DynamicProgramming.InterleavingString_97;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterleavingString_97Test {

    @Test
    void isInterleave() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        InterleavingString_97 myObj = new InterleavingString_97();
        boolean rst = myObj.isInterleave(s1, s2,s3);
        System.out.println(rst);
        assertEquals(true, rst);
    }

    @Test
    void isInterleave2() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        InterleavingString_97 myObj = new InterleavingString_97();
        boolean rst = myObj.isInterleave(s1, s2,s3);
        System.out.println(rst);
        assertEquals(false, rst);
    }
}