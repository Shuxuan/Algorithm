package main.study.algorithm.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 *
 *
 * We should return its level order traversal:
 *
 *
 *
 *
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 *
 * Note:
 *
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class NaryTreeLevelOrderTraversal_429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> rst = new ArrayList<>();

        if (root == null) {
            return rst;
        }

        Queue<Node> queue = new LinkedList<>();
        ((LinkedList<Node>) queue).push(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = ((LinkedList<Node>) queue).pollFirst();
                list.add(cur.val);
                List<Node> children = cur.children;
                queue.addAll(children);

            }
            rst.add(list);

        }
        return rst;
    }

    public static void main(String[] args) {
        Node n5 = new Node(5, new ArrayList<>());
        Node n6 = new Node(6, new ArrayList<>());

        List<Node> children_n3 = new ArrayList<>();
        children_n3.add(n5);
        children_n3.add(n6);

        Node n3 = new Node(3, children_n3);
        Node n2 = new Node(2, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());

        List<Node> children_n1 = new ArrayList<>();
        children_n1.add(n3);
        children_n1.add(n2);
        children_n1.add(n4);

        Node root = new Node(1, children_n1);


        NaryTreeLevelOrderTraversal_429 myObj = new NaryTreeLevelOrderTraversal_429();
        List<List<Integer>> rst = myObj.levelOrder(root);

        for (int i = 0; i < rst.size(); i++) {
            System.out.println("*************************");
            List<Integer> list = rst.get(i);
            for (Integer item : list) {
                System.out.println(item);
            }
        }
    }
}
