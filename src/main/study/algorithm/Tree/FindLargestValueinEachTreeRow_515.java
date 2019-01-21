package main.study.algorithm.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 *
 *  You need to find the largest value in each row of a binary tree.
 *
 * Example:
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * Output: [1, 3, 9]
 */
public class FindLargestValueinEachTreeRow_515 {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++){

                TreeNode cur = queue.remove();
                max = Math.max(max, cur.val);
                if (cur.left != null)
                    ((LinkedList<TreeNode>) queue).add(cur.left);

                if (cur.right != null)
                    ((LinkedList<TreeNode>) queue).add(cur.right);
            }

            rst.add(max);

        }

        return rst;
    }
}
