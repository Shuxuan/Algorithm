package test.study.algorithm.DynamicProgramming;

import main.study.algorithm.DynamicProgramming.WildcardMatching_44;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WildcardMatching_44Test {

    @Test
    void isMatch1() {

        String s = "aa";
        String p = "a";

        WildcardMatching_44 myObj = new WildcardMatching_44();

        boolean rst = myObj.isMatch(s, p);
        System.out.println(rst);
        assertEquals(false, rst);
    }

    @Test
    void isMatch2() {

        String s = "aa";
        String p = "a*";

        WildcardMatching_44 myObj = new WildcardMatching_44();

        boolean rst = myObj.isMatch(s, p);
        System.out.println(rst);
        assertEquals(true, rst);
    }

    @Test
    void isMatch3() {

        String s = "cb";
        String p = "?a";

        WildcardMatching_44 myObj = new WildcardMatching_44();

        boolean rst = myObj.isMatch(s, p);
        System.out.println(rst);
        assertEquals(false, rst);
    }

    @Test
    void isMatch4() {

        String s = "adceb";
        String p = "*a*b";

        WildcardMatching_44 myObj = new WildcardMatching_44();

        boolean rst = myObj.isMatch(s, p);
        System.out.println(rst);
        assertEquals(true, rst);
    }

    @Test
    void isMatch5() {

        String s = "acdcb";
        String p = "a*c?b";

        WildcardMatching_44 myObj = new WildcardMatching_44();

        boolean rst = myObj.isMatch(s, p);
        System.out.println(rst);

        assertEquals(false, rst);
    }

    @Test
    void isMatch6() {

        String s = "a";
        String p = "";

        WildcardMatching_44 myObj = new WildcardMatching_44();

        boolean rst = myObj.isMatch(s, p);
        System.out.println(rst);

        assertEquals(false, rst);
    }

    @Test
    void isMatch7() {

        String s = "";
        String p = "*";

        WildcardMatching_44 myObj = new WildcardMatching_44();

        boolean rst = myObj.isMatch(s, p);
        System.out.println(rst);

        assertEquals(true, rst);
    }

}