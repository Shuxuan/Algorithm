package main.study.algorithm.Tree;

import main.study.algorithm.DynamicProgramming.HouseRobberII_213;

/**
 * https://leetcode.com/problems/house-robber-iii/description/
 *
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 *
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * Output: 7
 * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 *
 * Input: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * Output: 9
 * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
 */
public class HouseRobberIII_337 {



    public int rob(TreeNode root) {
        if(root == null) return 0;
        int l1 = 0,l2 = 0,r1 = 0,r2 = 0 , l = 0 , r = 0;
        if(root.left != null)
        {
            l = rob(root.left);
            l1 = rob(root.left.left);
            l2 = rob(root.left.right);
        }

        if(root.right != null)
        {
            r = rob(root.right);
            r1 = rob(root.right.left);
            r2 = rob(root.right.right);
        }
        return Math.max(root.val+l1+l2+r1+r2,l+r);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(1);
        root.left = n2;
        root.right = n3;
        n2.right = n4;
        n3.right = n5;

        HouseRobberIII_337 myObj = new HouseRobberIII_337();
        System.out.println(myObj.rob(root));


        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);

        t1.left = t2;
        t2.left = t3;
        t3.left = t4;
        System.out.println(myObj.rob(t1));

    }
}
