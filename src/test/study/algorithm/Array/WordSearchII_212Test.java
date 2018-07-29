package test.study.algorithm.Array;

import main.study.algorithm.Array.WordSearchII_212;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchII_212Test {

    @Test
    void findWords() {

        char[][] board =
                {
                        {'o','a','a','n'},
                        {'e','t','a','e'},
                        {'i','h','k','r'},
                        {'i','f','l','v'}

                };

        String[] words = {"oath","pea","eat","rain"};

        WordSearchII_212 myObj = new WordSearchII_212();
        List<String> rst = myObj.findWords(board, words);
        System.out.println(Arrays.toString(rst.toArray()));
    }

    @Test
    void findWords2() {

        char[][] board =
                {
                        {'a'}

                };

        String[] words = {"a","a","a","a"};

        Set<String> set = new HashSet<String>(Arrays.asList(words));
        System.out.println(Arrays.toString(set.toArray()));

        WordSearchII_212 myObj = new WordSearchII_212();
        List<String> rst = myObj.findWords(board, words);
        System.out.println(Arrays.toString(rst.toArray()));
    }

}