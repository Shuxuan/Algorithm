package main.study.algorithm.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 *
 *
 * For example, given a 3-ary tree:
 *
 *
 *
 *
 * Return its postorder traversal as: [5,6,3,2,4,1].
 */
public class NaryTreePostorderTraversal_590 {

    public List<Integer> postorder(Node root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            rst.add(0, cur.val);
            List<Node> children = cur.children;
            for (int i = 0; i < children.size(); i++) {
                stack.push(children.get(i));
            }

        }

        return rst;
    }

    public List<Integer> postorder_recursion(Node root) {
        List<Integer> rst = new ArrayList<>();
        dfs(root, rst);
        return rst;
    }

    private void dfs(Node root, List<Integer> rst) {
        if (root == null) {
            return;
        }

        for (Node node : root.children) {
            dfs(node, rst);
        }

        rst.add(root.val);

    }
}
