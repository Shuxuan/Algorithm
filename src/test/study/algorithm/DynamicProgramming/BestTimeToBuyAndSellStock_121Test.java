package test.study.algorithm.DynamicProgramming;

import main.study.algorithm.DynamicProgramming.BestTimeToBuyAndSellStock_121;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStock_121Test {

    @Test
    void maxProfit() {
        int[] nums ={7,1,5,3,6,4};

        BestTimeToBuyAndSellStock_121 myObj = new BestTimeToBuyAndSellStock_121();
        int rst = myObj.maxProfit(nums);

        System.out.println(rst);
        assertEquals(5, rst);
    }

    @Test
    void maxProfit2() {
        int[] nums ={7,6,4,3,1};

        BestTimeToBuyAndSellStock_121 myObj = new BestTimeToBuyAndSellStock_121();
        int rst = myObj.maxProfit(nums);

        System.out.println(rst);
        assertEquals(0, rst);
    }
}