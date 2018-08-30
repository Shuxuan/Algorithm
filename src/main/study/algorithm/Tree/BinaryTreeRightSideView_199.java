package main.study.algorithm.Tree;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * Example:
 *
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class BinaryTreeRightSideView_199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode cur = null;
            while (size > 0) {
                cur = ((LinkedList<TreeNode>) queue).pop();
                if (cur.left != null) {
                    ((LinkedList<TreeNode>) queue).offerLast(cur.left);
                }
                if (cur.right != null) {
                    ((LinkedList<TreeNode>) queue).offerLast(cur.right);
                }
                size--;
            }
            rst.add(cur.val);

        }

        return rst;
    }

}
