package main.study.algorithm.Tree;

/**
 * https://leetcode.com/problems/longest-univalue-path/description/
 *
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * Example 1:
 *
 * Input:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * Output:
 *
 * 2
 * Example 2:
 *
 * Input:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * Output:
 *
 * 2
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class LongestUnivaluePath {
    int max = 0;
    public int longestUnivaluePath(TreeNode root) {

        helper(root);

        return max;


    }

    /**
     * length with root.val
     *
     * 这道题让我们求最长的相同值路径，跟之前那道Count Univalue Subtrees十分的类似，解法也很类似。
     * 对于这种树的路径问题，递归是不二之选。在递归函数中，我们首先对其左右子结点调用递归函数，得到其左右子树的最大相同值路径，
     * 下面就要来看当前结点和其左右子结点之间的关系了，如果其左子结点存在且和当前节点值相同，则left自增1，否则left重置0；
     * 同理，如果其右子结点存在且和当前节点值相同，则right自增1，否则right重置0。然后用left+right来更新结果res。而调用当前节点值的函数只能返回left和right中的较大值，因为如果还要跟父节点组path，就只能在左右子节点中选一条path，当然选值大的那个了，
     * @param root
     * @return
     */

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        if (root.left != null && root.left.val == root.val) {
            left++;
        } else {
            left = 0;
        }

        if (root.right != null && root.right.val == root.val) {
            right++;
        } else
            right = 0;

        max = Math.max(max, left + right);

        return Math.max(left, right);

    }

}
