package main.study.algorithm.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/redundant-connection/description/
 *
 * In this problem, a tree is an undirected graph that is connected and has no cycles.
 *
 * The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.
 *
 * Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.
 *
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given undirected graph will be like this:
 *   1
 *  / \
 * 2 - 3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * Output: [1,4]
 * Explanation: The given undirected graph will be like this:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 *
 * Update (2017-09-26):
 * We have overhauled the problem description + test cases and specified clearly the graph is an undirected graph. For the directed graph follow up please see Redundant Connection II). We apologize for any inconvenience caused.
 */
public class RedundantConnection_684 {

    int[] father = null;

    public int[] findRedundantConnection(int[][] edges) {
        /**
         * remove the last edge which makes a circle in the graph
         *
         * how to check if there is a circle in the graph?
         *
         * union find 并查集算法
         *
         * 利用并查集的算法，可以很轻松的解决这道题。遍历输入，在遍历的同时构造集合。
         * 当找到一条边，它的两个端点已经是属于同一个集合中，那么这条边显然是多余的。否则，继续进行并的操作。
         *
         *
         *
         */

        int[] rst = new int[2];

        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            return rst;
        }

        father = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            father[i] = i;
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int xFather = getFather(edge[0]);
            int yFather = getFather(edge[1]);
            if (xFather != yFather) {
                father[yFather] = xFather;
            } else {
                rst[0] = edge[0];
                rst[1] = edge[1];
                break;
            }
        }

        return rst;
    }

    private int getFather(int x) {
        if (father[x] == x) {
            return x;
        } else {
            int xFather = getFather(father[x]);
            father[x] = xFather;
            return xFather;

        }
    }

    private void union(int x, int y) {
        int xFather = getFather(x);
        int yFather = getFather(y);
        father[yFather] = xFather;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2}, {1,3}, {2,3}};
        RedundantConnection_684 myObj = new RedundantConnection_684();
        int[] rst = myObj.findRedundantConnection(edges);
        System.out.println(Arrays.toString(rst));

    }
}
