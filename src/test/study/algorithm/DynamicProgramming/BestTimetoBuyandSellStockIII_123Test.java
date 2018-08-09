package test.study.algorithm.DynamicProgramming;

import main.study.algorithm.DynamicProgramming.BestTimetoBuyandSellStockIII_123;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimetoBuyandSellStockIII_123Test {

    @Test
    void maxProfit() {
        int[] nums = {3,3,5,0,0,3,1,4};
        BestTimetoBuyandSellStockIII_123 myObj = new BestTimetoBuyandSellStockIII_123();
        int rst = myObj.maxProfit(nums);
        System.out.println(rst);
        assertEquals(6, rst);
    }

    @Test
    void maxProfit2() {
        int[] nums = {1,2,3,4,5};
        BestTimetoBuyandSellStockIII_123 myObj = new BestTimetoBuyandSellStockIII_123();
        int rst = myObj.maxProfit(nums);
        System.out.println(rst);
        assertEquals(4, rst);
    }

    @Test
    void maxProfit3() {
        int[] nums = {7,6,4,3,1};
        BestTimetoBuyandSellStockIII_123 myObj = new BestTimetoBuyandSellStockIII_123();
        int rst = myObj.maxProfit(nums);
        System.out.println(rst);
        assertEquals(0, rst);
    }

    @Test
    void maxProfit4() {
        int[] nums = {1,2};
        BestTimetoBuyandSellStockIII_123 myObj = new BestTimetoBuyandSellStockIII_123();
        int rst = myObj.maxProfit(nums);
        System.out.println(rst);
        assertEquals(1, rst);
    }
}