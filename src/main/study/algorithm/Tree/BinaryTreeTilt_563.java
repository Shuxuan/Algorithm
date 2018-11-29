package main.study.algorithm.Tree;

/**
 * https://leetcode.com/problems/binary-tree-tilt/description/
 *
 * Given a binary tree, return the tilt of the whole tree.
 *
 * The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.
 *
 * The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *
 * Example:
 * Input:
 *          1
 *        /   \
 *       2     3
 * Output: 1
 * Explanation:
 * Tilt of node 2 : 0
 * Tilt of node 3 : 0
 * Tilt of node 1 : |2-3| = 1
 * Tilt of binary tree : 0 + 0 + 1 = 1
 */
public class BinaryTreeTilt_563 {
    int sum = 0;
    public int findTilt(TreeNode root) {

        dfs(root);
        return sum;

    }

    private int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }
        dfs(root.left);
        dfs(root.right);
        int sumLeft = sum(root.left);
        int sumRight = sum(root.right);
        int tilt = Math.abs(sumLeft - sumRight);

        sum += tilt;
        return tilt;
    }

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return sum(root.left) + sum(root.right) + root.val;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;

        BinaryTreeTilt_563 myObj = new BinaryTreeTilt_563();
        int tilt = myObj.findTilt(n1);

        System.out.println(tilt);

    }

}
