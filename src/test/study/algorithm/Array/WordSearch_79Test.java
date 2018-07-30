package test.study.algorithm.Array;

import main.study.algorithm.Array.WordSearch_79;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordSearch_79Test {

    @Test
    void exist() {

        char[][]  board =
                {
                        {'A','B','C','E'},
                        {'S','F','C','S'},
                        {'A','D','E','E'}
                };

        String word = "ABCCED";
        WordSearch_79 myObj = new WordSearch_79();

        System.out.println(myObj.exist(board,"ABCB"));
    }

    @Test
    void exist2() {

        char[][]  board =
                {
                        {'C','A','A'},
                        {'A','A','A'},
                        {'B','C','D'}
                };

        String word = "AAB";
        WordSearch_79 myObj = new WordSearch_79();

        System.out.println(myObj.exist(board,word));
    }
}