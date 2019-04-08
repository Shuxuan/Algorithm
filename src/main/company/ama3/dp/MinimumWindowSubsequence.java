package main.company.ama3.dp;

import java.util.*;

public class MinimumWindowSubsequence {
    public String minWindow(String S, String T) {
        int N = S.length();
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            char ch = S.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new ArrayList<>());
            }
            map.get(ch).add(i);
        }

        char first_ch = T.charAt(0);
        if (!map.containsKey(first_ch))
            return "";
        List<Integer> first_list = map.get(first_ch);
        List<List<Integer>> candiates = new ArrayList<>();

        for (int i = 0; i < first_list.size(); i++) {
            //iterate each possible subsequence
            int first_pos = first_list.get(i);
            int pre_pos = first_pos;
            boolean flag = false;
            for (int j = 1; j < T.length(); j++) {
                char ch_curr = T.charAt(j);
                //find ch_curr pos
                List<Integer> curr_pos = map.get(ch_curr);
                int k = 0;
                while (k < curr_pos.size() && curr_pos.get(k) <= pre_pos) {
                    k++;
                }

                if (k >= curr_pos.size()) {
                    flag = true;
                    break;
                }

                pre_pos = curr_pos.get(k);
            }

            if (!flag) {
                List<Integer> item = new ArrayList<>();
                item.add(first_pos);
                item.add(pre_pos);
                candiates.add(item);
            }

        }

        int start = -1;
        int end = -1;

        int len = Integer.MAX_VALUE;

        for (List<Integer> item : candiates) {
            if (item.get(1) - item.get(0) < len) {
                len = item.get(1) - item.get(0);
                start = item.get(0);
                end = item.get(1);
            }

        }

        return start == -1 ? "" : S.substring(start, end + 1);

    }

    public static void main(String[] args) {
        String S = "abcdebdde";
        String T = "bde";

        MinimumWindowSubsequence myObj = new MinimumWindowSubsequence();
        System.out.println(myObj.minWindow(S, T));
    }
}
