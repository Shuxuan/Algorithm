package main.study.algorithm.Tree;

import java.util.*;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
 *
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 *
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 *
 * Output: [7,4,1]
 *
 * Explanation:
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 *
 *                        3
 *                     /    \
 *                    5      1
 *                  /  \    / \
 *                 6    2  0   8
 *                     / \
 *                    7   4
 *
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these objects.
 *
 *
 * Note:
 *
 * The given tree is non-empty.
 * Each node in the tree has unique values 0 <= node.val <= 500.
 * The target node is a node in the tree.
 * 0 <= K <= 1000.
 *
 *
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/discuss/143752/JAVA-Graph-+-BFS
 *
 * //Method 1: use HashMap
 * //1. build a undirected graph using treenodes as vertices, and the parent-child relation as edges
 * //2. do BFS with source vertice (target) to find all vertices with distance K to it.
 * class Solution {
 *     Map<TreeNode, List<TreeNode>> map = new HashMap();
 * //here can also use Map<TreeNode, TreeNode> to only store the child - parent mapping, since parent-child mapping is inherent in the tree structure
 *
 *     public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
 *          List<Integer> res = new ArrayList<Integer> ();
 *         if (root == null || K < 0) return res;
 *         buildMap(root, null);
 *         if (!map.containsKey(target)) return res;
 *         Set<TreeNode> visited = new HashSet<TreeNode>();
 *         Queue<TreeNode> q = new LinkedList<TreeNode>();
 *         q.add(target);
 *         visited.add(target);
 *         while (!q.isEmpty()) {
 *             int size = q.size();
 *             if (K == 0) {
 *                 for (int i = 0; i < size ; i++) res.add(q.poll().val);
 *                 return res;
 *             }
 *             for (int i = 0; i < size; i++) {
 *                 TreeNode node = q.poll();
 *                 for (TreeNode next : map.get(node)) {
 *                     if (visited.contains(next)) continue;
 *                     visited.add(next);
 *                     q.add(next);
 *                 }
 *             }
 *             K--;
 *         }
 *         return res;
 *     }
 *
 *     private void buildMap(TreeNode node, TreeNode parent) {
 *         if (node == null) return;
 *         if (!map.containsKey(node)) {
 *             map.put(node, new ArrayList<TreeNode>());
 *             if (parent != null)  { map.get(node).add(parent); map.get(parent).add(node) ; }
 *             buildMap(node.left, node);
 *             buildMap(node.right, node);
 *         }
 *     }
 * }
 *
 * //Method 2: No HashMap
 * //kind of like clone the tree, in the meanwhile add a parent link to the node
 * class Solution {
 *     private GNode targetGNode;
 *
 *     private class GNode {
 *         TreeNode node;
 *         GNode parent, left, right;
 *         GNode (TreeNode node) {
 *             this.node = node;
 *         }
 *     }
 *
 *     public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
 *         List<Integer> res = new ArrayList<Integer> ();
 *         if (root == null || K < 0) return res;
 *         cloneGraph(root, null, target);
 *         if (targetGNode == null) return res;
 *         Set<GNode> visited = new HashSet<GNode>();
 *         Queue<GNode> q = new LinkedList<GNode>();
 *         q.add(targetGNode);
 *         visited.add(targetGNode);
 *         while (!q.isEmpty()) {
 *             int size = q.size();
 *             if (K == 0) {
 *                 for (int i = 0; i < size ; i++) res.add(q.poll().node.val);
 *                 return res;
 *             }
 *             for (int i = 0; i < size; i++) {
 *                 GNode gNode = q.poll();
 *                 if (gNode.left != null && !visited.contains(gNode.left)) { visited.add(gNode.left); q.add(gNode.left); }
 *                 if (gNode.right != null && !visited.contains(gNode.right)) { visited.add(gNode.right); q.add(gNode.right); }
 *                 if (gNode.parent != null && !visited.contains(gNode.parent)) { visited.add(gNode.parent); q.add(gNode.parent); }
 *             }
 *             K--;
 *         }
 *         return res;
 *     }
 *
 *     private GNode cloneGraph(TreeNode node, GNode parent, TreeNode target) {
 *         if (node == null) return null;
 *         GNode gNode = new GNode(node);
 *         if (node == target) targetGNode = gNode;
 *         gNode.parent = parent;
 *         gNode.left = cloneGraph(node.left, gNode, target);
 *         gNode.right = cloneGraph(node.right, gNode, target);
 *         return gNode;
 *     }
 * }
 */
public class AllNodesDistanceKinBinaryTree_863 {

    //1. build a undirected graph using treenodes as vertices, and the parent-child relation as edges
    //2. do BFS with source vertice (target) to find all vertices with distance K to it.
    HashMap<TreeNode, List<TreeNode>> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> rst = new ArrayList<>();
        if (root == null || target == null)
            return rst;
        buildMap(root, null);

        if (!map.containsKey(target))
            return rst;

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (len == K) {
                for (int i = 0; i < size; i++)
                    rst.add(queue.remove().val);
                return rst;
            }

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                for (TreeNode next : map.get(cur)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }

            len++;

        }

        return rst;
    }

    private void buildMap(TreeNode node, TreeNode parent) {
        if (node == null) return;
        if (!map.containsKey(node)) {
            map.put(node, new ArrayList<TreeNode>());
            if (parent != null)  { map.get(node).add(parent); map.get(parent).add(node) ; }
            buildMap(node.left, node);
            buildMap(node.right, node);
        }
    }

}
