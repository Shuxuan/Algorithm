package test.study.algorithm.DynamicProgramming;

import main.study.algorithm.DynamicProgramming.CoinChange_322;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChange_322Test {

    @Test
    void coinChange() {
        int[] coins = {1,2,5};
        int amount = 11;

        CoinChange_322 myObj = new CoinChange_322();
        int rst = myObj.coinChange(coins, amount);

        System.out.println(rst);

        assertEquals(3, rst);
    }

    @Test
    void coinChange2() {
        int[] coins = {2};
        int amount = 3;

        CoinChange_322 myObj = new CoinChange_322();
        int rst = myObj.coinChange(coins, amount);

        System.out.println(rst);

        assertEquals(-1, rst);
    }
}