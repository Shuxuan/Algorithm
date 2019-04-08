package main.company.ama3.dp;

import java.util.List;

public class WordBreak {

    private boolean[] visited = null;

    private List<String> wordDict = null;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        visited = new boolean[s.length()+1];
        this.wordDict = wordDict;
        return dfs(s,0);
    }

    private boolean dfs(String s, int offset) {
        if (offset == s.length()) return true;
        visited[offset] = true;

        for (String word: wordDict) {
            if (s.startsWith(word,offset) && !visited[offset+word.length()]) {
                //We haven't visited here, try it
                if (dfs(s,offset+word.length())) return true;
            }
        }
        return false;
    }

}
