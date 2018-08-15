package test.study.algorithm.DynamicProgramming;

import main.study.algorithm.DynamicProgramming.BestTimetoBuyandSellStockwithCooldown_309;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimetoBuyandSellStockwithCooldown_309Test {

    @Test
    void maxProfit() {
        int[] nums = {1,2,3,0,2};
        BestTimetoBuyandSellStockwithCooldown_309 myObj = new BestTimetoBuyandSellStockwithCooldown_309();
        int rst = myObj.maxProfit(nums);

        System.out.println(rst);
        assertEquals(3, rst);
    }

    @Test
    void maxProfit2() {
        int[] nums = {1,2,4};
        BestTimetoBuyandSellStockwithCooldown_309 myObj = new BestTimetoBuyandSellStockwithCooldown_309();
        int rst = myObj.maxProfit(nums);

        System.out.println(rst);
        assertEquals(3, rst);
    }

    @Test
    void maxProfit3() {
        int[] nums = {2,1};
        BestTimetoBuyandSellStockwithCooldown_309 myObj = new BestTimetoBuyandSellStockwithCooldown_309();
        int rst = myObj.maxProfit(nums);

        System.out.println(rst);
        assertEquals(0, rst);
    }

    @Test
    void maxProfit4() {
        int[] nums = {1,2};
        BestTimetoBuyandSellStockwithCooldown_309 myObj = new BestTimetoBuyandSellStockwithCooldown_309();
        int rst = myObj.maxProfit(nums);

        System.out.println(rst);
        assertEquals(1, rst);
    }



}