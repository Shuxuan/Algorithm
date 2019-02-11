package main.VMWare;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int rst = 0;
        if (beginWord == null || endWord == null || beginWord.equals(endWord)) {
            return rst;
        }

        // BFS
        Queue<String> queue = new LinkedList<>();
        ((LinkedList<String>) queue).push(beginWord);

        while ( !queue.isEmpty()) {
            // BFS
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                String word = queue.poll();
                wordList.remove(word);
                if (word.equals(endWord)) {
                    return rst + 1;
                }

                //探测下一轮可能的词汇
                for (int j = 0; j < word.length(); j++) {
                    char[] charArray = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;
                        String newWord = String.valueOf(charArray);
                        if (wordList.contains(newWord) && wordList.contains(newWord)){
                            queue.add(newWord);
                            wordList.remove(newWord);
                        }
                    }
                }
            }
            rst++;
        }
        return 0;
    }

    public static void main(String[] args) {
/*        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");*/


        String beginWord = "a";
        String endWord = "c";
        List<String> wordList = new ArrayList<>();
        wordList.add("a");
        wordList.add("b");
        wordList.add("c");


        WordLadder myObj = new WordLadder();
        System.out.println(myObj.ladderLength(beginWord,endWord,wordList));


    }
}
