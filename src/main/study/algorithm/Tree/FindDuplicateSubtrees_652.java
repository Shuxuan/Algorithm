package main.study.algorithm.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees/description/
 *
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 *
 * Two trees are duplicate if they have the same structure with same node values.
 *
 * Example 1:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * The following are two duplicate subtrees:
 *
 *       2
 *      /
 *     4
 * and
 *
 *     4
 *
 */
public class FindDuplicateSubtrees_652 {

    HashMap<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        postOrder(root, rst);

        return rst;
    }

    private String postOrder(TreeNode root, List<TreeNode> rst) {
        if (root == null) {
            return "#";
        }

        String left = postOrder(root.left, rst);
        String right = postOrder(root.right, rst);

        String s = left + "," + right + "," + Integer.toString(root.val);

        if (map.containsKey(s)) {
            if (map.get(s) == 1) {
                rst.add(root);
                map.put(s, 2);
            }

        } else {
            map.put(s, 1);
        }

        return s;
    }


}
