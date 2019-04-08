package main.company.ama3.dp;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII {

    String[][] visited;
    List<String> ans = new ArrayList<>();
    List<String> wordDict;
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty())
            return ans;

        int N = s.length();
        this.wordDict = wordDict;
        visited = new String[N + 1][N+1];

        dfs(s, 0, new StringBuffer());

        return ans;
    }

    private void dfs(String s, int offset, StringBuffer item) {
        if (offset == s.length()) {
            ans.add(item.toString());
            return;
        }

        for (String word : wordDict) {
            if (s.startsWith(word, offset)) {
                int start = item.length();
                if (item.length() != 0)
                    item.append(" ");
                item.append(word);

                dfs(s, offset + word.length(), item);
                item.delete(start, item.length() - 1);
            }
        }

    }

    public static void main(String[] args) {

    }

}
