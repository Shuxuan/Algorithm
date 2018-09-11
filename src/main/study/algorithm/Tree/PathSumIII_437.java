package main.study.algorithm.Tree;

import apple.laf.JRSUIUtils;

/**
 * https://leetcode.com/problems/path-sum-iii/description/
 *
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class PathSumIII_437 {
    int rst = 0;
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return rst;
        }

        if (root.val == sum) {
            rst++;
            System.out.println("root val : " + root.val);
            System.out.println(rst);
            return rst;
        }

        pathSum(root.left, sum - root.val);
        pathSum(root.right, sum - root.val);
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        return rst;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode l11 = new TreeNode(5);
        TreeNode l12 = new TreeNode( -3);
        root.left = l11;
        root.right = l12;

        TreeNode l21 = new TreeNode(3);
        TreeNode l22 = new TreeNode(2);
        TreeNode l23 = new TreeNode(11);

        l11.left = l21;
        l11.right = l22;
        l12.right = l23;

        TreeNode l31 = new TreeNode(3);
        TreeNode l32 = new TreeNode(-2);
        TreeNode l33 = new TreeNode(1);

        l21.left = l31;
        l21.right = l32;

        l22.right = l33;

        PathSumIII_437 myObj = new PathSumIII_437();
        int rst = myObj.pathSum(root, 8);

        System.out.println(rst);
    }
}
