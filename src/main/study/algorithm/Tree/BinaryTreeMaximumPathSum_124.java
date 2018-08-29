package main.study.algorithm.Tree;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 *
 */
public class BinaryTreeMaximumPathSum_124 {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        localMaxPathSum(root);

        return max;
    }

    public int localMaxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = localMaxPathSum(root.left);
        int rightSum = localMaxPathSum(root.right);

        int localMax = Math.max(rightSum, leftSum) + root.val;
        localMax = Math.max(localMax, root.val);

        max = Math.max(max, localMax);
        max = Math.max(max, leftSum + rightSum + root.val);
        return localMax;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(-10);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        BinaryTreeMaximumPathSum_124 myObj = new BinaryTreeMaximumPathSum_124();
        int maxSum = myObj.maxPathSum(n1);
    }
}
