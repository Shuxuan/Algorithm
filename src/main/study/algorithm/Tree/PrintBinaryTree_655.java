package main.study.algorithm.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/print-binary-tree/description/
 *
 * Print a binary tree in an m*n 2D string array following these rules:
 *
 * The row number m should be equal to the height of the given binary tree.
 * The column number n should always be an odd number.
 * The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
 * Each unused space should contain an empty string "".
 * Print the subtrees following the same rules.
 * Example 1:
 * Input:
 *      1
 *     /
 *    2
 * Output:
 * [["", "1", ""],
 *  ["2", "", ""]]
 * Example 2:
 * Input:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * Output:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 * Example 3:
 * Input:
 *       1
 *      / \
 *     2   5
 *    /
 *   3
 *  /
 * 4
 * Output:
 *
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * Note: The height of binary tree is in the range of [1, 10].
 */
public class PrintBinaryTree_655 {

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }

        int h = height(root); // row number,
        /**
         * row = 1, col = 1  2^1 - 1
         * row = 2, col = 3  2^2 - 1
         * row = 3, col = 7  2^3 - 1
         * row = 4, col = 15 2^4 - 1
         *
         *
         * It could be fairly easy when we made our first observation on the problem. For the output matrix, the number of rows is height of the tree. What about the number of columns?
         *
         * row = 1 => col = 1 = 2^1 - 1
         * row = 2 => col = 3 = 2^2 - 1
         * row = 3 => col = 7 = 2^3 - 1
         * row = 4 => col = 15 = 2^4 - 1
         * ...
         * row = m => col = 2^m - 1
         * This can be derived from the number of leaves of a full tree (i.e 2^(height - 1)) with spaces joined (i.e 2^(height - 1) - 1).
         *
         * Then we can fill the node in level by level. Another observation is we always print a node at the center of its subtree index range. What I mean is for the left or right child of a node, the subtree rooted at the child will use half of the indices of the node.
         *
         * root is at the center of left and right, say mid
         * root.left (if not null) is at the center of left and mid - 1
         * root.right (if not null) is at the center of mid + 1 and right
         * Then we can easily have our solution as we always keep track of the left and right of the node.
         *
         */

        return rst;

    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

}
