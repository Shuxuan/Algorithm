package main.study.algorithm.Tree;

import java.util.*;

/**
 * https://leetcode.com/problems/sum-of-distances-in-tree/description/
 *
 * An undirected, connected tree with N nodes labelled 0...N-1 and N-1 edges are given.
 *
 * The ith edge connects nodes edges[i][0] and edges[i][1] together.
 *
 * Return a list ans, where ans[i] is the sum of the distances between node i and all other nodes.
 *
 * Example 1:
 *
 * Input: N = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * Output: [8,12,6,10,10,10]
 * Explanation:
 * Here is a diagram of the given tree:
 *   0
 *  / \
 * 1   2
 *    /|\
 *   3 4 5
 * We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * equals 1 + 1 + 2 + 2 + 2 = 8.  Hence, answer[0] = 8, and so on.
 * Note: 1 <= N <= 10000
 */
public class SumofDistancesinTree_843_Improve {
    /**
     * 解题思路：可以很明显的看出来，如果用f（cur）表示cur节点到其他所有节点的距离之和，
     * f（cur）= f（cur的父节点）- cur的所有子节点个数 * 2 + （N - 2）
     * 因为要知道每一个节点的子节点个数，因此首先要遍历一次整棵树，记录这一信息。
     * 每次只需要知道父节点的信息，因此我们考虑使用层次遍历。而且我们还需要计算出循环的第一个信息，即f（根节点），
     * 这样，就可以得到答案了。
     *
     */
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int sum = 0;
    boolean[] visited;
    int[] numOfChild;
    int[] res;
    Map<Integer, List<Integer>> connected = new HashMap<>();
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        res = new int[N];
        if (N == 1) return res;
        numOfChild = new int[N];
        Arrays.fill(numOfChild, -1);
        visited = new boolean[N];


        /**
         * build undirected graph based on edges
         */
        for (int[] edge : edges) {
            if (!connected.containsKey(edge[0]))
                connected.put(edge[0], new ArrayList<>());
            if (!connected.containsKey(edge[1]))
                connected.put(edge[1], new ArrayList<>());
            connected.get(edge[0]).add(edge[1]);
            connected.get(edge[1]).add(edge[0]);
        }

        /**
         * do a BFS to calculate the numOfChild count of each node
         */

        bfs(0, 0);
        Arrays.fill(visited, false);
        res[0] = sum;
        helper(0, N);
        return res;
    }


    private int bfs(int root, int layer) {
        sum += layer;
        if(numOfChild[root] != -1)
            return numOfChild[root];
        visited[root] = true;
        int num = 0;
        for(int child : connected.get(root)){
            if(visited[child])//如果是上层节点，就不访问
                continue;
            num += bfs(child, layer + 1) + 1;
        }
        numOfChild[root] = num;
        return num;

    }

    private void helper(int root, int N) {
        visited[root] = true;
        for (int child : connected.get(root)) {
            if (visited[child])
                continue;
            int temp = res[root] + N - 2 - 2 * numOfChild[child];
            res[child] = temp;
            helper(child, N);

        }

    }

    public static void main(String[] args) {
        int N = 6;
        SumofDistancesinTree_843_Improve myObj = new SumofDistancesinTree_843_Improve();
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        System.out.println(Arrays.toString(myObj.sumOfDistancesInTree(N, edges)));
    }

}
