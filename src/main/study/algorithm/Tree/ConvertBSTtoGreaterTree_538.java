package main.study.algorithm.Tree;


/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
=======

/**
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus sum of all keys greater than the original key in BST.
>>>>>>> Stashed changes
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 */
public class ConvertBSTtoGreaterTree_538 {

    //inorder, right, root, left, and then have a sum to calculate the value and update each element val

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        convertBST(root.right);
        sum += root.val;

        root.val = sum;

        convertBST(root.left);

        return root;
    }


}
