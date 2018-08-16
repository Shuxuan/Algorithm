package test.study.algorithm.DynamicProgramming;

import main.study.algorithm.DynamicProgramming.RussianDollEnvelopes_354;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RussianDollEnvelopes_354Test {

    @Test
    void maxEnvelopes() {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};

        RussianDollEnvelopes_354 myObj = new RussianDollEnvelopes_354();
        int rst = myObj.maxEnvelopes(envelopes);
        System.out.println(rst);
        assertEquals(3, rst);
    }

    @Test
    void maxEnvelopes2() {
        int[][] envelopes = {{10,8},{1,12},{6,15},{2,18}};

        RussianDollEnvelopes_354 myObj = new RussianDollEnvelopes_354();
        int rst = myObj.maxEnvelopes(envelopes);
        System.out.println(rst);
        assertEquals(2, rst);
    }
}