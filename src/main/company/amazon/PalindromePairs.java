package main.company.amazon;

import main.company.facebook.PalindromeNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 * Example 1:
 *
 * Input: ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 *
 * Input: ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 *
 */
public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {

            String word = words[i];
            int r = 0;
            while (r <= word.length()) {
                String s1 = word.substring(0, r);
                String s2 = word.substring(r);

                StringBuilder sb = new StringBuilder();
                sb.append(s2);
                sb.reverse();


                if( isPalindrome(s1) && map.containsKey(sb.toString())) {
                        int j = map.get(sb.toString());
                        if (i != j) {
                            List<Integer> item = new ArrayList<>();
                            item.add(map.get(sb.toString()));
                            item.add(map.get(word));
                            res.add(item);
                        }


                }
                r++;
            }


        }


        return res;

    }



    private boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"s", ""};
        PalindromePairs myObj = new PalindromePairs();
        myObj.palindromePairs(words);

    }

}
