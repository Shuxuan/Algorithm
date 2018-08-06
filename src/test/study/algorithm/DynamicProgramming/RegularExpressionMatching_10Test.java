package test.study.algorithm.DynamicProgramming;

import main.study.algorithm.DynamicProgramming.RegularExpressionMatching_10;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionMatching_10Test {

    @Test
    void isMatch1() {
        String s = "aa";
        String p = "a";

        RegularExpressionMatching_10 myObj = new RegularExpressionMatching_10();
        boolean rst = myObj.isMatch(s, p);
        System.out.println(rst);
        assertEquals(false, rst);
    }

    @Test
    void isMatch2() {
        String s = "aa";
        String p = "a*";

        RegularExpressionMatching_10 myObj = new RegularExpressionMatching_10();
        boolean rst = myObj.isMatch(s, p);
        System.out.println(rst);
        assertEquals(true, rst);
    }

    @Test
    void isMatch3() {
        String s = "ab";
        String p = ".*";

        RegularExpressionMatching_10 myObj = new RegularExpressionMatching_10();
        boolean rst = myObj.isMatch(s, p);
        System.out.println(rst);
        assertEquals(true, rst);
    }

    @Test
    void isMatch4() {
        String s = "aab";
        String p = "c*a*b";

        RegularExpressionMatching_10 myObj = new RegularExpressionMatching_10();
        boolean rst = myObj.isMatch(s, p);
        System.out.println(rst);
        assertEquals(false, rst);
    }

    @Test
    void isMatch5() {
        String s = "mississippi";
        String p = "mis*is*p*.";

        RegularExpressionMatching_10 myObj = new RegularExpressionMatching_10();
        boolean rst = myObj.isMatch(s, p);
        System.out.println(rst);
        assertEquals(false, rst);
    }
}