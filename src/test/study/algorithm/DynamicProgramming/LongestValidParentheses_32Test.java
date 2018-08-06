package test.study.algorithm.DynamicProgramming;

import main.study.algorithm.DynamicProgramming.LongestValidParentheses_32;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestValidParentheses_32Test {

    @Test
    void longestValidParentheses() {
        String s = "(()";
        LongestValidParentheses_32 myObj = new LongestValidParentheses_32();
        int rst = myObj.longestValidParentheses(s);

        System.out.println(rst);
        assertEquals(2, rst);
    }

    @Test
    void longestValidParentheses2() {
        String s = ")()())";
        LongestValidParentheses_32 myObj = new LongestValidParentheses_32();
        int rst = myObj.longestValidParentheses(s);

        System.out.println(rst);
        assertEquals(4, rst);
    }

    @Test
    void longestValidParentheses3() {
        String s = "()(())";
        LongestValidParentheses_32 myObj = new LongestValidParentheses_32();
        int rst = myObj.longestValidParentheses(s);

        System.out.println(rst);
        assertEquals(6, rst);
    }

    @Test
    void longestValidParentheses4() {
        String s = "(())";
        LongestValidParentheses_32 myObj = new LongestValidParentheses_32();
        int rst = myObj.longestValidParentheses(s);

        System.out.println(rst);
        assertEquals(4, rst);
    }

    @Test
    void longestValidParentheses5() {
        String s = "()()";
        LongestValidParentheses_32 myObj = new LongestValidParentheses_32();
        int rst = myObj.longestValidParentheses(s);

        System.out.println(rst);
        assertEquals(4, rst);
    }

    @Test
    void longestValidParentheses6() {
        String s = ")(((((()())()()))()(()))(";
        LongestValidParentheses_32 myObj = new LongestValidParentheses_32();
        int rst = myObj.longestValidParentheses(s);

        System.out.println(rst);
        assertEquals(22, rst);
    }

    @Test
    void longestValidParentheses7() {
        String s = ")()(((())))(";
        LongestValidParentheses_32 myObj = new LongestValidParentheses_32();
        int rst = myObj.longestValidParentheses(s);

        System.out.println(rst);
        assertEquals(10, rst);
    }

    @Test
    void longestValidParentheses8() {
        String s = "(()()(())((";
        LongestValidParentheses_32 myObj = new LongestValidParentheses_32();
        int rst = myObj.longestValidParentheses(s);

        System.out.println(rst);
        assertEquals(8, rst);
    }
}