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
public class SumofDistancesinTree_843 {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[] rst = new int[N];
        if (N == 1) return rst;
        buildMap(edges);


        for (int i = 0; i < N; i++) {
            Set<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();

            queue.add(i);
            int len = 0;
            int sum = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int node = queue.remove();
                    visited.add(node);
                    sum += len;
                    for (int item : map.get(node)) {
                        if (visited.contains(item)) continue;;
                        queue.add(item);
                    }
                }
                len++;
            }
            rst[i] = sum;
        }
        return rst;
    }

    private void buildMap(int[][] edges) {
        if (edges == null || edges.length == 0 || edges[0].length == 0) return;
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if (!map.containsKey(edge[0]))
                map.put(edge[0], new ArrayList<>());
            if (!map.containsKey(edge[1]))
                map.put(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

    }

    public static void main(String[] args) {
        int N = 6;
        SumofDistancesinTree_843 myObj = new SumofDistancesinTree_843();
        int[][] edges = {{0,1},{0,2},{2,3},{2,4},{2,5}};
        System.out.println(Arrays.toString(myObj.sumOfDistancesInTree(N, edges)));
    }

}
