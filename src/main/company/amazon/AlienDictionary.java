package main.company.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
 *
 * Example 1:
 *
 * Input:
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * Output: "wertf"
 * Example 2:
 *
 * Input:
 * [
 *   "z",
 *   "x"
 * ]
 *
 * Output: "zx"
 * Example 3:
 *
 * Input:
 * [
 *   "z",
 *   "x",
 *   "z"
 * ]
 *
 * Output: ""
 *
 * Explanation: The order is invalid, so return "".
 *
 *
 * DFS的解法，思路和BFS的很类似，
 * 我们需要建立一个二维的bool数组adjMatrix，为了节省空间，不必像上面的解法中一样使用一个HashSet来记录所有出现过的字母，
 * 我们可以直接用这个二维数组来保存这个信息，只要adjMatrix[i][i] = true，即表示位置为i的字母存在。
 * 同时，这个二维数组还可以保存顺序对儿的信息，只要 g[i][j] = true，就知道位置为i的字母顺序在位置为j的字母前面。
 * 找顺序对儿的方法跟上面的解法完全相同，之后我们就可以进行DFS遍历了。
 * 由于DFS遍历需要标记遍历结点，那么就用一个visited数组，
 * 由于是深度优先的遍历，我们并不需要一定要从入度为0的结点开始遍历，而是从任意一个结点开始都可以，
 * DFS会遍历到出度为0的结点为止，加入结果res，然后回溯加上整条路径到结果res，最后把结果res翻转一下即可，
 *
 *
 */
public class AlienDictionary
{
    private final int N = 26;
    private StringBuilder sb;
    private int[]  visited;
    private int[][] adjMatrix;

    public String alienOrder(String[] words)
    {
        if(words==null || words.length==0) return "";
        if(words.length==1) return words[0];

        sb = new StringBuilder();
        visited = new int[N];
        adjMatrix= new int[N][N];

        Arrays.fill(visited, -1);
        buildGraph(words);

        for(int i=0; i<N; i++)
        {
            if(visited[i]==0)
            {
                if(!dfs(i)) return "";
            }
        }

        return sb.reverse().toString();
    }

    /**
     * 图的深度优先搜索。深度优先的关键点在于如何检查环路，
     * 使用visited=0/1/2而不是布尔类型可以解决，
     * 即visited=0表示未访问UNVISITED，
     * 1表示访问中VISITING，
     * 2表示已访问VISITED。
     * 另外，深度优先搜索的话，graph用入边来表示，graph[i][j] = true <=> j->i，这样就容易通过递归方式，
     * 先解决所依赖的节点

     *
     * @param rowIndex
     * @return
     */
    private boolean dfs(int rowIndex)
    {
        if(visited[rowIndex]==2) return true;
        if(visited[rowIndex]==1) return false;

        visited[rowIndex]=1;

        for(int i=0; i<N; i++)
        {
            if (adjMatrix[rowIndex][i]==1)
            {
                if(!dfs(i))
                {
                    return false;
                }
            }
        }

        visited[rowIndex]=2;
        sb.append((char)(rowIndex+'a'));
        return true;
    }

    private void buildGraph(String[] words)
    {
        for(int i=0; i<words.length; i++)
        {
            char[] ary2=words[i].toCharArray();

            for(char c : ary2)
                visited[c - 'a'] = 0;

            if(i==0) continue;

            char[] ary1=words[i-1].toCharArray();

            int len = Math.min(ary1.length, ary2.length);

            for(int j=0; j<len; j++)
            {
                if(ary1[j]!=ary2[j])
                {
                    adjMatrix[ary1[j]-'a'][ary2[j]-'a']=1;
                    break;
                }
            }
        }
    }
}