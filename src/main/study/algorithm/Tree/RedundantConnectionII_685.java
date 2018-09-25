package main.study.algorithm.Tree;

/**
 * https://leetcode.com/problems/redundant-connection-ii/description/
 *
 * In this problem, a rooted tree is a directed graph such that, there is exactly one node (the root) for which all other nodes are descendants of this node, plus every node has exactly one parent, except for the root node which has no parents.
 *
 * The given input is a directed graph that started as a rooted tree with N nodes (with distinct values 1, 2, ..., N), with one additional directed edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.
 *
 * The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] that represents a directed edge connecting nodes u and v, where u is a parent of child v.
 *
 * Return an edge that can be removed so that the resulting graph is a rooted tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array.
 *
 * Example 1:
 * Input: [[1,2], [1,3], [2,3]]
 * Output: [2,3]
 * Explanation: The given directed graph will be like this:
 *   1
 *  / \
 * v   v
 * 2-->3
 * Example 2:
 * Input: [[1,2], [2,3], [3,4], [4,1], [1,5]]
 * Output: [4,1]
 * Explanation: The given directed graph will be like this:
 * 5 <- 1 -> 2
 *      ^    |
 *      |    v
 *      4 <- 3
 * Note:
 * The size of the input 2D-array will be between 3 and 1000.
 * Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */
public class RedundantConnectionII_685 {

    /**
     * 这次输入的是一个有向图，且规定：有这么一个结点（根结点），所有的其它结点都是它的子结点。
     * 且除了根结点（入度为0）外的所有结点，都有且只有一个父节点（入度为1）。
     * 在输入中，会有这么一条边：当这条边被移除后，所得到的图才是符合上述条件的图。
     *
     * 根据题意，我们可以得出一个结论：当所要找到的这条边去除后，所得到的图一定是符合条件的。也就是说，这一条边，破坏了原图的合法性。
     *
     * 那么，怎么样的图才是不符合条件的呢：
     *
     * 1 有环图。
     * 因为有环图中不存在入度为0的根结点。
     *
     * 2 存在一个入度为2的结点。由于只需要去掉一条多余的边，就能成为符合条件的图，那么只会存在一个入度为2的结点。其数量只会为1，且入度只会为2。
     * 确定了这两个条件之后，我们可以得到进一步的推论：如果图中有环，则去掉的是环中的一条边。若存在入度为2的结点，那么以该结点为子结点的两条边中，必然有一条就是将要被去除的边。根据上述的推论，可以得到以下算法：
     *
     *
     * 第一种：无环，但是有结点入度为2的结点（结点3）
     *
     * [[1,2], [1,3], [2,3]]
     *
     *   1
     *  / \
     * v   v
     * 2-->3
     *
     *
     * 第二种：有环，没有入度为2的结点
     *
     * [[1,2], [2,3], [3,4], [4,1], [1,5]]
     *
     * 5 <- 1 -> 2
     *      ^    |
     *      |    v
     *      4 <- 3
     *
     *
     * 第三种：有环，且有入度为2的结点（结点1）
     *
     * [[1,2],[2,3],[3,1],[1,4]]
     *
     * 复制代码
     *      4
     *     /
     *    v
     *    1
     *  /  ^
     * v    \
     * 2 -->3
     *
     *  * 在图中寻找一个入度为2的点
     *      *     若 不存在
     *      *         则 图中有环
     *      *         找到最后一条使图成环的边 并返回
     *      *     若 存在
     *      *         获取与该结点相关的两条边A，B
     *      *         将B移除 得到新的图
     *      *         若 新的图符合条件
     *      *             返回B
     *      *         若 不符合条件
     *      *             返回A
     */

    int[] father = null;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] rst = new int[2];
        if (edges == null || edges.length == 0 || edges[0].length == 0) {
            return new int[];
        }

        father = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            father[i] = i;
        }

        return rst;
    }


}
