package main.company.fb;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {



    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty()) return true;
        for(String word : wordDict) {
            if (s.startsWith(word) && wordBreak(s.substring(word.length()), wordDict))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        String s = "leetcode";

        WordBreak myObj = new WordBreak();
        System.out.println(myObj.wordBreak(s, wordDict));


    }
}
