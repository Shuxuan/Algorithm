package main.study.algorithm.Tree;

import java.util.*;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 *
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 *
 * Return its preorder traversal as: [1,3,5,6,2,4].
 *
 */
public class NaryTreePreorderTraversal_589 {

    public List<Integer> preorder(Node root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            rst.add(cur.val);
            List<Node> children = cur.children;
            for (int i = children.size() - 1; i >= 0; i--) {
                stack.add(children.get(i));
            }
        }

        return rst;
    }

    public List<Integer> preorder_recursion(Node root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        dfs (root, rst);

        return rst;
    }

    private void dfs(Node root, List<Integer> rst) {
        if (root == null) {
            return;
        }

        rst.add(root.val);

        for (Node node : root.children) {
            dfs(node, rst);
        }
    }

}
