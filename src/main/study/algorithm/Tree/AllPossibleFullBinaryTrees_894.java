package main.study.algorithm.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/all-possible-full-binary-trees/description/
 *
 * A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 *
 * Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
 *
 * Each node of each tree in the answer must have node.val = 0.
 *
 * You may return the final list of trees in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: 7
 * Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * Explanation:
 *
 *
 *
 * Note:
 *
 * 1 <= N <= 20
 */
public class AllPossibleFullBinaryTrees_894 {

    public List<TreeNode> allPossibleFBT(int N) {

        List<TreeNode> rst = new ArrayList<>();
        if (N == 1) {
            rst.add(new TreeNode(0));
            return rst;
        }

        for (int i = 1; i < N; i = i+2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i - 1);

            for (int l = 0; l < left.size(); l++) {
                for (int r = 0; r < right.size(); r++) {
                    TreeNode root = new TreeNode(0);
                    root.left = left.get(l);
                    root.right = right.get(r);
                    rst.add(root);
                }
            }
        }

        return rst;
    }

}
