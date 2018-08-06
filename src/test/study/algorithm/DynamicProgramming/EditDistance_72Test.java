package test.study.algorithm.DynamicProgramming;

import main.study.algorithm.DynamicProgramming.EditDistance_72;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EditDistance_72Test {

    @Test
    void minDistance1() {
        String word1 = "horse";
        String word2 = "ros";
        EditDistance_72 myObj = new EditDistance_72();
        int rst = myObj.minDistance(word1, word2);

        System.out.println(rst);

        assertEquals(3,rst);
    }

    @Test
    void minDistance2() {
        String word1 = "intention";
        String word2 = "execution";
        EditDistance_72 myObj = new EditDistance_72();
        int rst = myObj.minDistance(word1, word2);

        System.out.println(rst);

        assertEquals(5,rst);
    }

    @Test
    void minDistance3() {
        String word1 = "zoologicoarchaeologist";
        String word2 = "zoogeologist";
        EditDistance_72 myObj = new EditDistance_72();
        int rst = myObj.minDistance(word1, word2);

        System.out.println(rst);

        assertEquals(10,rst);
    }

}