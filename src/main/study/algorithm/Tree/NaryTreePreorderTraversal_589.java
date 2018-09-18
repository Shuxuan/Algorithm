package main.study.algorithm.Tree;

import java.util.ArrayList;
import java.util.List;

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
